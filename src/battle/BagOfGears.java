package battle;

/**
 * This is a container of Gears.
 */
class BagOfGears extends AbstractContainer {

  BagOfGears(Randomizer randomizer) {
    super(randomizer);
  }

  @Override
  public void generateRandom() {
    int countMaintainer = 0;
    countMaintainer = generateHeadGear(countMaintainer);
    countMaintainer = generateFootGear(countMaintainer);
    countMaintainer = generateBelts(countMaintainer);
    countMaintainer = generatePotions(countMaintainer);
  }

  private int generatePotions(int countMaintainer) {
    int n = this.randomizer.getIntBetween(15, 25);
    for (int i = 0; i < n; i++) {
      this.container.add(new Potion("potion" + i, countMaintainer % 4 == 0));
      countMaintainer++;
    }
    return countMaintainer;
  }

  private int generateBelts(int countMaintainer) {
    int n = this.randomizer.getIntBetween(15, 25);
    for (int i = 0; i < n; i++) {
      int r = this.randomizer.getIntBetween(0, 2);
      BeltSize b = r == 0 ? BeltSize.LARGE : r == 1 ? BeltSize.MEDIUM : BeltSize.SMALL;
      this.container.add(new Belt("belt" + i, b, countMaintainer % 4 == 0));
      countMaintainer++;
    }
    return countMaintainer;
  }

  private int generateFootGear(int countMaintainer) {
    int n = this.randomizer.getIntBetween(5, 10);
    for (int i = 0; i < n; i++) {
      this.container.add(new FootGear("FootGear" + i, countMaintainer % 4 == 0));
      countMaintainer++;
    }
    return countMaintainer;
  }

  private int generateHeadGear(int countMaintainer) {
    int n = this.randomizer.getIntBetween(5, 10);
    for (int i = 0; i < n; i++) {
      this.container.add(new HeadGear("HeadGear" + i, countMaintainer % 4 == 0));
      countMaintainer++;
    }
    return countMaintainer;
  }
}
