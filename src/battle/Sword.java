package battle;

abstract class Sword extends AbstractWeapon {

  protected Sword(String name) {
    super(name);
  }

  protected Sword(String name, int ...random) {
    super(name, random);
  }

  @Override
  public String getName() {
    return null;
  }

}
