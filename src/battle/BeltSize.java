package battle;

enum BeltSize {
  SMALL(1), MEDIUM(2), LARGE(4);

  private final int size;

  BeltSize(int size) {
    this.size = size;
  }

  public int getSize() {
    return size;
  }
}
