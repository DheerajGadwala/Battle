package battle;

class FootGear extends SingleAbilityGear {

  protected FootGear(String name, boolean isDetrimental) throws IllegalArgumentException {
    super(name);
    this.setAbility(
        isDetrimental
            ? new Constitution(-randomizer.getIntBetween(1, 3))
            : new Constitution(randomizer.getIntBetween(1, 3))
    );
  }

  protected FootGear(String name, boolean isDetrimental, int ...random)
      throws IllegalArgumentException {
    super(name, random);
    this.setAbility(
        isDetrimental
            ? new Constitution(-randomizer.getIntBetween(1, 3))
            : new Constitution(randomizer.getIntBetween(1, 3))
    );
  }

  @Override
  public int getAbilityMagnitude() {
    return ability.getValue();
  }

  @Override
  public boolean givesDexterity() {
    return true;
  }

  @Override
  public int compareTo(Belt that) {
    return 1;
  }

  @Override
  public int compareTo(FootGear that) {
    return -this.getName().compareTo(that.getName());
  }

  @Override
  public int compareTo(Gear o) {
    if (this == o) {
      return 0;
    }
    AbstractGear that = (AbstractGear) o;
    return that.compareTo(this);
  }

  @Override
  public String toString() {
    return String.format("%s [FootGear], Ability: " + this.ability.toString(), this.name);
  }
}
