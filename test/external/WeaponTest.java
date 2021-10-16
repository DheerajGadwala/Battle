package external;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import battle.Axe;
import battle.BattlePlayer;
import battle.BroadSword;
import battle.Fists;
import battle.Flail;
import battle.Katanas;
import battle.TwoHandedSword;
import battle.Weapon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test suite for the weapon class.
 */
public class WeaponTest {

  Weapon sample1;
  Weapon sample2;
  Weapon sample3;
  Weapon sample4;
  Weapon sample5;
  Weapon sample6;

  /**
   * Setup for this test suite.
   */
  @Before
  public void setUp() {
    sample1 = new TwoHandedSword("Excalibur");
    sample2 = new BroadSword("Boom");
    sample3 = new Katanas("YOYO");
    sample4 = new Flail("flail 1");
    sample5 = new Axe("Axe 1");
    sample6 = new Fists("Pacifists");
  }

  /**
   * Test if isTwoHandedSword works as expected.
   */
  @Test
  public void testIsTwoHandedSword() {
    assertTrue(sample1.isTwoHandedSword());
    assertFalse(sample2.isTwoHandedSword());
    assertFalse(sample3.isTwoHandedSword());
    assertFalse(sample4.isTwoHandedSword());
    assertFalse(sample5.isTwoHandedSword());
    assertFalse(sample6.isTwoHandedSword());
  }

  /**
   * Test if isBroadSword works as expected.
   */
  @Test
  public void testIsBroadSword() {
    assertFalse(sample1.isBroadSword());
    assertTrue(sample2.isBroadSword());
    assertFalse(sample3.isBroadSword());
    assertFalse(sample4.isBroadSword());
    assertFalse(sample5.isBroadSword());
    assertFalse(sample6.isBroadSword());
  }

  /**
   * Test if isKatanas works as expected.
   */
  @Test
  public void testIsKatanas() {
    assertFalse(sample1.isKatanas());
    assertFalse(sample2.isKatanas());
    assertTrue(sample3.isKatanas());
    assertFalse(sample4.isKatanas());
    assertFalse(sample5.isKatanas());
    assertFalse(sample6.isKatanas());
  }

  /**
   * Test if isFlail works as expected.
   */
  @Test
  public void testIsFlail() {
    assertFalse(sample1.isFlail());
    assertFalse(sample2.isFlail());
    assertFalse(sample3.isFlail());
    assertTrue(sample4.isFlail());
    assertFalse(sample5.isFlail());
    assertFalse(sample6.isFlail());
  }

  /**
   * Test if isAxe works as expected.
   */
  @Test
  public void testIsAxe() {
    assertFalse(sample1.isAxe());
    assertFalse(sample2.isAxe());
    assertFalse(sample3.isAxe());
    assertFalse(sample4.isAxe());
    assertTrue(sample5.isAxe());
    assertFalse(sample6.isAxe());
  }

  /**
   * Test if isFist works as expected.
   */
  @Test
  public void TestIsFists() {
    assertFalse(sample1.isFists());
    assertFalse(sample2.isFists());
    assertFalse(sample3.isFists());
    assertFalse(sample4.isFists());
    assertFalse(sample5.isFists());
    assertTrue(sample6.isFists());
  }

  /**
   * Test if isSword works as expected.
   */
  @Test
  public void testIsSword() {
    assertTrue(sample1.isSword());
    assertTrue(sample2.isSword());
    assertTrue(sample3.isSword());
    assertFalse(sample4.isSword());
    assertFalse(sample5.isSword());
    assertFalse(sample6.isSword());
  }

  /**
   * Test if random values of damage always fall in range for all weapons.
   */
  @Test
  public void testDamage() {
    Weapon a = new TwoHandedSword("a");
    Weapon b = new BroadSword("b");
    Weapon c = new Katanas("c");
    Weapon d = new Axe("d");
    Weapon e = new Flail("e");
    Weapon f = new Fists("f");
    Assert.assertTrue(a.getDamage() >= 8 && a.getDamage() <= 12);
    Assert.assertTrue(b.getDamage() >= 6 && b.getDamage() <= 10);
    Assert.assertTrue(c.getDamage() >= 8 && c.getDamage() <= 12);
    Assert.assertTrue(d.getDamage() >= 6 && d.getDamage() <= 10);
    Assert.assertTrue(e.getDamage() >= 8 && e.getDamage() <= 12);
    Assert.assertTrue(f.getDamage() == 1);
  }

  /**
   * Testing damage of two handed sword by player with strength below 15.
   */
  @Test
  public void testDamage_1() {
    BattlePlayer p1 = new BattlePlayer("Dheeraj", 10, 10, 10, 10);
    Weapon twoHandedSword = new TwoHandedSword("Haha", 10);
    p1.assignWeapon(twoHandedSword);
    assertEquals(5, p1.getWeaponDamage(), 0.1);
  }

  /**
   * Testing damage of two handed sword by player with strength more than or equal to 15.
   */
  @Test
  public void testDamage_2() {
    BattlePlayer p1 = new BattlePlayer("Dheeraj", 10, 15, 10, 10);
    Weapon twoHandedSword = new TwoHandedSword("Haha", 10);
    p1.assignWeapon(twoHandedSword);
    assertEquals(10, p1.getWeaponDamage(), 0.1);
  }

