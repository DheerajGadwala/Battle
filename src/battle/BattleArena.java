package battle;

public class BattleArena extends AbstractBattle {

  public BattleArena(Player one, Player two) {
    super(one, two);
  }

  BattleArena(Player one, Player two, int ...random) {
    super(one, two, random);
  }

//  @Override
//  public void addPlayerOne(Player player) throws IllegalArgumentException, IllegalStateException {
//    AbstractPlayer temp = (AbstractPlayer) player;
//    if(!temp.isBattlePlayer()) {
//      throw new IllegalArgumentException("Illegal type of player");
//    }
//    if(this.one != null) {
//      throw new IllegalStateException("Player one already exists");
//    }
//    this.one = temp;
//  }
//
//  @Override
//  public void addPlayerTwo(Player player) throws IllegalArgumentException, IllegalStateException {
//    AbstractPlayer temp = (AbstractPlayer) player;
//    if(!temp.isBattlePlayer()) {
//      throw new IllegalArgumentException("Illegal type of player");
//    }
//    if(this.two != null) {
//      throw new IllegalStateException("Player two already exists");
//    }
//    this.two = temp;
//  }

  @Override
  public void distributeGear() {
    int counter = 0;
    while(counter < 20) {
      try {
        one.equipGear((Gear) bagOfGears.seize());
      }
      catch(IllegalStateException ise) {
      }
      counter++;
    }
    while(counter < 40) {
      try {
        two.equipGear((Gear) bagOfGears.seize());
      }
      catch(IllegalStateException ise) {
      }
      counter++;
    }
  }

  @Override
  public void grantWeapons() {
    one.assignWeapon((Weapon) armoury.seize());
    two.assignWeapon((Weapon) armoury.seize());
  }

  @Override
  public void startBattle() {
    System.out.println(one);
    System.out.println(two);
    System.out.println("Initial healths: \nhealth A: "+one.health+", health B: "+two.health);
    int round = 1;

    while(one.isAlive() && two.isAlive()) {
      System.out.println("Round: " + round++);
      one.attack(two);
      System.out.println("health A: "+one.health+", health B: "+two.health);
      System.out.println("Round: " + round++);
      two.attack(one);
      System.out.println("health A: "+one.health+", health B: "+two.health);
    }

  }
}
