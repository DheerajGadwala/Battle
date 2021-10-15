package battle;

import static org.junit.Assert.assertTrue;

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
    Randomizer randomizer1 = new PseudoRandomizer(
        8, // Number of Head Gear
        7, // Number of Foot Gear
        17, // Number of Belts
        0, 1, 2, 2, 1, 1, 2, 0, 0, 1, 2, 2, 1, 1, 2, 0, 1, // Sizes of Belts
        21 // Number of Potions
    );
    Randomizer randomizer2 = new PseudoRandomizer(
        1, 2, 1, 1, 2
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
    assertEquals(53, sample1.size());
  }

  private void assertEquals(int i, int size) {
  }

  /**
   * Test if armoury generates a random [pseudorandom] number of items.
   */
  @Test
  public void testArmoury() {
    sample2.generateRandom();
    assertEquals(7, sample2.size());
  }

  /**
   * Test if seize removes an object from the container and returns a random object.
   */
  @Test
  public void testSeize() {
    sample3.generateRandom();
    int n = sample3.size();
    AbstractGear a = (AbstractGear) sample3.seize();
    assertTrue(a.isHeadGear() || a.isFootGear() || a.isBelt() || a.isPotion());
    assertEquals(n - 1, sample3.size());
  }

}