  /**
   * Testing damage of flail by player with dexterity below 15.
   */
  @Test
  public void testDamage_3() {
    BattlePlayer p1 = new BattlePlayer("Dheeraj", 10, 10, 10, 10);
    Weapon flail = new Flail("Haha", 10);
    p1.assignWeapon(flail);
    assertEquals(5, p1.getWeaponDamage(), 0.1);
  }

  /**
   * Testing damage of two handed sword by player with dexterity more than or equal to 15.
   */
  @Test
  public void testDamage_4() {
    BattlePlayer p1 = new BattlePlayer("Dheeraj", 15, 10, 10, 10);
    Weapon flail = new Flail("Haha", 10);
    p1.assignWeapon(flail);
    assertEquals(10, p1.getWeaponDamage(), 0.1);
  }

  /**
   * Testing damage of katanas by a player.
   */
  @Test
  public void testDamage_5() {
    BattlePlayer p1 = new BattlePlayer("Dheeraj", 15, 10, 10, 10);
    Weapon katanas = new Katanas("Haha", 4, 5);
    p1.assignWeapon(katanas);
    assertEquals(9, p1.getWeaponDamage(), 0.1);
  }


  /**
   * Testing damage of broad sword by a player.
   */
  @Test
  public void testDamage_6() {
    BattlePlayer p1 = new BattlePlayer("Dheeraj", 10, 10, 10, 10);
    Weapon broadSword = new BroadSword("Haha", 8);
    p1.assignWeapon(broadSword);
    assertEquals(8, p1.getWeaponDamage(), 0.1);
  }

  /**
   * Testing damage of an axe by a player.
   */
  @Test
  public void testDamage_7() {
    BattlePlayer p1 = new BattlePlayer("Dheeraj", 10, 10, 10, 10);
    Weapon axe = new Axe("Haha", 7);
    p1.assignWeapon(axe);
    assertEquals(7, p1.getWeaponDamage(), 0.1);
  }

  /**
   * Testing max damage of two handed sword by player with strength below 15.
   */
  @Test
  public void testMaxDamage_1() {
    BattlePlayer p1 = new BattlePlayer("Dheeraj", 10, 10, 10, 10);
    Weapon twoHandedSword = new TwoHandedSword("Haha", 10);
    p1.assignWeapon(twoHandedSword);
    assertEquals(6, p1.getWeaponMaxDamage(), 0.1);
  }

  /**
   * Testing max damage of two handed sword by player with strength more than or equal to 15.
   */
  @Test
  public void testMaxDamage_2() {
    BattlePlayer p1 = new BattlePlayer("Dheeraj", 10, 15, 10, 10);
    Weapon twoHandedSword = new TwoHandedSword("Haha", 10);
    p1.assignWeapon(twoHandedSword);
    assertEquals(12, p1.getWeaponMaxDamage(), 0.1);
  }

  /**
   * Testing max damage of flail by player with dexterity below 15.
   */
  @Test
  public void testMaxDamage_3() {
    BattlePlayer p1 = new BattlePlayer("Dheeraj", 10, 10, 10, 10);
    Weapon flail = new Flail("Haha", 10);
    p1.assignWeapon(flail);
    assertEquals(6, p1.getWeaponMaxDamage(), 0.1);
  }

  /**
   * Testing max damage of two handed sword by player with dexterity more than or equal to 15.
   */
  @Test
  public void testMaxDamage_4() {
    BattlePlayer p1 = new BattlePlayer("Dheeraj", 15, 10, 10, 10);
    Weapon flail = new Flail("Haha", 10);
    p1.assignWeapon(flail);
    assertEquals(12, p1.getWeaponMaxDamage(), 0.1);
  }

  /**
   * Testing max damage of katanas by a player.
   */
  @Test
  public void testMaxDamage_5() {
    BattlePlayer p1 = new BattlePlayer("Dheeraj", 15, 10, 10, 10);
    Weapon katanas = new Katanas("Haha", 4, 5);
    p1.assignWeapon(katanas);
    assertEquals(12, p1.getWeaponMaxDamage(), 0.1);
  }


  /**
   * Testing max damage of broad sword by a player.
   */
  @Test
  public void testMaxDamage_6() {
    BattlePlayer p1 = new BattlePlayer("Dheeraj", 10, 10, 10, 10);
    Weapon broadSword = new BroadSword("Haha", 8);
    p1.assignWeapon(broadSword);
    assertEquals(10, p1.getWeaponMaxDamage(), 0.1);
  }

  /**
   * Testing max damage of an axe by a player.
   */
  @Test
  public void testMaxDamage_7() {
    BattlePlayer p1 = new BattlePlayer("Dheeraj", 10, 10, 10, 10);
    Weapon axe = new Axe("Haha", 7);
    p1.assignWeapon(axe);
    assertEquals(10, p1.getWeaponMaxDamage(), 0.1);
  }
}