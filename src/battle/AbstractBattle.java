package battle;

abstract class AbstractBattle implements Battle {

  protected final AbstractPlayer one;
  protected final AbstractPlayer two;
  protected Container bagOfGears;
  protected Container armoury;
  protected final Randomizer randomizer;

  protected AbstractBattle(Player one, Player two) {
    this.one = (AbstractPlayer)one;
    this.two = (AbstractPlayer)two;
    randomizer = new ActualRandomizer();
    constructionHelper();
  }

  protected AbstractBattle(Player one, Player two, int ...random) {
    this.one = (AbstractPlayer)one;
    this.two = (AbstractPlayer)two;
    randomizer = new PseudoRandomizer(random);
    constructionHelper();
  }

  private void constructionHelper() {
    bagOfGears = new BagOfGears(randomizer);
    armoury = new Armoury(randomizer);
    bagOfGears.generateRandom();
    armoury.generateRandom();
    bagOfGears.shuffle();
    armoury.shuffle();
  }

  void flush() {
    one.flush();
    two.flush();
    constructionHelper();
  }
}
