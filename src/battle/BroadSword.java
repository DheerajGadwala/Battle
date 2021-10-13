package battle;

class BroadSword extends Sword {

  public BroadSword(String name) {
    super(name);
  }

  public BroadSword(String name, int ...random) {
    super(name, random);
  }

  @Override
  public boolean isBroadSword() {
    return true;
  }

  @Override
  public double getDamage() {
    return randomizer.getIntBetween(6, 10);
  }
}
