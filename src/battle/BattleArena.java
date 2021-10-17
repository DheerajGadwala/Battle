package battle;

/**
 * A battle arena can have two players and allows them to fight.
 * This contains an armoury and a bag of gears.
 */
public class BattleArena implements Battle {

  private final Randomizer randomizer;
  private Player one;
  private Player two;
  private Container bagOfGears;
  private Container armoury;
  private Player winner;

  /**
   * Creates a battle Arena object which is enables actual random battles.
   */
  public BattleArena() {
    randomizer = new ActualRandomizer();
    constructionHelper();
  }

  /**
   * Creates battle Arena which enables pseudo random battles.
   * @param random random numbers.
   */
  public BattleArena(int ...random) {
    randomizer = new PseudoRandomizer(random);
    constructionHelper();
  }

  /**
   * Creates a battle arena of which is wither random or pseudo random, based on the input.
   * @param randomizer a randomizer object
   */
  public BattleArena(Randomizer randomizer) {
    this.randomizer = randomizer;
    constructionHelper();
  }

  private void constructionHelper() {
    bagOfGears = new BagOfGears(randomizer);
    armoury = new Armoury(randomizer);
    bagOfGears.generateRandom();
    armoury.generateRandom();
    bagOfGears.shuffle();
    armoury.shuffle();
  }

  @Override
  public String getWinnerNameOrDraw() {
    if (winner == null) {
      return "draw";
    }
    return winner.getName();
  }


  private boolean playersAreNotNew() {
    return !one.isNewPlayer() || !two.isNewPlayer();
  }

  private boolean playersAreNotNew(Player one, Player two) {
    return !one.isNewPlayer() || !two.isNewPlayer();
  }

  private boolean playersAreNull() {
    return one == null || two == null;
  }

  private boolean playersAreNull(Player one, Player two) {
    return one == null || two == null;
  }

  @Override
  public void addPlayers(Player one, Player two) throws IllegalArgumentException {
    if (playersAreNull(one, two)) {
      throw new IllegalArgumentException("Players can not be null.");
    }
    else if (playersAreNotNew(one, two)) {
      throw new IllegalArgumentException("Players are not new");
    }
    this.one = one;
    this.two = two;
    distributeGear();
  }

  @Override
  public void distributeGear() {
    int counter = 0;
    while (counter < 20) {
      counter++;
      try {
        ((BattlePlayer)one).equipGear((Gear) bagOfGears.seize());
      }
      catch (IllegalStateException ignored) {
        continue;
      }
    }
    while (counter < 40) {
      counter++;
      try {
        ((BattlePlayer)two).equipGear((Gear) bagOfGears.seize());
      }
      catch (IllegalStateException ignored) {
        continue;
      }
    }
  }

  @Override
  public void grantWeapons() {
    ((BattlePlayer)one).assignWeapon((Weapon) armoury.seize());
    ((BattlePlayer)two).assignWeapon((Weapon) armoury.seize());
  }

  private BattlePlayer getHigherCharismaPlayer() {
    return (BattlePlayer)
        (one.effectiveCharisma() >= two.effectiveCharisma() ? one : two);
  }

  private BattlePlayer getLowerCharismaPlayer() {
    return (BattlePlayer)
        (one.effectiveCharisma() < two.effectiveCharisma() ? one : two);
  }

  @Override
  public String fight() {
    if (playersAreNull()) {
      throw new IllegalArgumentException("Need 2 players to start the fight");
    }
    if (playersAreNotNew()) {
      flush();
    }
    StringBuilder ret = new StringBuilder("");
    ret.append("------------------------NEW MATCH---------------------\n");
    ret.append("Player Stats with new equipment: \n");
    ret.append(one.toString() + "\n");
    ret.append(two.toString() + "\n");
    BattlePlayer current = getHigherCharismaPlayer();
    BattlePlayer notCurrent = getLowerCharismaPlayer();
    if (
        current.effectiveStrength()
        + current.getWeaponMaxDamage()
        - notCurrent.effectiveConstitution() - 6
        <= 0
        &&
        notCurrent.effectiveStrength()
        + notCurrent.getWeaponMaxDamage()
        - current.effectiveConstitution() - 6
        <= 0
        ) {
      winner = null;
      ret.append("This set leads to a draw because both players are not strong enough to "
          + "break the other's defense.\n[clue: this happens when both players' strength and "
          + "their weapon's damage is not enough to beat their opponent's constitution]\n");
    }
    else if (
        current.effectiveStrength() + 10
        - notCurrent.effectiveDexterity() - 1
        <= 0
        &&
        notCurrent.effectiveStrength() + 10
        - current.effectiveDexterity() - 1
        <= 0
    ) {
      winner = null;
      ret.append("This set leads to a draw because both players can always evade each other."
          + "\n[clue: this happens when both players have low strength but high dexterity]\n");
    }
    else {
      ret.append(
          "Initial healths: \n"
          + current.getName() + "'s health: "
          + current.getHealth() + ","
          + notCurrent.getName() + "'s health: "
          + notCurrent.getHealth() + "\n"
          + notCurrent.getName()
          + " has been dazzled, "
          + current.getName()
          + " will attack first.\n\n"
      );
      int round = 1;
      while (current.isAlive()) {
        ret.append(
            "Round " + round + ": "
            + current.getName() + " attacks "
            + notCurrent.getName() + "\n"
        );
        double damage = -current.attack(notCurrent);
        if (damage == 0) {
          ret.append(notCurrent.getName() + " has evaded the attack!\n");
        }
        else {
          ret.append(notCurrent.getName() + " has lost " + (-damage) + " health\n");
        }
        ret.append(
            one.getName() + "'s health: "
            + one.getHealth() + ", "
            + two.getName()
            + "'s health: "
            + two.getHealth() + "\n\n"
        );
        BattlePlayer temp = current;
        current = notCurrent;
        notCurrent = temp;
        round++;
      }
      ret.append(notCurrent.getName() + " has won!\n");
    }
    winner = notCurrent;
    return new String(ret);
  }

  void flush() {
    BattlePlayer o = ((BattlePlayer)one);
    BattlePlayer t = ((BattlePlayer)two);
    o.flush(); //remove gear and weapon
    t.flush(); // remove gear and weapon
    constructionHelper(); // create new gear and weapons
    distributeGear(); // distribute the gear
    grantWeapons(); // give weapons to players
    winner = null;
  }
}
