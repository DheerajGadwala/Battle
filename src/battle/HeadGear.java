package battle;

/**
 * Head gear is a type of gear.
 * A player can have at most one head gear.
 * Foot gears give an improvement on constitution.
 */
public class HeadGear extends SingleAbilityGear {

  /**
   * Creates a head gear object.
   * @param name name of the head gear
   * @param isDetrimental if the ability of the head gear is detrimental or not
   * @throws IllegalArgumentException when name is null or empty
   */
  public HeadGear(String name, boolean isDetrimental)
      throws IllegalArgumentException {
    super(name);
    this.setAbility(
        isDetrimental
            ? new Constitution(-randomizer.getIntBetween(1, 3))
            : new Constitution(randomizer.getIntBetween(1, 3))
    );
  }

  /**
   * Creates a head gear object with pseudo random abilities.
   * @param name name of the head gear
   * @param isDetrimental if the ability of the head gear is detrimental or not
   * @param random random numbers.
   * @throws IllegalArgumentException when name is empty or null
   */
  public HeadGear(String name, boolean isDetrimental, int... random)
      throws IllegalArgumentException {
    super(name, random);
    this.setAbility(
        isDetrimental
            ? new Constitution(-randomizer.getIntBetween(1, 3))
            : new Constitution(randomizer.getIntBetween(1, 3))
    );
  }

  /**
   * Creates a head gear object whose ability depends on the given randomizer.
   * @param name name of the head gear
   * @param isDetrimental if the ability of the head gear is detrimental or not
   * @param randomizer a randomizer object
   * @throws IllegalArgumentException when name is empty or null
   */
  public HeadGear(String name, boolean isDetrimental, Randomizer randomizer)
      throws IllegalArgumentException {
    super(name, randomizer);
    this.setAbility(
        isDetrimental
            ? new Constitution(-randomizer.getIntBetween(1, 3))
            : new Constitution(randomizer.getIntBetween(1, 3))
    );
  }

  @Override
  public boolean givesConstitution() {
    return true;
  }

  @Override
  public boolean isHeadGear() {
    return true;
  }

  @Override
  public int compareTo(Potion that) {
    return 1;
  }

  @Override
  public int compareTo(HeadGear that) {
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
    return String.format("%s [HeadGear], Ability: " + this.ability.toString(), this.name);
  }
}
