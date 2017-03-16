/**
 * Car is a vehicle with 4 wheels and no limit on the top speed of the car.
 * @author brandonandre
 * @see Vehicle
 *
 */
public class Car extends Vehicle {

  public Car() {
    super(4);
  }

  @Override
  public String noise() {
    if (speed == 0){
      return "purr";
    } else {
      return "vroom";
    }
  }

  @Override
  public void pushPedal() {
    speed += 10;
  }
}
