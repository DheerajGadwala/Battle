package external;


import battle.ActualRandomizer;
import battle.Armoury;
import battle.BagOfGears;
import battle.Container;
import battle.Gear;
import battle.PseudoRandomizer;
import battle.Randomizer;
import battle.Weapon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test suite for container.
 */
public class ContainerTest {

  Container sample1;
  Container sample2;
  Container sample3;

  /**
   * Setup for this test suite.
   */
  @Before
  public void setUp() {
    Randomizer randomizer1 = new PseudoRandomizer( // For bag of gears
        8, // Number of Head Gear
        7, // Number of Foot Gear
        17, // Number of Belts
        0, 1, 2, 2, 1, 1, 2, 0, 0, 1, 2, 2, 1, 1, 2, 0, 1, // Sizes of Belts
        21 // Number of Potions
    );
    Randomizer randomizer2 = new PseudoRandomizer( // For armoury
        1, // Number of Katanas
        2, // Number of Broad swords
        1, // Number of Two handed swords
        1, // Number of axes
        2, // Number of flails
        1 // number of fists
    );
    Randomizer randomizer3 = new ActualRandomizer();
    sample1 = new BagOfGears(randomizer1);
    sample2 = new Armoury(randomizer2);
    sample3 = new BagOfGears(randomizer3);
  }

  /**
   * Test if bagOfGears generates a random [pseudorandom] number of items.
   */
  @Test
  public void testBagOfGears() {
    sample1.generateRandom();
    Assert.assertEquals(11, sample1.size());
  }

  /**
   * Test if armoury generates a random [pseudorandom] number of items.
   */
  @Test
  public void testArmoury() {
    sample2.generateRandom();
    Assert.assertEquals(8, sample2.size());
  }

  /**
   * Test if seize removes an object from the container and returns it.
   */
  @Test
  public void testSeize() {
    sample3.generateRandom();
    int n1 = sample3.size();
    Gear a = (Gear) sample3.seize();
    Assert.assertTrue(a.isHeadGear() || a.isFootGear() || a.isBelt() || a.isPotion());
    Assert.assertEquals(n1 - 1, sample3.size());
    sample2.generateRandom();
    int n2 = sample2.size();
    Weapon b = (Weapon) sample2.seize();
    Assert.assertTrue(b.isSword() || b.isAxe() || b.isFlail() || b.isFists());
    Assert.assertEquals(n2 - 1, sample2.size());
  }

  /**
   * Test to check if roughly 25% of bag of gears give negative abilities.
   */
  @Test
  public void test25Negative() {
    sample3.generateRandom();
    double total = sample3.size();
    double countNegative = 0;
    while (sample3.size() > 0) {
      Gear g = (Gear) sample3.seize();
      if (g.getAbilities().get(0).getMagnitude() <= 0) {
        countNegative++;
      }
    }
    Assert.assertEquals(25, (countNegative / total) * 100.0, 2);
  }

  /**
   * Generates more than or equal to 5 head gear.
   */
  @Test
  public void atLeast5HeadGear() {
    sample3.generateRandom();
    double count = 0;
    while (sample3.size() > 0) {
      Gear g = (Gear) sample3.seize();
      if (g.isHeadGear()) {
        count++;
      }
    }
    Assert.assertTrue(count >= 5);
  }

  /**
   * Generates more than or equal to 5 foot gear.
   */
  @Test
  public void atLeast5FootGear() {
    sample3.generateRandom();
    double count = 0;
    while (sample3.size() > 0) {
      Gear g = (Gear) sample3.seize();
      if (g.isFootGear()) {
        count++;
      }
    }
    Assert.assertTrue(count >= 5);
  }

  /**
   * .Generates more than or equal to 15 belts/
   */
  @Test
  public void atLeast15Belts() {
    sample3.generateRandom();
    double count = 0;
    while (sample3.size() > 0) {
      Gear g = (Gear) sample3.seize();
      if (g.isBelt()) {
        count++;
      }
    }
    Assert.assertTrue(count >= 15);
  }


  /**
   * Generates more than or equal to 15 potions.
   */
  @Test
  public void atLeast15Potions() {
    sample3.generateRandom();
    double count = 0;
    while (sample3.size() > 0) {
      Gear g = (Gear) sample3.seize();
      if (g.isPotion()) {
        count++;
      }
    }
    Assert.assertTrue(count >= 15);
  }
}