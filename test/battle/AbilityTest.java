package battle;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test suite for Ability.
 */
public class AbilityTest {

  Ability ability1;
  Ability ability2;
  Ability ability3;
  Ability ability4;

  /**
   * Setup for this test suite.
   */
  @Before
  public void setUp() {
    ability1 = new Charisma(3);
    ability2 = new Strength(4);
    ability3 = new Dexterity(2);
    ability4 = new Constitution(1);
  }

  /**
   * Test if true is returned when isCharisma is called on a Charisma object.
   */
  @Test
  public void testValidIsCharisma() {
    Assert.assertTrue(((AbstractAbility)ability1).isCharisma());
  }

  /**
   * Test if true is returned when isStrength is called on a Strength object.
   */
  @Test
  public void testValidIsStrength() {
    Assert.assertTrue(((AbstractAbility)ability2).isStrength());
  }

  /**
   * Test if true is returned when isDexterity is called on a Dexterity object.
   */
  @Test
  public void testValidIsDexterity() {
    Assert.assertTrue(((AbstractAbility)ability3).isDexterity());
  }

  /**
   * Test if true is returned when isConstitution is called on a Constitution object.
   */
  @Test
  public void testValidIsConstitution() {
    Assert.assertTrue(((AbstractAbility)ability4).isConstitution());
  }

  /**
   * Test if false is returned when isCharisma is called on other objects.
   */
  @Test
  public void testInValidIsCharisma() {
    Assert.assertFalse(((AbstractAbility)ability2).isCharisma());
  }

  /**
   * Test if false is returned when isStrength is called on other objects.
   */
  @Test
  public void testInValidIsStrength() {
    Assert.assertFalse(((AbstractAbility)ability3).isStrength());
  }

  /**
   * Test if false is returned when isDexterity is called on other objects.
   */
  @Test
  public void testInValidIsDexterity() {
    Assert.assertFalse(((AbstractAbility)ability4).isDexterity());
  }

  /**
   * Test if false is returned when isConstitution is called on other objects.
   */
  @Test
  public void testInValidIsConstitution() {
    Assert.assertFalse(((AbstractAbility)ability1).isConstitution());
  }

  /**
   * Test if getValue returns the correct value.
   */
  @Test
  public void testGetValue() {
    Assert.assertEquals(4, ability2.getValue());
  }
}