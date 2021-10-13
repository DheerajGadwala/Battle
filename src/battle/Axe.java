package battle;

class Axe extends AbstractWeapon {

  public Axe(String name) {
    super(name);
  }

  public Axe(String name, int ...random) {
    super(name, random);
  }

  @Override
  public boolean isAxe() {
    return true;
  }

  @Override
  public double getDamage() {
    return randomizer.getIntBetween(6, 10);
  }
}
