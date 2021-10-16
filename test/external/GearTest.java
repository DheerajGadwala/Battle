package external;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import battle.Belt;
import battle.BeltSize;
import battle.FootGear;
import battle.Gear;
import battle.HeadGear;
import battle.Potion;
import org.junit.Before;
import org.junit.Test;

/**
 * Test suite for the Gear Interface.
 */
public class GearTest {

  Gear sample1;
  Gear sample2;
  Gear sample3;
  Gear sample4;
  Gear sample5;
  Gear sample6;

  /**
   * Set up for the test suite.
   */
  @Before
  public void setUp() {
    sample1 = new FootGear("footGear1", false);
    sample2 = new HeadGear("headGear1", false);
    sample3 = new Potion("potion1", false);
    sample4 = new Belt("belt1", BeltSize.LARGE, false);
    sample5 = new HeadGear("headGear2", false, 3);
    sample6 = new FootGear("headGear2", false, 2);
  }

  /**
   * Name can not be empty.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidName_1() {
    new FootGear("", false);
  }

  /**
   * Name can not be null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidName_2() {
    new FootGear(null, false);
  }

  /**
   * Belt size can not be null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidBeltSize() {
    new Belt("belt1", null, false);
  }

  /**
   * checking if isHeadGear returns true when object is a head gear.
   */
  @Test
  public void testValidIsHeadGear() {
    Gear sample = sample2;
    assertTrue(sample.isHeadGear());
  }

  /**
   * checking if isFootGear returns true when object is a foot gear.
   */
  @Test
  public void testValidIsFootGear() {
    Gear sample;
    sample =  sample1;
    assertTrue(sample.isFootGear());
  }

  /**
   * checking if isPotion returns true when object is a potion.
   */
  @Test
  public void testValidIsPotion() {
    Gear sample =  sample3;
    assertTrue(sample.isPotion());
  }

  /**
   * checking if isBelt returns true when object is a belt.
   */
  @Test
  public void testValidIsBelt() {
    Gear sample =  sample4;
    assertTrue(sample.isBelt());
  }

  /**
   * checking if isHeadGear returns false when object is not a head gear.
   */
  @Test
  public void testInValidIsHeadGear() {
    Gear sample =  sample1;
    assertFalse(sample.isHeadGear());
  }

  /**
   * checking if isFootGear returns false when object is not a foot gear.
   */
  @Test
  public void testInValidIsFootGear() {
    Gear sample =  sample3;
    assertFalse(sample.isFootGear());
  }

  /**
   * checking if isPotion returns false when object is not a potion.
   */
  @Test
  public void testInValidIsPotion() {
    Gear sample =  sample4;
    assertFalse(sample.isPotion());
  }

  /**
   * checking if isBelt returns false when object is not a belt.
   */
  @Test
  public void testInValidIsBelt() {
    Gear sample =  sample2;
    assertFalse(sample.isBelt());
  }

  /**
   * Head gear always gives constitution.
   */
  @Test
  public void testHeadGearGivesConstitution() {
    Gear sample =  sample5;
    assertTrue(sample.getAbilities().get(0).isConstitution());
    assertTrue(sample.givesConstitution());
    assertEquals(3, sample.getAbilities().get(0).getMagnitude());
  }

  /**
   * Foot gear always gives dexterity.
   */
  @Test
  public void testFootGearGivesDexterity() {
    Gear sample =  sample6;
    assertTrue(sample.getAbilities().get(0).isDexterity());
    assertTrue(sample.givesDexterity());
    assertEquals(2, sample.getAbilities().get(0).getMagnitude());
  }

}