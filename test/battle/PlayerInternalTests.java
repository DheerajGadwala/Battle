package battle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * These are tests for players that need to be internal.
 */
public class PlayerInternalTests {

  private Player sample1;
  private Player sample2;
  private Player sample3;
  private Player sample4;
  private Player sample5;

  /**
   * Setup for this test suite.
   */
  @Before
  public void setUp() {
    sample1 = new BattlePlayer("Dheeraj", 10, 12, 10, 14, 5, 3);
    sample2 = new BattlePlayer("Dheeraj", 10, 12, 10, 14, 5, 3);
    Gear gear1 = new HeadGear("headGear 1", false, 1);
    Gear gear2 = new FootGear("footGear 2", false, 2);
    Gear gear3 = new Potion("potion 1", true, 4, 2);
    Gear gear4 = new Belt("belt 1", BeltSize.LARGE, false, 3, 2, 4, 1);
    BattlePlayer sample1BattlePlayer = (BattlePlayer) sample1;
    sample1BattlePlayer.equipGear(gear1);
    sample1BattlePlayer.equipGear(gear2);
    sample1BattlePlayer.equipGear(gear3);
    sample1BattlePlayer.equipGear(gear4);
    Gear gear7 = new Potion("potion 2", true, 3, 2);
    Gear gear8 = new Belt("belt 2", BeltSize.LARGE, false, 3, 3, 4, 1);
    Gear gear10 = new FootGear("footGear 4", false, 2);
    Gear gear11 = new Potion("potion 3", true, 1, 2);
    Gear gear12 = new Belt("belt 3", BeltSize.SMALL, false, 1, 2, 4, 1);
    Gear gear15 = new Potion("potion 4", true, 4, 3);
    Gear gear16 = new Belt("belt 4", BeltSize.SMALL, false, 1, 3, 3, 2);
    BattlePlayer sample2BattlePlayer = (BattlePlayer) sample2;
    sample2BattlePlayer.equipGear(gear7);
    sample2BattlePlayer.equipGear(gear12);
    sample2BattlePlayer.equipGear(gear10);
    sample2BattlePlayer.equipGear(gear1);
    sample2BattlePlayer.equipGear(gear15);
    sample2BattlePlayer.equipGear(gear8);
    sample2BattlePlayer.equipGear(gear3);
    sample2BattlePlayer.equipGear(gear4);
    sample2BattlePlayer.equipGear(gear16);
    sample2BattlePlayer.equipGear(gear11); // Inserted in random order
    sample3 = new BattlePlayer("Dheeraj");
    sample4 = new BattlePlayer("John Cena", 18, 18, 18, 18, 6); // Very strong player
    sample5 = new BattlePlayer("Ray", 6, 6, 6, 6, 1); // Very weak player
  }

  /**
   * Test showing that players who do not have base health
   * as sum of their abilities can not be added to the arena.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddPlayers_3() {
    Player a = new BattlePlayer("Dheeraj1", 18, 18, 18, 18, 1);
    BattlePlayer b = new BattlePlayer("Dheeraj2", 18, 18, 18, 18, 10);
    assertEquals(72, a.getHealth(), 0.01);
    b.attack(a);
    assertEquals(71, a.getHealth(), 0.01);
    Battle c = new BattleArena();
    c.addPlayers(a, b);
  }

  /**
   * Test get health after attack.
   */
  @Test
  public void testHealthAfterAttack() {
    BattlePlayer bp = (BattlePlayer) sample2;
    bp.assignWeapon(new Axe("Storm Breaker", 8));
    assertEquals(54, sample1.getHealth(), 0.1);
    bp.attack(sample1);
    assertEquals(37, sample1.getHealth(), 0.1);
  }


  /**
   * Test get health after attack with no damage.
   */
  @Test
  public void testHealthAfterAttackZeroDamage() {
    BattlePlayer bp = (BattlePlayer) sample5;
    assertTrue(bp.actualDamage(sample4) == 0);
    assertEquals(72, sample4.getHealth(), 0.1);
    bp.attack(sample4);
    assertEquals(72, sample4.getHealth(), 0.1);
  }

  /**
   * Test to show that players already having gear can not be added to the arena.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddPlayers_4() {
    Player a = new BattlePlayer("Dheeraj1", 18, 18, 18, 18, 1);
    BattlePlayer b = new BattlePlayer("Dheeraj2", 18, 18, 18, 18, 10);
    b.equipGear(new HeadGear("Helm", false));
    Battle c = new BattleArena();
    c.addPlayers(a, b);
  }

  /**
   * Test if head gear is equipped as expected.
   */
  @Test
  public void testHeadGearEquipped() {
    BattlePlayer bp = (BattlePlayer) sample3;
    double constitution = bp.effectiveConstitution();
    bp.equipGear(new HeadGear("helm", false, 1));
    assertEquals(constitution + 1, bp.effectiveConstitution(), 0.01);
  }

