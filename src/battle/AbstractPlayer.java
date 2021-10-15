package battle;

abstract class AbstractPlayer implements Player {

  protected final Randomizer randomizer;
  protected final String name;
  protected GearList gear;
  protected double health;
  protected Weapon weapon;

  protected AbstractPlayer(String name) throws IllegalArgumentException {
    constructionHelper(name);
    this.name = name;
    this.gear = new EmptyGearNode();
    this.randomizer = new ActualRandomizer();
  }

  protected AbstractPlayer(String name, int ...random) {
    constructionHelper(name);
    this.name = name;
    this.gear = new EmptyGearNode();
    this.randomizer = new PseudoRandomizer(random);
  }

  private void constructionHelper(String name) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Name can not be null or empty");
    }
  }

  @Override
  public String getName() {
    return name;
  }

  protected boolean isBattlePlayer() {
    return false;
  }

  abstract boolean isAlive();

  abstract void assignWeapon(Weapon weapon);

  abstract void flush();

  abstract void attack(AbstractPlayer two);
}
