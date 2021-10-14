package battle;

import Gear.AbstractGear;

import java.util.List;

public abstract class AbstractPlayer implements Player {

  protected final List<Organ> organs;
  protected final Randomizer randomizer;
  protected final String name;

  protected double health;

  protected AbstractPlayer (String name, List<Organ> organs) throws IllegalArgumentException{
    constructionHelper(name);
    this.name = name;
    this.organs = organs;
    this.randomizer = new ActualRandomizer();
  }

  protected AbstractPlayer(String name, List<Organ> organs, int ...random) {
    constructionHelper(name);
    this.name = name;
    this.organs = organs;
    this.randomizer = new PseudoRandomizer(random);
  }

  private void constructionHelper(String name) {
    if(name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Name can not be null or empty");
    }
  }

  protected boolean isHuman() {
    return false;
  }

  @Override
  public void addGear(Gear gear) {
    for (Organ o : organs) {
      try {
        o.addGear((AbstractGear) gear);
        return;
      }
      catch (IllegalStateException | IllegalArgumentException e) {
        continue;
      }
    }
    throw  new IllegalArgumentException("Gear incompatible");
  }

  abstract void attack(AbstractPlayer player);

}
