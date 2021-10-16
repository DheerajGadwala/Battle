package battle;

/**
 * This is a type of ability.
 */
public class Constitution extends AbstractAbility {
  /**
   * Creates a Constitution object with the given magnitude.
   * @param value magnitude of the ability.
   */
  public Constitution(int value) {
    super(value);
  }

  @Override
  public boolean isConstitution() {
    return true;
  }

  @Override
  public String toString() {
    return String.format("Constitution: %d", value);
  }
}
