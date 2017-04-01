import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//TODO: Enhance GUI to include a save and read feature.
//TODO: Write a test plan of everything that could possibly go wrong.
//TODO: Add an marker interface Serializable. 
//TODO: Impliment exception handling (IO execeptions)

/**
 * Simulates the vehicles on the street. Creates the user interface in order
 * to interact and add more vehicles to the street and to run the simulation
 * process.
 * 
 * @author Brandon Andre
 */
public class Street extends JFrame {
	
  /**
   * Generates a random number in order to speed up a vehicle.
   */
  private static final Random randomNumbers = new Random();

  /**
   * Array list used to store a unfixed size of vehicles.
   */
  private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
  
  /**
   * Iterator used to go though all the vehicles. 
   */
  private Iterator<Vehicle> iterator; 

  /**
   * Bicycle button which is used to generate a new bicycle on to the street.
   */
  private JButton newBicycleButton;
  
  /**
   * Car button which is used to generate a new car on to the street.
   */
  private JButton newCarButton;
  
  /**
   * Done button to start the simulation process.
   */
  private JButton doneButton;
  
  /**
   * Response field to show what is happening.
   */
  private JTextField response;
  
  private JButton save;
  private JButton load; 

  public Street() {
    super("Street Simulation");

    response = new JTextField(50);
    
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
    
    save = new JButton("Save");
    save.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			
		}
    	
    });
    
    
    load = new JButton("Load");
    load.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			Path path = browseFiles();
			
			if (Files.exists(path)){
				
			} else {
				JOptionPane.showMessageDialog(null, "The path given: '"+path.toString()+"' does not exist. Please enter a valid location.", "Location not found", JOptionPane.ERROR_MESSAGE);
			}
			
		}
    	
    });
    
    FlowLayout layout = new FlowLayout();

    // Set the layout container to be added to the frame.
    setLayout(layout);
    
    add(newBicycleButton);
    add(newCarButton);
    add(doneButton);
    add(response);
   
    add(save);
    add(load);

  }

  public void simulate() {

    // First we need to run though all the vehicles in the system.
	// From slowest to fastest.
	  
	System.out.println("Update on the street: \n");
	
	Collections.sort(vehicles, new VechicleComparator());
	iterator = vehicles.iterator();
	
	while (iterator.hasNext()) {
		Vehicle current = iterator.next();
		System.out.println(current + " has speed " + current.getSpeed());
	}
	
	// Now shuffle the order and make the noise.
	
	Collections.shuffle(vehicles);
	iterator = vehicles.iterator();
	
	while (iterator.hasNext()) {
		Vehicle current = iterator.next();
		System.out.println(current + ":" + current.noise());
	}
	
	int randomPush = randomNumbers.nextInt(vehicles.size());
    System.out.println("The pedal of " + vehicles.get(randomPush).toString() + " was pushed \n");
    vehicles.get(randomPush).pushPedal();
    
  }
  
  public class VechicleComparator implements Comparator<Vehicle> {

	@Override
	public int compare(Vehicle v1, Vehicle v2) {
		if(v1.getSpeed() < v2.getSpeed()){
			return -1;
		} else if(v1.getSpeed() > v2.getSpeed()){
			return 1;
		} else {
			return 0;
		}
	}
	  
  }
  
  private Path browseFiles(){
	  JFileChooser file = new JFileChooser();
	  file.setFileSelectionMode(JFileChooser.FILES_ONLY);
	  
	  int result = file.showOpenDialog(this);
	  
	  if (result != JFileChooser.CANCEL_OPTION)
		  return file.getSelectedFile().toPath();
	  
	  return null; //TODO transfer this to another path name.
  }

  public static void main(String[] args) {
    // Declare and create an instance of this class (Street).
    Street thestreet = new Street();
    thestreet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    thestreet.setSize(600, 150); // set frame size
    thestreet.setVisible(true);
  }
}