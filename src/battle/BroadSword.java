package battle;

/**
 * This a type of weapon.
 */
public class BroadSword extends Sword {

  /**
   * Creates a broad sword object.
   * @param name name of the broad sword
   */
  public BroadSword(String name) {
    super(name);
  }

  /**
   * Creates a broad sword object with pseudo random damage outputs.
   * @param name name of the sword.
   * @param random given random numbers.
   */
  public BroadSword(String name, int... random) {
    super(name, random);
  }

  /**
   * Creates a broad sword object whose output damage is either random
   * or pseudo random based on the given randomizer type.
   * @param name name of the broad sword
   * @param randomizer a randomizer object.
   */
  public BroadSword(String name, Randomizer randomizer) {
    super(name, randomizer);
  }

  @Override
  public boolean isBroadSword() {
    return true;
  }

  @Override
  public double getDamage() {
    return randomizer.getIntBetween(6, 10);
  }

  @Override
  public double getMaxDamage() {
    return 10;
  }

  @Override
  public String toString() {
    return String.format("Name: %s, Type: Broad sword", name);
  }
}
