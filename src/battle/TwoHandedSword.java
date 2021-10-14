package battle;

class TwoHandedSword extends Sword {

  public TwoHandedSword(String name) {
    super(name);
  }

  TwoHandedSword(String name, int ...random) {
    super(name, random);
  }

  @Override
  public boolean isTwoHandedSword() {
    return true;
  }

  @Override
  public double getDamage() {
    if (this.wielder.effectiveStrength() < 15) {
      return randomizer.getIntBetween(8, 12) / 2.0;
    }
    else {
      return randomizer.getIntBetween(8, 12);
    }
  }
}
