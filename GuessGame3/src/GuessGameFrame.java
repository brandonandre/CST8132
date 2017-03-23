
// Lab Exercise 1 Solution: GuessGameFrame.java
// Guess the number
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

/**
 * Game class which generates a JFrame and generates the layout to go with it.
 * Including the game logic of trying to find the correct random number by
 * guessing it and getting hints towards the answer.
 */
public class GuessGameFrame extends JFrame {

	private static Random generator = new Random();
	private int number; // number chosen by application
	private int guessCount; // number of guesses
	private int lastDistance; // distance between last guess and number
	private JTextField guessInputJTextField; // for guessing
	private JLabel prompt1JLabel; // first prompt to user
	private JLabel prompt2JLabel; // second prompt to user
	private JLabel messageJLabel; // displays message of game status
	private JLabel guessJLabel; //displays the number of guesses.
	private JLabel correctNumberJLabel; //display the correct number when you win.
	private JButton newGameJButton; // creates new game
	private Color background; // background color of application
	private int currentDistance;

	/**
	 * Sole Constructor, used to generate the JFrame and generate all the
	 * default elements which will be in the layout. Including the anonymous
	 * class for the button event to handle the restart game logic.
	 */
	public GuessGameFrame() {
		/*
		 * Write a line of code that calls the superclass constructor and sets
		 * the title of this application to "Guessing Game"
		 */

		// Run the superclass constructor that creates a new JFrame and sets the
		// title of the frame.
		super("Guessing Game");

		guessCount = 0; // initialize number of guesses to 0
		background = Color.LIGHT_GRAY; // set background to light gray

		// Game instructions
		prompt1JLabel = new JLabel("I have a number between 1 and 1000.");
		prompt2JLabel = new JLabel("Can you guess my number? Enter your Guess:");

		// Initialize the text field with 5 columns allowed.
		guessInputJTextField = new JTextField(5);

		// Whenever someone has entered a guess, handle it through GuessHandler.
		guessInputJTextField.addActionListener(new GuessHandler());

		// Game instructions
		messageJLabel = new JLabel("Guess result appears here.");

		/* Write a statement that creaters the "New Game" button */

		// Initialize the new game button.
		newGameJButton = new JButton("New Game");

		// Create an action listener, and using an anonymous inner class, create
		// the new game logic.
		newGameJButton.addActionListener(

				new ActionListener() // anonymous inner class
				{
					public void actionPerformed(ActionEvent e) {
						/*
						 * Write code that resets the application to an
						 * appropriate state to start a new game. Reset the
						 * background color to light gray, set the JTextFields
						 * to their initial text, call method theGame and
						 * repaint the GuessGame JFrame
						 */

						// Set the background gray when starting over.
						background = Color.LIGHT_GRAY;
						paint(getGraphics());

						// Reset the textfield back to blank.
						guessInputJTextField.setText("");

						// Start a new game. (Generate a new number).
						theGame();

						// Redraw the frame.
						repaint();

					} // end method actionPerformed
				} // end anonymous inner class
		); // end call to addActionListener

		//Create the guess label. Which resets whenever thegame method is called. 
		guessJLabel = new JLabel();
		
		//Create the answer label, which is shown when the user has won the game.
		correctNumberJLabel = new JLabel();
		
		/*
		 * Write code that will set the layout of the container to a Flowlayout,
		 * then add all the GUI components to the container
		 */

		// Declare and initialize a flow layout.
		FlowLayout layout = new FlowLayout();

		// Set the layout container to be added to the frame.
		setLayout(layout);

		// Add all the following elements, to the frame.
		add(prompt1JLabel);
		add(prompt2JLabel);
		add(guessInputJTextField);
		add(messageJLabel);
		add(newGameJButton);
		add(guessJLabel);
		add(correctNumberJLabel);

		// Start a new game by selecting a random number.
		theGame();

		// Refresh the frame.
		repaint();

	} // end GuessGameFrame constructor

	/**
	 * Chooses a random number for the new game. Selects a number from 1 to 1000
	 * for the user to pick. If you wanted to start a new game you would call
	 * this.
	 */
	public void theGame() {
		/*
		 * Write a statement that sets instance variable number to a random
		 * number between 1 and 1000
		 */
		//Reset the value of guesses back to zero, since it's a new game. 
		guessCount = 0;
		
		//Hide the answer.
		correctNumberJLabel.setVisible(false);
		
		// Generate a random number from 1 to 1000. (Cannot be zero!)
		number = generator.nextInt(999) + 1;
		System.out.println(number);
		
		//Reset the guess counter.
		guessJLabel.setText("You have guessed "+ guessCount + " times.");

	} // end method theGame

	/**
	 * Run the paint method from the Window object, and sets the background
	 * color.
	 * 
	 * @param g The graphics window object.
	 */
	public void paint(Graphics g) {
		super.paint(g);
		getContentPane().setBackground(background); // set background
	} // end method paint

