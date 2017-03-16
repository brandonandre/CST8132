
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
import javax.swing.JButton;

public class GuessGameFrame extends JFrame {
  private static Random generator = new Random();
  private int number; // number chosen by application
  private int guessCount; // number of guesses
  private int lastDistance; // distance between last guess and number
  private JTextField guessInputJTextField; // for guessing
  private JLabel prompt1JLabel; // first prompt to user
  private JLabel prompt2JLabel; // second prompt to user
  private JLabel messageJLabel; // displays message of game status
  private JButton newGameJButton; // creates new game
  private Color background; // background color of application
  private int currentDistance; 

  // set up GUI and initialize values
  public GuessGameFrame() {
    /*
     * Write a line of code that calls the superclass constructor and sets the
     * title of this application to "Guessing Game"
     */
    super("Guessing Game");

    guessCount = 0; // initialize number of guesses to 0
    background = Color.LIGHT_GRAY; // set background to light gray

    prompt1JLabel = new JLabel("I have a number between 1 and 1000."); // describe
                                                                       // game
    prompt2JLabel = new JLabel("Can you guess my number? Enter your Guess:"); // prompt
                                                                              // user

    guessInputJTextField = new JTextField(5); // to enter guesses
    guessInputJTextField.addActionListener(new GuessHandler());
    messageJLabel = new JLabel("Guess result appears here.");

    /* Write a statement that creaters the "New Game" button */
    
    newGameJButton = new JButton("New Game");
    
    newGameJButton.addActionListener(

        new ActionListener() // anonymous inner class
        {
          public void actionPerformed(ActionEvent e) {
            /*
             * Write code that resets the application to an appropriate state to
             * start a new game. Reset the background color to light gray, set
             * the JTextFields to their initial text, call method theGame and
             * repaint the GuessGame JFrame
             */

            background = Color.LIGHT_GRAY;
            paint(getGraphics());
            guessInputJTextField.setText("");
            theGame();
            repaint();

          } // end method actionPerformed
        } // end anonymous inner class
    ); // end call to addActionListener

    /*
     * Write code that will set the layout of the container to a Flowlayout,
     * then add all the GUI components to the container
     */
    
    FlowLayout layout = new FlowLayout();
    
    setLayout(layout);
    add(prompt1JLabel);
    add(prompt2JLabel);
    add(guessInputJTextField);
    add(messageJLabel);
    add(newGameJButton);
    
    theGame(); // start new game
    repaint();
    
  } // end GuessGameFrame constructor

  // choose a new random number
  public void theGame() {
    /*
     * Write a statement that sets instance variable number to a random number
     * between 1 and 1000
     */
    
    number = generator.nextInt(999) + 1;
    
  } // end method theGame

  // change background color
  public void paint(Graphics g) {
    super.paint(g);
    getContentPane().setBackground(background); // set background
  } // end method paint

  // react to new guess
  public void react(int guess) {
    guessCount++; // increment guesses
    /*
     * Write code that sets instance variable currentDistance to 1000. This
     * variable�s value will be used to determine if the background color should
     * be set to red or blue to indicate that the last guess was getting closer
     * to or further from the actual number.
     */
    currentDistance = 1000;

    // first guess
    if (guessCount == 1) {
      /*
       * Write code to set instance variable lastDistance to the absolute value
       * of the difference between variables guess and number. This value will
       * 
       * be used with subsequent guesses to help set the background color.
       */
      
      lastDistance = number - guess;

      if (guess > number) {
        messageJLabel.setText("Too High. Try a lower number.");
        background = Color.RED;
        paint(getGraphics());
      } else {
        messageJLabel.setText("Too Low. Try a higher number.");
        background = Color.BLUE;
        paint(getGraphics());
      }
    } // end if
    else {
      /*
       * Write code that sets instance variable currentDistance to the absolute
       * value of the difference between variables guess and number. This
       * variable�s value will be compared with lastDistance to determine the
       * background color.
       */
      
      currentDistance = number - guess;

      // guess is too high
      if (guess > number) {
        messageJLabel.setText("Too High. Try a lower number.");

        /*
         * Write code that sets Color variable background to red if the
         * currentDistance is less than or equal to lastDistance; otherwise, set
         * background to blue. Then assign currentDistance to lastDistance.
         */
        
        background = Color.RED;
        paint(getGraphics());
        
      } // end if
      else if (guess < number) // guess is too low
      {
        messageJLabel.setText("Too Low. Try a higher number.");
        background = (currentDistance <= lastDistance) ? Color.RED : Color.BLUE;
        lastDistance = currentDistance;
       
        paint(getGraphics());
        
      } // end else if
      else // guess is correct
      {
        messageJLabel.setText("Correct!");

        /*
         * Write code that sets Color variable background to red if the
         * currentDistance is less than or equal to lastDistance; otherwise, set
         * background to blue. Then assign currentDistance to lastDistance.
         */
      } // end else

      repaint();
    } // end else
  } // end method react

  // inner class acts on user input
  class GuessHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      /*
       * Write code that will obtain the guess, convert it to an int and pass
       * that value to the react method
       */
      
      String guessedNumber = guessInputJTextField.getText();
      react(Integer.parseInt(guessedNumber));
      
      
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