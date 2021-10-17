package external;

import static org.junit.Assert.assertEquals;

import battle.BattlePlayer;
import org.junit.Test;

/**
 * Test suite for the player class.
 */
public class PlayerTest {

  /**
   * Should throw illegal argument exception when name is empty.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidName() {
    new BattlePlayer("");
  }

  /**
   * Should throw illegal state exception when dexterity is not between 6-18.
   */
  @Test
  public void testInvalidDexterity() {
    try {
      new BattlePlayer("Dheeraj", 20, 8, 8, 7);
    }
    catch (IllegalStateException ise) {
      assertEquals("Invalid value for dexterity", ise.getMessage());
    }
    try {
      new BattlePlayer("Dheeraj", 4, 8, 8, 7);
    }
    catch (IllegalStateException ise) {
      assertEquals("Invalid value for dexterity", ise.getMessage());
    }
  }

  /**
   * Should throw illegal state exception when strength is not between 6-18.
   */
  @Test
  public void testInvalidStrength() {
    try {
      new BattlePlayer("Dheeraj", 7, 23, 8, 7);
    }
    catch (IllegalStateException ise) {
      assertEquals("Invalid value for strength", ise.getMessage());
    }
    try {
      new BattlePlayer("Dheeraj", 9, 2, 8, 7);
    }
    catch (IllegalStateException ise) {
      assertEquals("Invalid value for strength", ise.getMessage());
    }
  }

  /**
   * Should throw illegal state exception when charisma is not between 6-18.
   */
  @Test
  public void testInvalidCharisma() {
    try {
      new BattlePlayer("Dheeraj", 9, 8, 7, 40);
    }
    catch (IllegalStateException ise) {
      assertEquals("Invalid value for charisma", ise.getMessage());
    }
    try {
      new BattlePlayer("Dheeraj", 6, 8, 7, -10);
    }
    catch (IllegalStateException ise) {
      assertEquals("Invalid value for charisma", ise.getMessage());
    }
  }

  /**
   * Should throw illegal state exception when constitution is not between 6-18.
   */
  @Test
  public void testInvalidConstitution() {
    try {
      new BattlePlayer("Dheeraj", 6, 8, 45, 8);
    }
    catch (IllegalStateException ise) {
      assertEquals("Invalid value for constitution", ise.getMessage());
    }
    try {
      new BattlePlayer("Dheeraj", 6, 8, 5, 8);
    }
    catch (IllegalStateException ise) {
      assertEquals("Invalid value for constitution", ise.getMessage());
    }
  }
}