  /**
   * Test if potion is equipped as expected.
   */
  @Test
  public void testPotionEquipped() {
    BattlePlayer bp = (BattlePlayer) sample3;
    double charisma = bp.effectiveCharisma();
    bp.equipGear(new Potion("helm", false, 1, 2));
    assertEquals(charisma + 2, bp.effectiveCharisma(), 0.01);
  }

  /**
   * Test if belt is equipped as expected expected.
   */
  @Test
  public void testBeltEquipped() {
    BattlePlayer bp = (BattlePlayer) sample3;
    double charisma = bp.effectiveCharisma();
    double strength = bp.effectiveStrength();
    bp.equipGear(new Belt("helm", BeltSize.LARGE, false, 1, 2, 4, 1));
    assertEquals(charisma + 2, bp.effectiveCharisma(), 0.01);
    assertEquals(strength + 1, bp.effectiveStrength(), 0.01);
  }

  /**
   * Test if foot gear is added as expected.
   */
  @Test
  public void testFootGearEquipped() {
    BattlePlayer bp = (BattlePlayer) sample3;
    double dexterity = bp.effectiveDexterity();
    bp.equipGear(new FootGear("helm", false, 1));
    assertEquals(dexterity + 1, bp.effectiveDexterity(), 0.01);
  }

  /**
   * Test if head gear is added as expected.
   */
  @Test
  public void testAddHeadGearEquipped() {
    BattlePlayer bp = (BattlePlayer) sample3;
    double constitution = bp.effectiveConstitution();
    bp.equipGear(new HeadGear("helm", false, 1));
    assertEquals(constitution + 1, bp.effectiveConstitution(), 0.01);
  }

  /**
   * Should throw error when a head gear already exists but another one is being added.
   */
  @Test(expected = IllegalStateException.class)
  public void testAddHeadGearException() {
    BattlePlayer p = new BattlePlayer("Dheeraj");
    p.equipGear(new HeadGear("Helm", false));
    p.equipGear(new HeadGear("Bike Helmet", true));
  }

  /**
   * Should throw error when a foot gear already exists but another one is being added.
   */
  @Test(expected = IllegalStateException.class)
  public void testAddFootGearException() {
    BattlePlayer p = new BattlePlayer("Dheeraj");
    p.equipGear(new FootGear("Steel Sabaton", false));
    p.equipGear(new FootGear("Woolen socks", true));
  }

  /**
   * Player can have less than 10 units of belts.
   */
  @Test
  public void testAddBeltLessThan10() {
    BattlePlayer p = new BattlePlayer("Dheeraj");
    p.equipGear(new Belt("leather belt", BeltSize.LARGE, false));
    p.equipGear(new Belt("steel belt", BeltSize.LARGE, false));
    p.equipGear(new Belt("Torn Bag", BeltSize.SMALL, true));
    assertEquals(3, p.getNumberOfGear());
  }

  /**
   * Player can have exactly 10 units of belts.
   */
  @Test
  public void testAddBeltEqualTo10() {
    BattlePlayer p = new BattlePlayer("Dheeraj");
    p.equipGear(new Belt("leather belt", BeltSize.LARGE, false));
    p.equipGear(new Belt("steel belt", BeltSize.LARGE, false));
    p.equipGear(new Belt("Torn Bag", BeltSize.MEDIUM, true));
    assertEquals(3, p.getNumberOfGear());
  }

  /**
   * Should throw error when adding a belt causes the total belt units
   * to increase to a value more than 10.
   */
  @Test(expected = IllegalStateException.class)
  public void testAddBeltException() {
    BattlePlayer p = new BattlePlayer("Dheeraj");
    p.equipGear(new Belt("leather belt", BeltSize.LARGE, false));
    p.equipGear(new Belt("steel belt", BeltSize.LARGE, false));
    p.equipGear(new Belt("Torn Bag", BeltSize.LARGE, true));
  }

  /**
   * Test if striking power returns expected value.
   */
  @Test
  public void testStrikingPower() {
    assertEquals(20, sample1.strikingPower(), 0.1);
  }

  /**
   * Test if striking power returns expected value with gear.
   */
  @Test
  public void testStrikingPowerWithGear() {
    assertEquals(25, sample2.strikingPower(), 0.1);
  }

  /**
   * Test if avoidance ability returns expected value.
   */
  @Test
  public void testAvoidanceAbility() {
    assertEquals(19, sample1.avoidanceAbility(), 0.1);
  }

  /**
   * Test if avoidance ability  returns expected value on player with gear.
   */
  @Test
  public void testAvoidanceAbilityWithGear() {
    assertEquals(26, sample2.avoidanceAbility(), 0.1);
  }

  /**
   * Potential striking power without weapon/ fists.
   */
  @Test
  public void testPotentialStrikingDamage() {
    assertEquals(16, sample1.potentialStrikingDamage(), 0.1);
  }