	/**
	 * Handle the logic when a guess is inputed into the program. Handle what
	 * will happen in the game.
	 * 
	 * @param guess The number the user guessed.
	 */
	public void react(int guess) {

		guessCount++; // increment guesses

		/*
		 * Write code that sets instance variable currentDistance to 1000. This
		 * variable�s value will be used to determine if the background color
		 * should be set to red or blue to indicate that the last guess was
		 * getting closer to or further from the actual number.
		 */

		currentDistance = 1000;

		// first guess
		if (guessCount == 1) {
			
			guessJLabel.setText("You have guessed "+ guessCount + " time.");
			
			/*
			 * Write code to set instance variable lastDistance to the absolute
			 * value of the difference between variables guess and number. This
			 * value will
			 * 
			 * be used with subsequent guesses to help set the background color.
			 */

			// For the first guess, we will set our current guess as our last
			// distance.
			lastDistance = Math.abs(number - guess);

			// If guess is more than the random number.
			if (guess > number) {
				messageJLabel.setText("Too High. Try a lower number.");

				// Change the background depending if you are closer (warmer) or
				// far (colder).
				background = (currentDistance >= lastDistance) ? Color.RED : Color.BLUE;

				// Repaint the background.
				paint(getGraphics());
			} else if (guess < number) {
        messageJLabel.setText("Too Low. Try a higher number.");

        // Change the background depending if you are closer (warmer) or
        // far (colder).
        background = (currentDistance >= lastDistance) ? Color.RED : Color.BLUE;

        // Repaint the background.
        paint(getGraphics());
      } else {
        
        messageJLabel.setText("Correct!");

        correctNumberJLabel.setText("The answer is " + number);
        correctNumberJLabel.setVisible(true);
        
         // Reset the background to gray.
         background = Color.LIGHT_GRAY;

         paint(getGraphics());
       
     }
		} // end if
		else {
			/*
			 * Write code that sets instance variable currentDistance to the
			 * absolute value of the difference between variables guess and
			 * number. This variables value will be compared with lastDistance
			 * to determine the background color.
			 */
			
			guessJLabel.setText("You have guessed "+ guessCount + " times.");

			// The current guess is how close you are from your guess compared
			// to random number.
			currentDistance = Math.abs(number - guess);

			// guess is too high
			if (guess > number) {
				messageJLabel.setText("Too High. Try a lower number.");

				/*
				 * Write code that sets Color variable background to red if the
				 * currentDistance is less than or equal to lastDistance;
				 * otherwise, set background to blue. Then assign
				 * currentDistance to lastDistance.
				 */

				// Change the background depending if you are closer (warmer) or
				// far (colder).
				background = (currentDistance <= lastDistance) ? Color.RED : Color.BLUE;

				// For the next guess, we must set this current distance as our
				// last distance.
				lastDistance = currentDistance;
				paint(getGraphics());

			} // end if
			else if (guess < number) // guess is too low
			{
				messageJLabel.setText("Too Low. Try a higher number.");

				// Change the background depending if you are closer (warmer) or
				// far (colder).
				background = (currentDistance <= lastDistance) ? Color.RED : Color.BLUE;

				// For the next guess, we must set this current distance as our
				// last distance.
				lastDistance = currentDistance;

				paint(getGraphics());

			} // end else if
			else // guess is correct
			{
				messageJLabel.setText("Correct!");
				
				System.out.println("CORRECT!");
				
				correctNumberJLabel.setText("The answer is " + number);
				correctNumberJLabel.setVisible(true);

				// Reset the background to gray.
				background = Color.LIGHT_GRAY;

				paint(getGraphics());

			} // end else

			repaint();
		} // end else
	} // end method react

	// inner class acts on user input
	class GuessHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Write code that will obtain the guess, convert it to an int and
			 * pass that value to the react method
			 */

			// Get the string of the guess.
			String guessedNumber = guessInputJTextField.getText();

			// Convert it into a integer, then react to it.
			try {
				react(Integer.parseInt(guessedNumber));
			} catch (NumberFormatException ex) {
				// Handle if textfield has anything other than numbers.
				JOptionPane.showMessageDialog(null, "Only numbers please.");
			}

		} // end method actionPerformed
	} // end inner class GuessHandler
} // end class GuessGameFrame

/**************************************************************************
 * (C) Copyright 1992-2012 by Deitel & Associates, Inc. and * Pearson Education,
 * Inc. All Rights Reserved. * * DISCLAIMER: The authors and publisher of this
 * book have used their * best efforts in preparing the book. These efforts
 * include the * development, research, and testing of the theories and programs
 * * to determine their effectiveness. The authors and publisher make * no
 * warranty of any kind, expressed or implied, with regard to these * programs
 * or to the documentation contained in these books. The authors * and publisher
 * shall not be liable in any event for incidental or * consequential damages in
 * connection with, or arising out of, the * furnishing, performance, or use of
 * these programs. *
 *************************************************************************/