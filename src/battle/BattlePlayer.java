package battle;

import static java.lang.Math.max;

import java.util.List;
import java.util.function.Predicate;

/**
 * Battle Player is a type of player.
 * This has a name.
 * This has 4 abilities: dexterity, strength, constitution, and, health.
 * Can attack another player inside a Battle Arena.
 * This has an increases effective magnitude of abilities when equipped with gear.
 * This has health which can be reduced when attacked by other objects of this type.
 *
 */
public class BattlePlayer implements Player {

  private final Randomizer randomizer;
  private final String name;
  private final Ability dexterity;
  private final Ability strength;
  private final Ability constitution;
  private final Ability charisma;
  private Ability effectiveDexterity;
  private Ability effectiveStrength;
  private Ability effectiveConstitution;
  private Ability effectiveCharisma;
  private GearList gear;
  private double health;
  private Weapon weapon;

  /**
   * Creates a battle player object that is random in generating output.
   * @param name name of the player.
   * @throws IllegalArgumentException when name is empty.
   * @throws IllegalStateException in case random are beyond 6-18 range.
   *          [useful in case of pseudoRandom]
   */
  public BattlePlayer(String name) throws IllegalArgumentException, IllegalStateException {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Name can not be null or empty");
    }
    this.name = name;
    this.randomizer = new ActualRandomizer();
    this.dexterity = new Dexterity(randomizer.getPlayerAbilityValue());
    this.strength = new Strength(randomizer.getPlayerAbilityValue());
    this.constitution = new Constitution(randomizer.getPlayerAbilityValue());
    this.charisma = new Charisma(randomizer.getPlayerAbilityValue());
    constructionHelper();
  }

  /**
   * Creates a battle player object that is pseudo random in generating outputs.
   * @param name name of the battle player
   * @param random random numbers.
   * @throws IllegalArgumentException when name is null or empty
   * @throws IllegalStateException when pseudo random abilities are not as expected
   */
  public BattlePlayer(String name, int... random)
      throws IllegalArgumentException, IllegalStateException {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Name can not be null or empty");
    }
    this.name = name;
    this.randomizer = new PseudoRandomizer(random);
    this.dexterity = new Dexterity(randomizer.getPlayerAbilityValue());
    this.strength = new Strength(randomizer.getPlayerAbilityValue());
    this.constitution = new Constitution(randomizer.getPlayerAbilityValue());
    this.charisma = new Charisma(randomizer.getPlayerAbilityValue());
    constructionHelper();
  }

  /**
   * Creates battle player objects which are either random
   * or pseudo random in generating outputs
   * based on the type of the randomizer object.
   * @param name name of the battle player
   * @param randomizer a randomizer object.
   * @throws IllegalArgumentException when name is null or empty
   * @throws IllegalStateException when pseudo random abilities are not as expected
   */
  public BattlePlayer(String name, Randomizer randomizer)
      throws IllegalArgumentException, IllegalStateException {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Name can not be null or empty");
    }
    this.name = name;
    this.randomizer = randomizer;
    this.dexterity = new Dexterity(randomizer.getPlayerAbilityValue());
    this.strength = new Strength(randomizer.getPlayerAbilityValue());
    this.constitution = new Constitution(randomizer.getPlayerAbilityValue());
    this.charisma = new Charisma(randomizer.getPlayerAbilityValue());
    constructionHelper();
  }

  private void constructionHelper() throws IllegalStateException {
    this.gear = new EmptyGearNode();
    calculateEffectiveDexterity();
    calculateEffectiveStrength();
    calculateEffectiveCharisma();
    calculateEffectiveConstitution();
    calculateHealth();
    this.weapon = new Fists("knuckle duster");
    checkErrors();
  }

  private boolean checkHealth() {
    return health == charisma.getMagnitude()
        + strength.getMagnitude()
        + constitution.getMagnitude()
        + dexterity.getMagnitude();
  }

  @Override
  public boolean isNewPlayer() {
    return gear.isEmptyNode() && weapon.isFists() && checkHealth();
  }

  private void checkErrors() throws IllegalStateException {
    Predicate<Ability> predicate = (ability) -> (
        6 > ability.getMagnitude() || ability.getMagnitude() > 18
    );
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

  @Override
  public double strikingPower() {
    return effectiveStrength()
        + randomizer.getIntBetween(1, 10);
  }

  @Override
  public double avoidanceAbility() {
    return effectiveDexterity()
        + randomizer.getIntBetween(1, 6);
  }

  @Override
  public double getWeaponDamage() {
    if (weapon.isAxe() || weapon.isFists() || weapon.isBroadSword() || weapon.isKatanas()) {
      return weapon.getDamage();
    }
    else if (weapon.isTwoHandedSword()) {
      return effectiveStrength() >= 15 ? weapon.getDamage() : weapon.getDamage() / 2.0;
    }
    else {
      return effectiveDexterity() >= 15 ? weapon.getDamage() : weapon.getDamage() / 2.0;
    }
  }

  @Override
  public double getWeaponMaxDamage() {
    if (weapon.isAxe() || weapon.isFists() || weapon.isBroadSword() || weapon.isKatanas()) {
      return weapon.getMaxDamage();
    }
    else if (weapon.isTwoHandedSword()) {
      return effectiveStrength() >= 15 ? weapon.getMaxDamage() : weapon.getMaxDamage() / 2.0;
    }
    else {
      return effectiveDexterity() >= 15 ? weapon.getMaxDamage() : weapon.getMaxDamage() / 2.0;
    }
  }

  @Override
  public double potentialStrikingDamage() {
    return getWeaponDamage()
        + effectiveStrength();
  }

  @Override
  public double actualDamage(Player that) {
    return max(this.potentialStrikingDamage() - that.effectiveConstitution(), 0);
  }

  @Override
  public double effectiveConstitution() {
    return effectiveConstitution.getMagnitude();
  }

  @Override
  public double effectiveStrength() {
    return effectiveStrength.getMagnitude();
  }

  @Override
  public double effectiveDexterity() {
    return effectiveDexterity.getMagnitude();
  }

  @Override
  public double effectiveCharisma() {
    return effectiveCharisma.getMagnitude();
  }

  private int abilityFromGear(Predicate<Ability> predicate) {
    int sum = 0;
    List<Ability> allAbilities = gear.getAllAbilities();
    if (allAbilities.size() > 0) {
      for (Ability ability : allAbilities) {
        if (predicate.test(ability)) {
          sum += ability.getMagnitude();
        }
      }
    }
    return sum;
  }

  @Override
  public String getName() {
    return name;
  }

  /**
   * Equips the player with the given gear.
   * @param gear gear to be added
   * @throws IllegalArgumentException when gear can not be added.
   */
  void equipGear(Gear gear) throws IllegalArgumentException {
    if (gear == null) {
      throw new IllegalArgumentException("gear can not be null");
    }
    if (gear.isHeadGear()) {
      addHeadGear(gear);
    }
    else if (gear.isBelt()) {
      addBelt(gear);
    }
    else if (gear.isPotion()) {
      addPotion(gear);
    }
    else {
      addFootGear(gear);
    }
    calculateEffectiveDexterity();
    calculateEffectiveStrength();
    calculateEffectiveCharisma();
    calculateEffectiveConstitution();
    calculateHealth();
  }

  private void calculateHealth() {
    health = effectiveCharisma()
        + effectiveDexterity()
        + effectiveConstitution()
        + effectiveStrength();
  }

  private void calculateEffectiveConstitution() {
    effectiveConstitution = new Constitution(
        constitution.getMagnitude()
        + abilityFromGear(Ability::isConstitution)
    );
  }

  private void calculateEffectiveCharisma() {
    effectiveCharisma = new Charisma(
        charisma.getMagnitude()
            + abilityFromGear(Ability::isCharisma)
    );
  }

  private void calculateEffectiveDexterity() {
    effectiveDexterity = new Dexterity(
        dexterity.getMagnitude()
        + abilityFromGear(Ability::isDexterity)
    );
  }

  private void calculateEffectiveStrength() {
    effectiveStrength = new Strength(
        strength.getMagnitude()
        + abilityFromGear(Ability::isStrength)
    );
  }

  @Override
  public boolean isAlive() {
    return health > 0;
  }

  @Override
  public double getHealth() {
    return health;
  }

  @Override
  public int getNumberOfGear() {
    return gear.count();
  }

  @Override
  public int getNumberOfHeadGear() {
    return gear.totalHeadGears();
  }

  @Override
  public int getNumberOfFootGear() {
    return gear.totalFootGears();
  }

  @Override
  public int getNumberOfPotions() {
    return gear.totalPotions();
  }

  @Override
  public int getNumberOfBeltUnits() {
    return gear.totalBeltUnits();
  }

  /**
   * Assigns a weapon to the player.
   * @param weapon a weapon
   */
  void assignWeapon(Weapon weapon) {
    if (!this.weapon.isFists()) {
      throw new IllegalStateException("Player already has a weapon.");
    }
    if (weapon == null ) {
      throw new IllegalArgumentException("Weapon can not be null.");
    }
    this.weapon = weapon;
  }

  @Override
  public Weapon getWeapon() {
    return this.weapon;
  }

  void flush() {
    constructionHelper();
  }

  /**
   * Attacks another player causing the other player to loose health.
   * @param that the other player
   * @return the health removed from the other player.
   */
  double attack(Player that) {
    double totalDamage = 0;
    if (this.strikingPower() > that.avoidanceAbility()) {
      totalDamage = actualDamage(that);
      BattlePlayer bp = (BattlePlayer) that;
      bp.health -= max(totalDamage, 0);
    }
    return totalDamage;
  }

  private void addHeadGear(Gear gear) throws IllegalStateException {
    if (this.gear.containsHeadGear()) {
      throw new IllegalStateException("Player can have only one head gear.");
    }
    health += gear.getAbilities().get(0).getMagnitude();
    this.gear = this.gear.insert(gear, Comparable::compareTo);
  }

  private void addBelt(Gear gear) throws IllegalStateException {
    Belt b = (Belt) gear;
    if (this.gear.totalBeltUnits() + b.getSize() > 10) {
      throw new IllegalStateException("Player can not have more than 10 units of belts.");
    }
    health += b.getAbilities().get(0).getMagnitude();
    health += b.getAbilities().get(1).getMagnitude();
    this.gear = this.gear.insert(gear, Comparable::compareTo);
  }

  private void addPotion(Gear gear) {
    health += gear.getAbilities().get(0).getMagnitude();
    this.gear = this.gear.insert(gear, Comparable::compareTo);
  }

  private void addFootGear(Gear gear) {
    if (this.gear.containsFootGear()) {
      throw new IllegalStateException("Player can have only one foot gear.");
    }
    health += gear.getAbilities().get(0).getMagnitude();
    this.gear = this.gear.insert(gear, Comparable::compareTo);
  }

  @Override
  public String toString() {
    if (gear.isEmptyNode()) {
      return "Player: "
          + this.name
          + "\nAbilities: \n"
          + strength.toString() + " "
          + charisma.toString() + " "
          + dexterity.toString() + " "
          + constitution.toString()
          + "\nWeapon: \n"
          + weapon.toString()
          + "\nHealth: " + health + "\n";
    }
    else {
      return "Player: "
          + this.name
          + "\nBase Abilities: \n"
          + strength.toString() + " "
          + charisma.toString() + " "
          + dexterity.toString() + " "
          + constitution.toString() + " "
          + "\nWeapon: \n"
          + weapon.toString()
          + "\nGear: \n"
          + gear.toString()
          + "Effective Abilities: \n"
          + "Strength: " + effectiveStrength() + " "
          + "Charisma: " + effectiveCharisma() + " "
          + "Dexterity: " + effectiveDexterity() + " "
          + "Constitution: " + effectiveConstitution()
          + "\nHealth: " + health + "\n";
    }
  }
}