  /**
   * Potential striking power with weapon.
   */
  @Test
  public void testPotentialStrikingDamageWithWeapon() {
    BattlePlayer bp = (BattlePlayer) sample1;
    bp.assignWeapon(new Axe("Storm Breaker", 8));
    assertEquals(23, sample1.potentialStrikingDamage(), 0.1);
  }

  /**
   * Potential striking power with weapon and gear.
   */
  @Test
  public void testPotentialStrikingDamageWithWeaponAndGear() {
    BattlePlayer bp = (BattlePlayer) sample2;
    bp.assignWeapon(new Axe("Storm Breaker", 8));
    assertEquals(28, sample2.potentialStrikingDamage(), 0.1);
  }

  /**
   * Actual damage power without weapon/ fists.
   */
  @Test
  public void testActualDamage() {
    assertEquals(5, sample1.actualDamage(sample2), 0.1);
  }

  /**
   * Actual damage power with weapon.
   */
  @Test
  public void testActualDamageWithWeapon() {
    BattlePlayer bp = (BattlePlayer) sample1;
    bp.assignWeapon(new Axe("Storm Breaker", 8));
    assertEquals(12, sample1.actualDamage(sample2), 0.1);
  }

  /**
   * Actual damage with weapon and gear.
   */
  @Test
  public void testActualDamageWithWeaponAndGear() {
    BattlePlayer bp = (BattlePlayer) sample2;
    bp.assignWeapon(new Axe("Storm Breaker", 8));
    assertEquals(17, sample2.actualDamage(sample1), 0.1);
  }

  /**
   * Test get health without gear.
   */
  @Test
  public void testHealth() {
    assertEquals(54, sample1.getHealth(), 0.1);
  }

  /**
   * Test get health with gear.
   */
  @Test
  public void testHealthWithGear() {
    assertEquals(73, sample2.getHealth(), 0.1);
  }

  /**
   * Test if effective strength returns the correct value.
   */
  @Test
  public void testEffectiveStrength() {
    assertEquals(15, sample1.effectiveStrength(), 0.1);
  }

  /**
   * Test if effective dexterity returns the correct value.
   */
  @Test
  public void testEffectiveDexterity() {
    assertEquals(14, sample1.effectiveDexterity(), 0.1);
  }

  /**
   * Test if effective constitution returns the correct value.
   */
  @Test
  public void testEffectiveConstitution() {
    assertEquals(11, sample1.effectiveConstitution(), 0.1);
  }

  /**
   * Test if effective charisma returns the correct value.
   */
  @Test
  public void testEffectiveCharisma() {
    assertEquals(14, sample1.effectiveCharisma(), 0.1);
  }

  /**
   * Test if assign weapon works as expected.
   */
  @Test
  public void testAssignWeapon() {
    BattlePlayer bp = (BattlePlayer) sample1;
    bp.assignWeapon(new Flail("Flail1"));
    assertTrue(bp.getWeapon().isFlail());
  }

  /**
   * Test if assign weapon works as expected.
   */
  @Test (expected = IllegalStateException.class)
  public void testAssignWeaponException() {
    BattlePlayer bp = (BattlePlayer) sample1;
    bp.assignWeapon(new Flail("Flail1"));
    bp.assignWeapon(new TwoHandedSword("Sword1"));
  }

  /**
   * Test if gears are sorted correctly.
   */
  @Test
  public void testSortedOrder() {
    assertEquals("Player: Dheeraj\n"
        + "Base Abilities: \n"
        + "Strength: 12 Charisma: 14 Dexterity: 10 Constitution: 10 \n"
        + "Weapon: \n"
        + "Name: knuckle duster, Type: Fists\n"
        + "Gear: \n"
        + "headGear 1 [HeadGear], Ability: Constitution: 1\n"
        + "potion 1 [Potion], Ability: Strength: 2\n"
        + "potion 2 [Potion], Ability: Dexterity: 2\n"
        + "potion 3 [Potion], Ability: Charisma: 2\n"
        + "potion 4 [Potion], Ability: Strength: 3\n"
        + "belt 1 [Belt], Size: LARGE, Abilities: #1: Dexterity: 2, #2: Strength: 1\n"
        + "belt 2 [Belt], Size: LARGE, Abilities: #1: Dexterity: 3, #2: Strength: 1\n"
        + "belt 3 [Belt], Size: SMALL, Abilities: #1: Charisma: 2, #2: Strength: 1\n"
        + "belt 4 [Belt], Size: SMALL, Abilities: #1: Charisma: 3, #2: Dexterity: 2\n"
        + "footGear 4 [FootGear], Ability: Dexterity: 2\n"
        + "Effective Abilities: \n"
        + "Strength: 20.0 Charisma: 21.0 Dexterity: 21.0 Constitution: 11.0\n"
        + "Health: 73.0\n", sample2.toString());
  }
}