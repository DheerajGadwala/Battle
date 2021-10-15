package battle;

class Flail extends AbstractWeapon {

  public Flail(String name) {
    super(name);
  }

  Flail(String name, int ...random) {
    super(name, random);
  }

  @Override
  public boolean isFlail() {
    return true;
  }

  @Override
  public double getDamage() {
    AbstractPlayer p = (AbstractPlayer) wielder;
    if(p.isBattlePlayer()) {
      BattlePlayer bp = (BattlePlayer)p;
      if (bp.effectiveDexterity() < 15) {
        return randomizer.getIntBetween(8, 12) / 2.0;
      }
      else {
        return randomizer.getIntBetween(8, 12);
      }
    }
    throw new IllegalStateException("Invalid player type.");
  }

  @Override
  public String toString() {
    return String.format("Name: %s, Type: Flail", name);
  }

}
