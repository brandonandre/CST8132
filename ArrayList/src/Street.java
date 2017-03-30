import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * Generates vehicles to go on the street, and then randomly simulates the
 * vehicles that are on the street. and prints out the statics of the vehicles.
 * 
 * @see Vehicle
 * @author Brandon Andre
 *
 */
public class Street extends JFrame {
  /**
   * Random object used to generate the random integers to create a random
   * sequence of events among the vehicles.
   */
  private static final Random randomNumbers = new Random();

  /**
   * Array List containing all the vehicles used in the simulation.
   */
  private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

  private JButton newBicycleButton;
  private JButton newCarButton;
  private JButton doneButton;
  private JTextField response;

  /**
   * Sole Constructor Used to create the vehicles for the simulation, creating
   * an equal amount of bicycles and cars.
   * 
   * @see Car, Bicycle
   */
  public Street() {
    super("Street Simulation");

    response = new JTextField(40);
    
    // Create the add new Bicycle
    newBicycleButton = new JButton("Add Bicycle");

    newBicycleButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        Vehicle bike = new Bicycle();
        vehicles.add(bike);
        response.setText(bike + " was added to the Street");
      }

    });
    
    newCarButton = new JButton("Add Car");
    
    newCarButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        Vehicle car = new Car();
        vehicles.add(car);
        response.setText(car + " was added to the Street");
      }

    });
    
    doneButton = new JButton("Done");
    
    doneButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        simulate();
      }

    });
   
    
    FlowLayout layout = new FlowLayout();

    // Set the layout container to be added to the frame.
    setLayout(layout);
    
    add(newBicycleButton);
    add(newCarButton);
    add(doneButton);
    add(response);

  }

  /**
   * Simulates all the vehicles on the street, doing 6 increments of simulation.
   * With each increment it will list out all the vehicles that are on the
   * street, the current speed of the vehicle, the noises all the vehicles are
   * making, and randomly push the petal of one of the vehicles.
   */
  public void simulate() {

    
    
  }

  /**
   * Creates an instance of the Street class and run the simulation. The first
   * thing that is ran.
   * 
   * @param args
   *          unused.
   */
  public static void main(String[] args) {
    // Declare and create an instance of this class (Street).
    Street thestreet = new Street();
    thestreet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    thestreet.setSize(600, 150); // set frame size
    thestreet.setVisible(true);
  }
}