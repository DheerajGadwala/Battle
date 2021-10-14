package battle;

abstract class AbstractGear implements Gear {

  protected final Randomizer randomizer;

  protected final String name;

  protected AbstractGear(String name) {
    this.randomizer = new ActualRandomizer();
    constructionHelper(name);
    this.name = name;
  }

  protected AbstractGear(String name, int ...random) {
    this.randomizer = new PseudoRandomizer(random);
    constructionHelper(name);
    this.name = name;
  }

  private void constructionHelper(String name) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Name can not be null or empty.");
    }
  }

  protected boolean isBelt() {
    return false;
  }

  protected boolean isFootGear() {
    return false;
  }

  protected boolean isHeadGear() {
    return false;
  }

  protected boolean isPotion() {
    return false;
  }

  protected boolean isNoGear() {return false;}

  protected int compareTo(HeadGear that) {
    return 1;
  }

  protected int compareTo(Potion that) {
    return 1;
  }

  protected int compareTo(Belt that) {
    return -1;
  }

  protected int compareTo(FootGear that) {
    return -1;
  }

}
