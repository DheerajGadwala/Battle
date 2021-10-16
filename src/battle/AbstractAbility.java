package battle;

abstract class AbstractAbility implements Ability {

  protected int value;

  protected AbstractAbility(int value) {
    this.value = value;
  }

  @Override
  public int getMagnitude() {
    return value;
  }

}
