package battle;

abstract class AbstractOrgan implements Organ {

  protected boolean isHead() {
    return false;
  }

  protected boolean isFeet() {
    return false;
  }

  protected boolean isTorso() {
    return false;
  }

  protected boolean isStomach() {
    return false;
  }
}
