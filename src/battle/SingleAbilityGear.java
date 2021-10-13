package battle;

abstract class SingleAbilityGear extends AbstractGear {

  protected final String name;
  protected AbstractAbility ability;

  protected SingleAbilityGear(String name)
      throws IllegalArgumentException {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Gear name can not be null or empty.");
    }
    this.name = name;
  }

  protected SingleAbilityGear(String name, int ...random) {
    super(random);
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Gear name can not be null or empty.");
    }
    this.name = name;
  }

  protected void setAbility(AbstractAbility ability) {
    this.ability = ability;
  }

  abstract int getAbilityMagnitude();

  public String getName() {
    return this.name;
  }

  protected boolean givesCharisma() {
    return false;
  }

  protected boolean givesStrength() {
    return false;
  }

  protected boolean givesConstitution() {
    return false;
  }

  protected boolean givesDexterity() {
    return false;
  }
}
