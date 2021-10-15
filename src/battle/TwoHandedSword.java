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
    AbstractPlayer p = (AbstractPlayer)this.wielder;
    if(p.isBattlePlayer()) {
        BattlePlayer bp = (BattlePlayer)p;
      if (bp.effectiveStrength() < 15) {
        return randomizer.getIntBetween(8, 12) / 2.0;
      }
      else {
        return randomizer.getIntBetween(8, 12);
      }
    }
    throw new IllegalStateException("Invalid player type");
  }

  @Override
  public String toString() {
    return String.format("Name: %s, Type: Two handed sword", name);
  }
}
