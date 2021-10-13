package battle;

class Strength extends AbstractAbility {

  public Strength(int value) {
    super(value);
  }

  @Override
  public boolean isStrength() {
    return true;
  }

  @Override
  public String toString() {
    return String.format("Strength: %d", value);
  }
}
