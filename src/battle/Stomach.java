package battle;

import Gear.AbstractGear;
import ability.AbstractAbility;

import java.util.ArrayList;
import java.util.List;

public class Stomach extends AbstractOrgan {

  private List<Potion> potions;

  public Stomach() {
    potions = new ArrayList<>();
  }

  public void addGear(AbstractGear gear) throws IllegalArgumentException{
    if(gear.isPotion()) {
      potions.add((Potion)gear);
    }
    else {
      throw new IllegalArgumentException("Stomach can have only potions");
    }
  }

  @Override
  public List<AbstractGear> getGears() {
    List<AbstractGear> ret = new ArrayList<>();
    for (AbstractGear g: potions) {
      ret.add(g);
    }
    return ret;
  }

  @Override
  public List<AbstractAbility> getGearAbilities() {
    List<AbstractAbility> ret = new ArrayList<>();
    for (AbstractGear g: potions) {
      ret.addAll(g.getAbilities());
    }
    return ret;
  }

  @Override
  public boolean isStomach() {
    return true;
  }

  @Override
  public String toString() {
    StringBuilder ret = new StringBuilder("Stomach: \n");
    if (potions.isEmpty()) {
      ret.append(" No potions.");
      ret.append("\n");
    }
    else {
      for (Potion k : potions) {
        ret.append(" "+k.toString());
        ret.append("\n");
      }
    }
    return new String(ret);
  }
}
