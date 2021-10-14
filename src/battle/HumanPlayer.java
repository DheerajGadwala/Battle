package battle;

import Gear.AbstractGear;
import ability.*;

import java.util.List;
import java.util.ArrayList;

/**
 * This is a type of player.
 * A human player has a head, a torso, a stomach and feet.
 * this player's head can be equipped with head gear.
 * this player's feet can be equipped with foot gear.
 * this player's torso can hold a few belts.
 * this player's stomach can hold any number of potions.
 * This player has four abilities, namely, dexterity, strength, constitution and charisma.
 */
public class HumanPlayer extends AbstractPlayer {

  private final Ability dexterity;
  private final Ability strength;
  private final Ability constitution;
  private final Ability charisma;

  /**
   * This is the constructor of HumanPlayer.
   * It creates a player with random stats.
   * @param name It takes name as an argument.
   * @throws IllegalArgumentException when name is invalid
   */
  public HumanPlayer(String name) throws IllegalArgumentException {
    super(name, new ArrayList<Organ>());
    this.dexterity = new Dexterity(randomizer.getPlayerAbilityValue());
    this.strength = new Strength(randomizer.getPlayerAbilityValue());
    this.constitution = new Constitution(randomizer.getPlayerAbilityValue());
    this.charisma = new Charisma(randomizer.getPlayerAbilityValue());
    constructionHelper();
  }

  /**
   * This is the constructor of HumanPlayer.
   * It creates a player with pseudo random stats.
   * @param name It takes name as an argument.
   * @throws IllegalArgumentException when name is invalid
   */
  HumanPlayer(String name, int ...random) throws IllegalArgumentException{
    super(name, new ArrayList<Organ>(), random);
    this.dexterity = new Dexterity(randomizer.getPlayerAbilityValue());
    this.strength = new Strength(randomizer.getPlayerAbilityValue());
    this.constitution = new Constitution(randomizer.getPlayerAbilityValue());
    this.charisma = new Charisma(randomizer.getPlayerAbilityValue());
    constructionHelper();
  }

  private void constructionHelper() {
    this.organs.add(new Head());
    this.organs.add(new Torso());
    this.organs.add(new Stomach());
    this.organs.add(new Feet());
    this.health = this.dexterity.getValue()
        + this.charisma.getValue()
        + this.constitution.getValue()
        + this.strength.getValue();
  }

  private void addHeadGear(AbstractGear gear){
    this.organs.get(0).addGear(gear);
  }

  private void addBelt(AbstractGear gear) {
    this.organs.get(1).addGear(gear);
  }

  private void addPotion(AbstractGear gear) {
    this.organs.get(2).addGear(gear);
  }

  private void addFootGear(AbstractGear gear) {
    this.organs.get(3).addGear(gear);
  }

  @Override
  public void addGear(Gear gear) {
    if(gear == null) {
      throw new IllegalArgumentException("gear can not be null");
    }
    AbstractGear abg = (AbstractGear) gear;
    if(abg.isHeadGear()) {
      addHeadGear(abg);
    }
    else if(abg.isBelt()) {
      addBelt(abg);
    }
    else if(abg.isPotion()) {
      addPotion(abg);
    }
    else {
      addFootGear(abg);
    }
  }

  @Override
  public boolean isHuman() {
    return true;
  }

  @Override
  void attack(AbstractPlayer player) {

  }

  public double effectiveStrength() {
    return 0;
  }

  public double effectiveDexterity() {
    return 0;
  }

  @Override
  public String getAllAbilities() {
    List<AbstractAbility> abilities = new ArrayList<>();
    for(Organ k: organs) {
      abilities.addAll(k.getGearAbilities());
    }
    return abilities.toString();
  }

  @Override
  public String toString() {
    StringBuilder ret = new StringBuilder("Player: "+this.name+"\n");
    for (Organ o : organs) {
      ret.append(o.toString());
    }
    return new String(ret);
  }
}
