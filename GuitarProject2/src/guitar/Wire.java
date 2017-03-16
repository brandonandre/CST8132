package guitar;

/**
 * Class used to control the wire, where the tension is being stored, fret
 * numbers and actually vibrating the cable to create the noise.
 * 
 * @author brandonandre
 */
public class Wire {

  /**
   * Stores the tension of the specific wire. Depends on the peg to change the
   * tension.
   */
  private int tension;

  /**
   * Stores the fret location on the wire. Changes the sound.
   */
  private int fretNum = 0;

  /**
   * Board object, which is instance of the board object.
   */
  private Board board;

  /**
   * Constructor that sets the default tension when instance is created.
   * 
   * @param tension default tension when the instance is created.
   */
  public Wire(int tension) {
    // Receive the board class from the static factory.
    this.tension = tension;
    board = Board.getInstance();
  }

  /**
   * Vibrate the wire to produce the sound effect.
   */
  public void vibrate() {
    // The vibration creates the sound, based on the tension changes the pitch.
    board.soundNote(tension + fretNum);
  }

  /**
   * Plucking the wire attached to the instance, it will in turn vibrate the
   * wire creating the noise.
   * 
   * @see vibrate
   */
  public void pluck() {
    // Whenever the guitar is plucked it will vibrate the string.
    vibrate();
  }

  /**
   * Method that changes the fret number for the specific wire that the class is
   * attached too. Note that it sets the fret number, not delta.
   * 
   * @param fretNum Amount you want to set the fret to. Cannot be a negative integer.
   */
  public void fret(int fretNum) {
    if (fretNum < 0) {
      System.out.println("Fret cannot be set as a negative integer.");
    } else {
      this.fretNum = fretNum;
    }
  }

  /**
   * Changes the tension based on it's current position. Changing the tension
   * creates a different pitch, so when its vibrated it creates a different
   * noise.
   * 
   * @param deltaTension Based on it's current value, it changes the tension up or down.
   */
  public void changeTension(int deltaTension) {
    // Change the tension based on it's current position.
    tension += deltaTension;
  }

}
