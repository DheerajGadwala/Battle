package battle;

class Armoury extends AbstractContainer {

  Armoury(Randomizer randomizer) {
    super(randomizer);
  }

  @Override
  public void generateRandom() {
    generateKatanas();
    generateBroadSwords();
    generateTwoHandedSwords();
    generateAxes();
    generateFlails();
  }

  private void generateKatanas() {
    int n = this.randomizer.getIntBetween(1, 2);
    for (int i = 0; i < n; i++) {
      this.container.add(new Katanas("Katanas" + i));
    }
  }

  private void generateBroadSwords() {
    int n = this.randomizer.getIntBetween(1, 2);
    for (int i = 0; i < n; i++) {
      this.container.add(new BroadSword("BroadSword" + i));
    }
  }

  private void generateTwoHandedSwords() {
    int n = this.randomizer.getIntBetween(1, 2);
    for (int i = 0; i < n; i++) {
      this.container.add(new TwoHandedSword("TwoHandedSword" + i));
    }
  }

  private void generateAxes() {
    int n = this.randomizer.getIntBetween(1, 2);
    for (int i = 0; i < n; i++) {
      this.container.add(new Axe("Axe" + i));
    }
  }

  private void generateFlails() {
    int n = this.randomizer.getIntBetween(1, 2);
    for (int i = 0; i < n; i++) {
      this.container.add(new Flail("Flail" + i));
    }
  }
}
