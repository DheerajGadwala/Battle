package battle;

abstract class AbstractGear implements Gear {

  protected final Randomizer randomizer;

  protected final String name;

  protected AbstractGear(String name)  throws IllegalArgumentException {
    this.randomizer = new ActualRandomizer();
    constructionHelper(name);
    this.name = name;
  }

  protected AbstractGear(String name, int ...random)  throws IllegalArgumentException {
    this.randomizer = new PseudoRandomizer(random);
    constructionHelper(name);
    this.name = name;
  }

  private void constructionHelper(String name) throws IllegalArgumentException {
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

  protected boolean isNoGear() {
    return false;
  }

  protected int compareTo(HeadGear that) {
    return -1;
  }

  protected int compareTo(Potion that) {
    return -1;
  }

  protected int compareTo(Belt that) {
    return 1;
  }

  protected int compareTo(FootGear that) {
    return 1;
  }

  protected boolean givesCharisma() {
    return false;
  }

  protected boolean givesStrength() {
    return false;
  }

  protected boolean givesConstitution() {
    return false;
  }

  protected boolean givesDexterity() {
    return false;
  }

}
