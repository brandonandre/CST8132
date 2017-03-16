package guitar;

/**
 * Handles the right hand actions of the guitar. Right hand deals with creating
 * the noise with plucking and strumming.
 * 
 * @author brandonandre
 *
 */
public class RightHand implements GuitarPlayerRightHand {

  /**
   * References the guitar that it is attached too.
   */
  Guitar guitar;

  /**
   * Constructor. Passes the guitar which is stored into the program to run the
   * functions the right hand needs to take care of.
   * 
   * @param guitar Passes the guitar you want the right hand to be attached too.
   */
  public RightHand(Guitar guitar) {
    // Pass the guitar to store in the class to use.
    this.guitar = guitar;
  }

  /**
   * Plucks the specific cables given. Depending on the amount of cables passed
   * through it, it will play each one. Note that it will play it instantly one
   * after the other.
   * 
   * @param wires using a variable length argument list, you can set as many specific cables as you want.
   */
  @Override
  public void pluck(int... wires) {

    // Run through each cable you selected, then pluck that cable.
    for (int i : wires) {
      guitar.pluck(i);
    }

  }

  /**
   * Triggers all of the wires from 6 to 1. Therefore plucking every single wire
   * with a 80 millisecond pause in between each pluck.
   */
  @Override
  public void strum() {
    // Starting from 6, move all the way to down the for loop, plucking all of
    // the cables.
     strum(6);
  }

  /**
   * Triggers all of the wires from a number you specifically want to 1.
   * Therefore plucking every single wire from the specific one you selected,
   * down to 1 with a 80 millisecond pause in between each pluck.
   */
  @Override
  public void strum(int wireNum) {

    // Starting from the wire you specifically want to start at, pluck all the
    // remaining wires to 1.
    for (int i = wireNum; i >= 1; i--) {
      guitar.pluck(i);
      pause(80);
    }

  }

  /**
   * Causes the thread to sleep for a specific amount of milliseconds.
   * 
   * @param milliSeconds Amount of time to pause in milliseconds.
   */
  @Override
  public void pause(int milliSeconds) {
    try {
      Thread.sleep(milliSeconds);
    } catch (InterruptedException e) {
      e.printStackTrace(); // Print the error message.
    }
  }

}
