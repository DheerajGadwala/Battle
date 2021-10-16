package battle;

abstract class AbstractWeapon implements Weapon {

  protected final String name;
  protected final Randomizer randomizer;

  protected AbstractWeapon(String name) {
    checkName(name);
    this.name = name;
    randomizer = new ActualRandomizer();
  }

  protected AbstractWeapon(String name, int ...random) {
    checkName(name);
    this.name = name;
    randomizer = new PseudoRandomizer(random);
  }

  protected AbstractWeapon(String name, Randomizer randomizer) {
    checkName(name);
    this.name = name;
    this.randomizer = randomizer;
  }

  private void checkName(String name) throws IllegalArgumentException {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Name can not be null or empty");
    }
  }

  @Override
  public String getName() {
    return this.name;
  }

}
