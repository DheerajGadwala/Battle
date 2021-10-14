package battle;

abstract class AbstractWeapon implements Weapon {

  protected final String name;
  protected HumanPlayer wielder;
  protected final Randomizer randomizer;

  protected AbstractWeapon(String name) {
    this.name = name;
    randomizer = new ActualRandomizer();
  }

  protected AbstractWeapon(String name, int ...random) {
    this.name = name;
    randomizer = new PseudoRandomizer(random);
  }

  void setWielder(HumanPlayer wielder) {
    this.wielder = wielder;
  }

  @Override
  public String getName() {
    return this.name;
  }

  protected boolean isAxe() {
    return false;
  }

  protected boolean isFlail() {
    return false;
  }

  protected boolean isTwoHandedSword() {
    return false;
  }

  protected boolean isBroadSword() {
    return false;
  }

  protected boolean isKatanas() {
    return false;
  }
}
