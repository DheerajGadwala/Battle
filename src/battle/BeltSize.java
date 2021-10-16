package battle;

/**
 * Size of the belt.
 * They are of three sizes: LARGE, MEDIUM and SMALL
 */
public enum BeltSize {
  SMALL(1), MEDIUM(2), LARGE(4);

  private final int size;

  BeltSize(int size) {
    this.size = size;
  }

  public int getSize() {
    return size;
  }
}
