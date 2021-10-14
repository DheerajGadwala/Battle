package battle;

public class HumanBattle extends AbstractBattle {

  public HumanBattle(Player one, Player two) {
    super(one, two);
    generateBag();
  }

  HumanBattle(Player one, Player two, int ...random) {
    super(one, two, random);
    generateBag();
  }

  @Override
  public void addPlayerOne(Player player) throws IllegalArgumentException, IllegalStateException {
    AbstractPlayer temp = (AbstractPlayer) player;
    if(!temp.isHuman()) {
      throw new IllegalArgumentException("Player needs to be human");
    }
    if(this.one != null) {
      throw new IllegalStateException("Player one already exists");
    }
    this.one = temp;
  }

  @Override
  public void addPlayerTwo(Player player) throws IllegalArgumentException, IllegalStateException {
    AbstractPlayer temp = (AbstractPlayer) player;
    if(!temp.isHuman()) {
      throw new IllegalArgumentException("Player needs to be human");
    }
    if(this.two != null) {
      throw new IllegalStateException("Player two already exists");
    }
    this.two = temp;
  }

  private void generateBag() {
    int maintainer = 0;
    maintainer = generateHeadGear(maintainer);
    maintainer = generateFootGear(maintainer);
    maintainer = generateBelts(maintainer);
    maintainer = generatePotions(maintainer);
  }

  private int generatePotions(int maintainer) {
    int n = this.randomizer.getIntBetween(5, 10);
    for(int i = 0; i < n; i++) {
      this.allGear.add(new Potion("potion"+i, maintainer%4==0));
      maintainer++;
    }
    return maintainer;
  }

  private int generateBelts(int maintainer) {
    int n = this.randomizer.getIntBetween(5, 10);
    for(int i = 0; i < n; i++) {
      int r = this.randomizer.getIntBetween(0, 2);
      BeltSize b = r==0?BeltSize.LARGE:r==1?BeltSize.MEDIUM:BeltSize.SMALL;
      this.allGear.add(new Belt("potion"+i, b, maintainer%4==0));
      maintainer++;
    }
    return maintainer;
  }

  private int generateFootGear(int maintainer) {
    int n = this.randomizer.getIntBetween(5, 10);
    for(int i = 0; i < n; i++) {
      this.allGear.add(new FootGear("FootGear"+i, maintainer%4==0));
      maintainer++;
    }
    return maintainer;
  }

  private int generateHeadGear(int maintainer) {
    int n = this.randomizer.getIntBetween(5, 10);
    for(int i = 0; i < n; i++) {
      this.allGear.add(new HeadGear("HeadGear"+i, maintainer%4==0));
      maintainer++;
    }
    return maintainer;
  }

  @Override
  public void splitBag() {

  }

  @Override
  public void startBattle() {

  }
}
