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

  public AbstractGear(String name, Randomizer randomizer) {
    this.randomizer = randomizer;
    constructionHelper(name);
    this.name = name;
  }

  @Override
  public String getName() {
    return this.name;
  }

  private void constructionHelper(String name) throws IllegalArgumentException {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Name can not be null or empty.");
    }
  }
}
