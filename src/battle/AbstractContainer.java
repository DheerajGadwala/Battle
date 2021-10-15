package battle;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractContainer implements Container {

  protected final List<Object> container;
  protected final Randomizer randomizer;

  AbstractContainer(Randomizer randomizer) {
    container = new ArrayList<>();
    this.randomizer = randomizer;
  }

  @Override
  public void shuffle() {
    randomizer.shuffle(this.container);
  }

  @Override
  public Object seize() {
    return this.container.remove(0);
  }

  @Override
  public int size() {
    return container.size();
  }
}
