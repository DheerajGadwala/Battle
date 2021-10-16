package battle;

/**
 * Armoury is a container of weapons.
 * This can generate various weapons which can be used by players in battle.
 * Players can take weapons from armoury at the beginning of a battle.
 */
public class Armoury extends AbstractContainer {
  /**
   * This creates an Armoury object.
   * @param randomizer used to induce randomization into weapon generation.
   */
  public Armoury(Randomizer randomizer) {
    super(randomizer);
  }

  @Override
  public void generateRandom() {
    generateKatanas();
    generateBroadSwords();
    generateTwoHandedSwords();
    generateAxes();
    generateFlails();
    generateFists();
  }

  private void generateFists() {
    int n = this.randomizer.getIntBetween(1, 2);
    for (int i = 0; i < n; i++) {
      this.container.add(new Fists("Fists" + i, randomizer));
    }
  }

  private void generateKatanas() {
    int n = this.randomizer.getIntBetween(1, 2);
    for (int i = 0; i < n; i++) {
      this.container.add(new Katanas("Katanas" + i, randomizer));
    }
  }

  private void generateBroadSwords() {
    int n = this.randomizer.getIntBetween(1, 2);
    for (int i = 0; i < n; i++) {
      this.container.add(new BroadSword("BroadSword" + i, randomizer));
    }
  }

  private void generateTwoHandedSwords() {
    int n = this.randomizer.getIntBetween(1, 2);
    for (int i = 0; i < n; i++) {
      this.container.add(new TwoHandedSword("TwoHandedSword" + i, randomizer));
    }
  }

  private void generateAxes() {
    int n = this.randomizer.getIntBetween(1, 2);
    for (int i = 0; i < n; i++) {
      this.container.add(new Axe("Axe" + i, randomizer));
    }
  }

  private void generateFlails() {
    int n = this.randomizer.getIntBetween(1, 2);
    for (int i = 0; i < n; i++) {
      this.container.add(new Flail("Flail" + i, randomizer));
    }
  }
}
