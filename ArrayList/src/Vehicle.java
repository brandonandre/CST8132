
/**
 * The abstract vehicle class used for the different types of vehicles.
 * @author Brandon Andre
 *
 */
public abstract class Vehicle {

  /**
   * The amount of wheels on the vehicle.
   */
  private int wheels;
  
  /**
   * The current speed of the vehicle.
   */
  protected double speed;
  
  /**
   * Sole Constructor.
   * When the vehicle is created, the speed should start at zero.
   */
  public Vehicle(int wheels) {
    speed = 0;
    this.wheels = wheels;
  }
  
  /**
   * The sound the vehicle will make depending on the speed and other factors.
   * @return the string of the sound.
   */
  public abstract String noise();
  
  /**
   * Push the pedal on the vehicle to increase the speed. 
   */
  public abstract void pushPedal();
  
  /**
   * Returns the speed of the vehicle.
   * @return Speed in kilometers per hour.
   */
  public double getSpeed(){
    return speed;
  }

}
