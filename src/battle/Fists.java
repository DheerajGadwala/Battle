package battle;

/**
 * Fists are a type of weapon. They are the default weapons when players are created.
 */
public class Fists extends AbstractWeapon {

  /**
   * Creates fists object.
   * @param name name of the fists.
   */
  public Fists(String name) {
    super(name);
  }

  /**
   * Creates fists object.
   * @param name name of the fists.
   * @param randomizer a randomizer object.
   */
  public Fists(String name, Randomizer randomizer) {
    super(name, randomizer);
  }

  @Override
  public double getDamage() {
    return 1;
  }

  @Override
  public double getMaxDamage() {
    return 1;
  }

  @Override
  public boolean isFists() {
    return true;
  }

  @Override
  public String toString() {
    return String.format("Name: %s, Type: Fists", name);
  }
}
