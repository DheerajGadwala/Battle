package battle;

import java.util.List;

abstract class AbstractBattle implements Battle {

  protected AbstractPlayer one;
  protected AbstractPlayer two;
  protected List<Gear> allGear;
  protected final Randomizer randomizer;

  protected AbstractBattle(Player one, Player two) {
    this.one = (AbstractPlayer)one;
    this.two = (AbstractPlayer)two;
    randomizer = new ActualRandomizer();
  }

  protected AbstractBattle(Player one, Player two, int ...random) {
    this.one = (AbstractPlayer)one;
    this.two = (AbstractPlayer)two;
    randomizer = new PseudoRandomizer(random);
  }

}
