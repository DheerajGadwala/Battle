package battle;

abstract class AbstractAbility implements Ability {

  protected int value;

  protected AbstractAbility(int value) {
    this.value = value;
  }

  @Override
  public int getValue() {
    return value;
  }

  protected boolean isCharisma() {
    return false;
  }

  protected boolean isDexterity() {
    return false;
  }

  protected boolean isStrength() {
    return false;
  }

  protected boolean isConstitution() {
    return false;
  }
}
