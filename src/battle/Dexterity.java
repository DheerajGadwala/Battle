package battle;

class Dexterity extends AbstractAbility {

  public Dexterity(int value) {
    super(value);
  }

  @Override
  public boolean isDexterity() {
    return true;
  }

  @Override
  public String toString() {
    return String.format("Dexterity: %d", value);
  }
}
