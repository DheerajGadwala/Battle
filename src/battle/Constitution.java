package battle;

class Constitution extends AbstractAbility {

  public Constitution(int value) {
    super(value);
  }

  @Override
  public boolean isConstitution() {
    return true;
  }

  @Override
  public String toString() {
    return String.format("Constitution: %d", value);
  }
}
