package battle;

abstract class Sword extends AbstractWeapon {

  protected Sword(String name) {
    super(name);
  }

  protected Sword(String name, int ...random) {
    super(name, random);
  }

  public Sword(String name, Randomizer randomizer) {
    super(name, randomizer);
  }

  @Override
  public String getName() {
    return null;
  }

  @Override
  public boolean isSword() {
    return true;
  }

}
