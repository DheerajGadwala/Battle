package battle;

/**
 * Potion is a type of gear.
 * A player can any number of potions.
 * Potions might give any ability.
 */
public class Potion extends SingleAbilityGear {
  /**
   * Creates a potion object.
   * @param name name of the potion
   * @param isDetrimental if the ability of the potion is detrimental or not
   * @throws IllegalArgumentException when name is null or empty
   */
  public Potion(String name, boolean isDetrimental) throws IllegalArgumentException {
    super(name);
    this.setAbility(randomizer.getAbility(isDetrimental));
  }

  /**
   * Creates a potion object with pseudo random abilities.
   * @param name name of the potion
   * @param isDetrimental if the ability of the potion is detrimental or not
   * @param random random numbers.
   * @throws IllegalArgumentException when name is empty or null
   */
  public Potion(String name, boolean isDetrimental, int... random)
      throws IllegalArgumentException {
    super(name, random);
    this.setAbility(randomizer.getAbility(isDetrimental));
  }

  /**
   * Creates a potion object whose ability depends on the given randomizer.
   * @param name name of the potion
   * @param isDetrimental if the ability of the potion is detrimental or not
   * @param randomizer a randomizer object
   * @throws IllegalArgumentException when name is empty or null
   */
  public Potion(String name, boolean isDetrimental, Randomizer randomizer) {
    super(name, randomizer);
    this.setAbility(randomizer.getAbility(isDetrimental));
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
  public boolean isPotion() {
    return true;
  }

  @Override
  public int compareTo(Potion that) {
    return -this.getName().compareTo(that.getName());
  }

  @Override
  public int compareTo(Gear that) {
    if (this == that) {
      return 0;
    }
    return that.compareTo(this);
  }

  @Override
  public String toString() {
    return String.format("%s [Potion], Ability: " + this.ability.toString(), this.name);
  }
}
