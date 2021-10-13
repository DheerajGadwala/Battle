package battle;

abstract class AbstractGear implements Gear {

  protected final Randomizer randomizer;

  protected AbstractGear() {
    this.randomizer = new ActualRandomizer();
  }

  protected AbstractGear(int ...random) {
    this.randomizer = new PseudoRandomizer(random);
  }

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
