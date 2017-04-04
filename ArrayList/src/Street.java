import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//TODO Test plan! Test every possible case...
//TODO Clean up code. Look up better ways to handle specific cases...
//TODO Javadoc it...

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
  
  private static ObjectInputStream input;
  private static ObjectOutputStream output; 
  
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

			//Select the directory you would like to save it to
			Path path = browseFiles(false);
			
			if (path != null){
				if (Files.exists(path)){
					
					boolean fail = false;
					
					// Open the file to save to it
					try {
						output = new ObjectOutputStream(Files.newOutputStream(path));
				    }
				    catch (IOException ioException){
				    	errorMessage("Reading Error", "Could not read the file you specified. Please try again.");
				    	fail = true;
				    } 
					
					//Loop through each vehicle object and add it to the file.
					iterator = vehicles.iterator();
					try {
						while (iterator.hasNext()){
							output.writeObject(iterator.next());
						}
					} catch (IOException e1) {
						errorMessage("Writing to file Error", "Could not write to the specified file");
						fail = true;
					} 
					
					if (!fail){
						response.setText("Saved " + vehicles.size() + " vehicles to the file " + path);
					}
					
					// Close the file being used.
				    try{
				    	if (input != null)
				    		input.close();
				      	} 
				    catch (IOException ioException){
				    	errorMessage("Could not close file", "The file specified could not be closed...");
				    } 
					
				} else {
					errorMessage("Invalid Path", "Please just select the directory you would like to save to.");
				}
			}
		}
    	
    });
    
    
    load = new JButton("Load");
    load.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			Path path = browseFiles(true);
			
			//Check if the user has canceled the dialog. 
			if (path != null){ 
				if (Files.exists(path)){
					//Open the file...
					try {
						input = new ObjectInputStream(Files.newInputStream(path));
					} catch (IOException e1) {
						errorMessage("Reading Error", "Could not read the file you specified. Please try again.");
					}
					
					//Read the file...
					//Create a temporary arrayList in case an error arises... 
					ArrayList<Vehicle> temp = new ArrayList<Vehicle>();
					boolean completed = false;
					try { 
						while (true) {
							// Dump the file!
							
							Vehicle vehicle = (Vehicle) input.readObject();
							temp.add(vehicle);
						}
					} catch (EOFException fileEndException) {
						completed = true;
					} catch (ClassNotFoundException e1) {
						errorMessage("Invalid file", "This file does not contain the correct information... Try one generated from this program.");
					} catch (IOException e1) {
						errorMessage("Reading Error", "Could not read the file you specified. Please try again.");
					} finally {
						if (completed){
							//Erase the vehicles array list with the temp one created.
							vehicles = temp;
							response.setText("Loaded " + vehicles.size() + " vehicles from the file " + path);
						}
					}
					
					//Close out the file...
				    try{
				    	if (input != null)
				    		input.close();
				      	} 
				    catch (IOException ioException){
				    	//TODO Handle this error better.
				        System.err.println("Error closing file. Terminating program...");
				        System.exit(1);
				    } 
					
				} else {
					errorMessage("Location not found", "The path given: '"+path.toString()+"' does not exist. Please enter a valid location.");
				}
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
	
	// Check if there is any vehicles on the street...
	if (!vehicles.isEmpty()){
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
	} else {
		errorMessage("Empty Street", "Nothing to simulate... Try creating some objects!");
	}
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
  
  private Path browseFiles(boolean open){
	  JFileChooser file = new JFileChooser();
	  int result;
	  file.setFileSelectionMode(JFileChooser.FILES_ONLY);
	  
	  if (open){
		  result = file.showOpenDialog(this);
	  } else {
		  result = file.showSaveDialog(this);
	  }
	  
	  if (result != JFileChooser.CANCEL_OPTION)
		  return file.getSelectedFile().toPath();
	  
	  return null; 
  }
  
  private void errorMessage(String title, String message){
	  JOptionPane.showMessageDialog(this, message, title, JOptionPane.ERROR_MESSAGE);
  }

  public static void main(String[] args) {
    // Declare and create an instance of this class (Street).
    Street thestreet = new Street();
    thestreet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    thestreet.setSize(600, 150); // set frame size
    thestreet.setVisible(true);
  }
}