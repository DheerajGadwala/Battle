package battle;

/**
 * This can contain other objects.
 * This can shuffle its components.
 * This can generate random objects.
 * This can return objects from itself.
 */
interface Container {

  /**
   * To shuffle the objects inside the container.
   */
  void shuffle();

  /**
   * To generate a random set of objects.
   */
  void generateRandom();

  /**
   * To get an object from this container.
   * Removes the object from this container.
   * @return an object
   */
  Object seize();

  /**
   * Number of objects in the container.
   * @return number of objects.
   */
  int size();

}
