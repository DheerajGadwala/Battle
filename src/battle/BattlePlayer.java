package battle;

import static java.lang.Math.max;

import java.util.List;
import java.util.function.Predicate;

/**
 * Battle Player is a type of player.
 * This has 4 abilities: dexterity, strength, constitution and health.
 * Can attack another player inside a Battle Arena.
 * This has health which can be reduced when attacked by other objects of this type.
 */
public class BattlePlayer extends AbstractPlayer {

  private final Ability dexterity;
  private final Ability strength;
  private final Ability constitution;
  private final Ability charisma;

  /**
   * This is the constructor of BattlePlayer.
   * @param name name of the player.
   * @throws IllegalArgumentException when name is empty.
   * @throws IllegalStateException in case random are beyond 6-18 range.
   *          [useful in case of pseudoRandom]
   */
  public BattlePlayer(String name) throws IllegalArgumentException, IllegalStateException {
    super(name);
    this.dexterity = new Dexterity(randomizer.getPlayerAbilityValue());
    this.strength = new Strength(randomizer.getPlayerAbilityValue());
    this.constitution = new Constitution(randomizer.getPlayerAbilityValue());
    this.charisma = new Charisma(randomizer.getPlayerAbilityValue());
    this.health = this.dexterity.getValue()
        + this.charisma.getValue()
        + this.constitution.getValue()
        + this.strength.getValue();
    checkErrors();
  }

  BattlePlayer(String name, int ...random) throws IllegalArgumentException {
    super(name, random);
    this.dexterity = new Dexterity(randomizer.getPlayerAbilityValue());
    this.strength = new Strength(randomizer.getPlayerAbilityValue());
    this.constitution = new Constitution(randomizer.getPlayerAbilityValue());
    this.charisma = new Charisma(randomizer.getPlayerAbilityValue());
    this.health = this.dexterity.getValue()
        + this.charisma.getValue()
        + this.constitution.getValue()
        + this.strength.getValue();
    checkErrors();
  }

  private void checkErrors() throws IllegalStateException {
    Predicate<Ability> predicate = (Ability) -> (6 > Ability.getValue() || Ability.getValue() > 18);
    if (predicate.test(dexterity)) {
      throw new IllegalStateException("Invalid value for dexterity");
    }
    else if (predicate.test(strength)) {
      throw new IllegalStateException("Invalid value for strength");
    }
    else if (predicate.test(charisma)) {
      throw new IllegalStateException("Invalid value for charisma");
    }
    else if (predicate.test(constitution)) {
      throw new IllegalStateException("Invalid value for constitution");
    }
  }

  int strikingPower() {
    return effectiveStrength()
        + randomizer.getIntBetween(1, 10);
  }

  int avoidanceAbility() {
    return dexterity.getValue()
        + abilityFromGear(AbstractAbility::isDexterity)
        + randomizer.getIntBetween(1, 6);
  }

  double potentialStrikingDamage() {
    return weapon.getDamage()
        + strength.getValue()
        + abilityFromGear(AbstractAbility::isStrength);
  }

  int effectiveConstitution() {
    return constitution.getValue()
        + abilityFromGear(AbstractAbility::isConstitution);
  }

  int effectiveStrength() {
    return strength.getValue()
        + abilityFromGear(AbstractAbility::isStrength);
  }

  int effectiveDexterity() {
    return dexterity.getValue()
        + abilityFromGear(AbstractAbility::isDexterity);
  }

  int effectiveCharisma() {
    return dexterity.getValue()
        + abilityFromGear(AbstractAbility::isCharisma);
  }

  private int abilityFromGear(Predicate<AbstractAbility> predicate) {
    int sum = 0;
    List<AbstractAbility> allAbilities = gear.getAllAbilities();
    for (AbstractAbility ability : allAbilities) {
      if (predicate.test(ability)) {
        sum += ability.getValue();
      }
    }
    return sum;
  }

  @Override
  public void equipGear(Gear gear) throws IllegalArgumentException {
    if (gear == null) {
      throw new IllegalArgumentException("gear can not be null");
    }
    AbstractGear abg = (AbstractGear) gear;
    if (abg.isHeadGear()) {
      addHeadGear(abg);
    }
    else if (abg.isBelt()) {
      addBelt(abg);
    }
    else if (abg.isPotion()) {
      addPotion(abg);
    }
    else {
      addFootGear(abg);
    }
  }

  @Override
  boolean isAlive() {
    return health > 0;
  }

  @Override
  void assignWeapon(Weapon weapon) {
    AbstractWeapon w = (AbstractWeapon) weapon;
    this.weapon = w;
    w.setWielder(this);
  }

  @Override
  void flush() {
    this.health = this.dexterity.getValue()
        + this.charisma.getValue()
        + this.constitution.getValue()
        + this.strength.getValue();
    this.gear = new EmptyGearNode();
  }

  @Override
  void attack(AbstractPlayer AbstractThat) {
    BattlePlayer that = (BattlePlayer) AbstractThat;
    if (this.strikingPower() > that.avoidanceAbility()) {
      that.health -= max(potentialStrikingDamage() - that.effectiveConstitution(), 0);
    }
  }

  private void addHeadGear(AbstractGear gear) throws IllegalStateException {
    if (this.gear.containsHeadGear()) {
      throw new IllegalStateException("Player can have only one head gear.");
    }
    health += gear.getAbilities().get(0).getValue();
    this.gear = this.gear.insert(gear, Comparable::compareTo);
  }

  private void addBelt(AbstractGear gear) throws IllegalStateException {
    Belt b = (Belt) gear;
    if (this.gear.totalBeltUnits() + b.getSize() > 10) {
      throw new IllegalStateException("Player can not have more than 10 units of belts.");
    }
    health += b.getAbilities().get(0).getValue();
    health += b.getAbilities().get(1).getValue();
    this.gear = this.gear.insert(gear, Comparable::compareTo);
  }

  private void addPotion(AbstractGear gear) {
    health += gear.getAbilities().get(0).getValue();
    this.gear = this.gear.insert(gear, Comparable::compareTo);
  }

  private void addFootGear(AbstractGear gear) {
    if (this.gear.containsFootGear()) {
      throw new IllegalStateException("Player can have only one foot gear.");
    }
    health += gear.getAbilities().get(0).getValue();
    this.gear = this.gear.insert(gear, Comparable::compareTo);
  }

  @Override
  public boolean isBattlePlayer() {
    return true;
  }

  @Override
  public String toString() {
    if (weapon == null || gear == null) {
      return "Player: "
          + this.name
          + "\nAbilities: "
          + strength.toString() + " "
          + charisma.toString() + " "
          + dexterity.toString() + " "
          + constitution.toString();
    }
    else {
      return "Player: "
          + this.name
          + "\nAbilities: "
          + strength.toString() + " "
          + charisma.toString() + " "
          + dexterity.toString() + " "
          + constitution.toString() + " "
          + "\nWeapon: \n"
          + weapon.toString()
          + "\nGear: \n"
          + gear.toString();
    }

  }
}
