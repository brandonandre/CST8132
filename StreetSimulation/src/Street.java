import java.util.Random;

/**
 * Generates vehicles to go on the street, and then randomly simulates the
 * vehicles that are on the street. and prints out the statics of the vehicles.
 * 
 * @see Vehicle
 * @author Brandon Andre
 *
 */
public class Street {
  /**
   * Random object used to generate the random integers to create a random
   * sequence of events among the vehicles.
   */
  private static final Random randomNumbers = new Random();

  /**
   * Array containing all the vehicles used in the simulation.
   */
  private Vehicle[] vehicles;

  /**
   * Sole Constructor Used to create the vehicles for the simulation, creating
   * an equal amount of bicycles and cars.
   * 
   * @see Car, Bicycle
   */
  public Street() {
    vehicles = new Vehicle[4];
    for (int i = 0; i < 4; i++) {
      // If it's even, create a car. If it is odd, create a vehicle.
      if (i % 2 == 0) {
        vehicles[i] = new Car();
      } else {
        vehicles[i] = new Bicycle();
      }
    }
  }

  /**
   * Simulates all the vehicles on the street, doing 6 increments of simulation.
   * With each increment it will list out all the vehicles that are on the
   * street, the current speed of the vehicle, the noises all the vehicles are
   * making, and randomly push the petal of one of the vehicles.
   */
  public void simulate() {

    //Run the simulation 6 times and provide the update as well.
    for (int i = 0; i < 6; i++) {

      System.out.println("Update on the street:");

      // Print out name and speed.
      for (Vehicle vehicle : vehicles) {
        System.out.println(vehicle.toString() + " has speed " + vehicle.getSpeed());
      }

      // Output the noise being made on each of the vehicle.
      for (Vehicle vehicle : vehicles) {
        System.out.println(vehicle.toString() + ":" + vehicle.noise());
      }

      // Generate a random number based on the amount of vehicles.
      int randomPush = randomNumbers.nextInt(vehicles.length);
      System.out.println("The pedal of " + vehicles[randomPush].toString() + " was pushed \n");
      //Push the pedal of the vehicle. 
      vehicles[randomPush].pushPedal();

    }
  }

  /**
   * Creates an instance of the Street class and run the simulation. The first thing that is ran.
   * @param args unused.
   */
  public static void main(String[] args) {
    //Declare and create an instance of this class (Street).
    Street thestreet = new Street();
    thestreet.simulate();
  }
}