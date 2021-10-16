package battle;

/**
 * Foot gear is a type of gear.
 * A player can have at most one foot gear.
 * Foot gears give an improvement on dexterity.
 */
public class FootGear extends SingleAbilityGear {

  /**
   * Creates a foot gear object.
   * @param name name of the foot gear
   * @param isDetrimental if the ability of the foot gear is detrimental or not
   * @throws IllegalArgumentException when name is null or empty
   */
  public FootGear(String name, boolean isDetrimental) throws IllegalArgumentException {
    super(name);
    this.setAbility(
        isDetrimental
            ? new Dexterity(-randomizer.getIntBetween(1, 3))
            : new Dexterity(randomizer.getIntBetween(1, 3))
    );
  }

  /**
   * Creates a foot gear object with pseudo random abilities.
   * @param name name of the foot gear
   * @param isDetrimental if the ability of the foot gear is detrimental or not
   * @param random random numbers.
   * @throws IllegalArgumentException when name is empty or null
   */
  public FootGear(String name, boolean isDetrimental, int... random)
      throws IllegalArgumentException {
    super(name, random);
    this.setAbility(
        isDetrimental
            ? new Dexterity(-randomizer.getIntBetween(1, 3))
            : new Dexterity(randomizer.getIntBetween(1, 3))
    );
  }

  /**
   * Creates a foot gear object whose ability depends on the given randomizer.
   * @param name name of the foot gear
   * @param isDetrimental if the ability of the foot gear is detrimental or not
   * @param randomizer a randomizer object
   * @throws IllegalArgumentException when name is empty or null
   */
  public FootGear(String name, boolean isDetrimental, Randomizer randomizer)
      throws IllegalArgumentException {
    super(name, randomizer);
    this.setAbility(
        isDetrimental
            ? new Dexterity(-randomizer.getIntBetween(1, 3))
            : new Dexterity(randomizer.getIntBetween(1, 3))
    );
  }

  @Override
  public boolean givesDexterity() {
    return true;
  }

  @Override
  public boolean isFootGear() {
    return true;
  }

  @Override
  public int compareTo(Belt that) {
    return -1;
  }

  @Override
  public int compareTo(FootGear that) {
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
    return String.format("%s [FootGear], Ability: " + this.ability.toString(), this.name);
  }
}
