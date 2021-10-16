package battle;

/**
 * Two handed sword is a type of sword.
 * Its damage depends on players' strength.
 */
public class TwoHandedSword extends Sword {

  /**
   * Creates a TwoHandedSword object.
   * @param name name of the weapon
   */
  public TwoHandedSword(String name) {
    super(name);
  }

  /**
   * Creates a TwoHandedSword object with pseudo random values for damages.
   * @param name name of the weapon
   * @param random random numbers
   */
  public TwoHandedSword(String name, int... random) {
    super(name, random);
  }

  /**
   * Creates a TwoHandedSword object whose damage might be random or
   * pseudo random depending on the given randomizer object.
   * @param name name of the weapon
   * @param randomizer a randomizer object
   */
  public TwoHandedSword(String name, Randomizer randomizer) {
    super(name, randomizer);
  }

  @Override
  public boolean isTwoHandedSword() {
    return true;
  }

  @Override
  public double getDamage() {
    return randomizer.getIntBetween(8, 12);
  }

  @Override
  public double getMaxDamage() {
    return 12;
  }

  @Override
  public String toString() {
    return String.format("Name: %s, Type: Two handed sword", name);
  }
}
