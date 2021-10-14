package battle;

import org.junit.Before;
import org.junit.Test;

public class HumanPlayerTest {

  @Before
  public void setUp() {
    Player a = new HumanPlayer("Dheeraj");
    Gear b = new Potion("Moonlight magic", false);
    Gear c = new Potion("Elf's doom", true);
    Gear d = new HeadGear("Wooden helmet", false);
    Gear e = new FootGear("Steel Sabatons", false);
    Gear f = new Belt("Steel Belt", BeltSize.LARGE, false);
    Gear g = new Belt("Torn bag", BeltSize.SMALL, true);
    a.addGear(b);
    a.addGear(c);
    a.addGear(d);
    a.addGear(e);
    a.addGear(f);
    a.addGear(g);
    System.out.println(a.toString());
  }

  @Test
  public void addGear() {
  }
//
//  @Test
//  public void effectiveStrength() {
//  }
//
//  @Test
//  public void effectiveDexterity() {
//  }
}