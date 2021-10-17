package external;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import battle.Axe;
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
}