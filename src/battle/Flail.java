package battle;

class Flail extends AbstractWeapon {

  public Flail(String name) {
    super(name);
  }

  public Flail(String name, int ...random) {
    super(name, random);
  }

  @Override
  public boolean isFlail() {
    return true;
  }

  @Override
  public double getDamage() {
    if (this.wielder.effectiveDexterity() < 15) {
      return randomizer.getIntBetween(8, 12) / 2.0;
    }
    else {
      return randomizer.getIntBetween(8, 12);
    }
  }
}
