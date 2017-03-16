
/**
 * Bicycle is a vehicle that has 2 wheels and since it's powered manually it
 * only has a maximum speed of 40 km/h.
 * 
 * @author Brandon Andre
 * @see Vehicle
 *
 */
public class Bicycle extends Vehicle {

  /**
   * Sole Constructor Sets the amount of wheels that a bicycle has.
   */
  public Bicycle() {
    super(2);
  }

  /**
   * Depending on the speed it outputs a noise.
   * 
   * @returns The noise it makes depending on the speed.
   */
  @Override
  public String noise() {
    // If the speed is zero then create a sigh noise. Otherwise, even in
    // reverse, it will make a grunt noise.
    if (this.getSpeed() == 0) {
      return "sigh";
    } else {
      return "grunt";
    }
  }

  /**
   * Push the pedal to increase the speed, only if the speed is under 40 km/h.
   */
  @Override
  public void pushPedal() {
    //The maximum speed of the bike is 40 km/h.
    if (this.getSpeed() < 40) {
      speed += 4;
    }
  }

}
