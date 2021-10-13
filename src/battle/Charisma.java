package battle;

class Charisma extends AbstractAbility {

  public Charisma(int value) {
    super(value);
  }

  @Override
  public boolean isCharisma() {
    return true;
  }

  @Override
  public String toString() {
    return String.format("Charisma: %d", value);
  }
}
