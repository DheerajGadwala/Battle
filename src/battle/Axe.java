package battle;

/**
 * Axe is a type of weapon.
 */
public class Axe extends AbstractWeapon {

  /**
   * Used to create Axe objects.
   * @param name anme of the axe
   */
  public Axe(String name) {
    super(name);
  }

  /**
   * Used to create axe objects with pseudo random damage.
   * @param name name of the axe
   * @param random pseudo random digits
   */
  public Axe(String name, int... random) {
    super(name, random);
  }

  /**
   * Used to create an axe object with damage depending on the given randomizer.
   * @param name name of the axe
   * @param randomizer A randomizer object
   */
  public Axe(String name, Randomizer randomizer) {
    super(name, randomizer);
  }

  @Override
  public boolean isAxe() {
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
    return String.format("Name: %s, Type: Axe", name);
  }
}
