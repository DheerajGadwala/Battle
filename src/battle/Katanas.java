package battle;

class Katanas extends Sword {
  public Katanas(String name) {
    super(name);
  }

  Katanas(String name, int ...random) {
    super(name, random);
  }

  @Override
  public boolean isKatanas() {
    return true;
  }

  @Override
  public double getDamage() {
    return randomizer.getIntBetween(4, 6);
  }

  @Override
  public String toString() {
    return String.format("Name: %s, Type: Katanas", name);
  }
}
