package battle;

class Potion extends SingleAbilityGear {

  public Potion(String name, boolean isDetrimental) {
    super(name);
    this.setAbility(randomizer.getAbility(isDetrimental));
  }

  public Potion(String name, boolean isDetrimental, int ...random) {
    super(name, random);
    this.setAbility(randomizer.getAbility(isDetrimental));
  }

  @Override
  public int getAbilityMagnitude() {
    return this.ability.getValue();
  }

  @Override
  public boolean givesStrength() {
    return ability.isStrength();
  }

  @Override
  public boolean givesCharisma() {
    return ability.isCharisma();
  }

  @Override
  public boolean givesConstitution() {
    return ability.isConstitution();
  }

  @Override
  public boolean givesDexterity() {
    return ability.isDexterity();
  }

  @Override
  public int compareTo(Potion that) {
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
    return String.format("%s [Potion], Ability: " + this.ability.toString(), this.name);
  }
}
