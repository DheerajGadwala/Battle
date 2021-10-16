package battle;

/**
 * This a type of weapon.
 * They come in pairs.
 */
public class Katanas extends Sword {

  /**
   * Creates a Katanas object.
   * @param name name of the broad sword
   */
  public Katanas(String name) {
    super(name);
  }

  /**
   * Creates a katanas object with pseudo random damage outputs.
   * @param name name of the sword
   * @param random given random numbers
   */
  public Katanas(String name, int... random) {
    super(name, random);
  }

  /**
   * Creates a katanas object whose output damage is either random
   * or pseudo random based on the given randomizer type.
   * @param name name of the katanas
   * @param randomizer a randomizer object
   */
  public Katanas(String name, Randomizer randomizer) {
    super(name, randomizer);
  }

  @Override
  public boolean isKatanas() {
    return true;
  }

  @Override
  public double getDamage() {
    return randomizer.getIntBetween(4, 6) + randomizer.getIntBetween(4, 6);
  }

  @Override
  public double getMaxDamage() {
    return 12;
  }

  @Override
  public String toString() {
    return String.format("Name: %s, Type: Katanas", name);
  }
}
