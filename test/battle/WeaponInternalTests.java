package battle;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * These are tests for weapon that need to be internal.
 */
public class WeaponInternalTests {

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