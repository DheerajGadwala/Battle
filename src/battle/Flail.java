package battle;

/**
 * Flail is a type of weapon.
 * Its damage depends on players' dexterity.
 */
public class Flail extends AbstractWeapon {
  /**
   * Creates a Flail object.
   * @param name name of the weapon
   */
  public Flail(String name) {
    super(name);
  }

  /**
   * Creates a Flail object with pseudo random values for damages.
   * @param name name of the weapon
   * @param random random numbers
   */
  public Flail(String name, int... random) {
    super(name, random);
  }

  /**
   * Creates a Flail object whose damage might be random or
   * pseudo random depending on the given randomizer object.
   * @param name name of the weapon
   * @param randomizer a randomizer object
   */
  public Flail(String name, Randomizer randomizer) {
    super(name, randomizer);
  }

  @Override
  public boolean isFlail() {
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
    return String.format("Name: %s, Type: Flail", name);
  }

}
