package guitar;

/**
 * The guitar class is used to create all the objects the guitar requires (and
 * set the default variables). It's also used for the behaviors of the guitar
 * such as plucking a wire, turning the peg to change the wire tension and
 * fretting.
 * 
 * @author Brandon Andre
 *
 */
public class Guitar {

  /**
   * Amount of wires the program needs to generate.
   */
  public final int WIRES = 6; // How many pegs and wires will be required.

  /**
   * Array of wires that are created for the guitar.
   */
  private Wire wires[];

  /**
   * Array of pegs that are created for the guitar.
   */
  private Peg pegs[];

  /**
   * Constant value of the sixth wire (E6). Sounds an E2 note which is a midi
   * value of 40.
   */
  public final static int MIDI_E2 = 40;

  /**
   * Constant value of the fifth wire (A). Sounds an A2 note which is a midi
   * value of 45.
   */
  public final static int MIDI_A2 = 45;

  /**
   * Constant value of the fourth wire (D). Sounds an D3 note which is a midi
   * value of 50.
   */
  public final static int MIDI_D3 = 50;

  /**
   * Constant value of the third wire (G). Sounds an G3 note which is a midi
   * value of 55.
   */
  public final static int MIDI_G3 = 55;

  /**
   * Constant value of the second wire (B). Sounds an B3 note which is a midi
   * value of 59.
   */
  public final static int MIDI_B3 = 59;

  /**
   * Constant value of the first wire (E1). Sounds an E4 note which is a midi
   * value of 64.
   */
  public final static int MIDI_E4 = 64;

  /**
   * Default constructor used to create all the components that the guitar
   * requires.
   */
  public Guitar() {
    // Instantiate the board variable. Off setting it by one so wire 0 represents wire 1 and so on...
    wires = new Wire[WIRES + 1];

    // Initialize the wire variables to their default noises.
    wires[1] = new Wire(MIDI_E4);
    wires[2] = new Wire(MIDI_B3);
    wires[3] = new Wire(MIDI_G3);
    wires[4] = new Wire(MIDI_D3);
    wires[5] = new Wire(MIDI_A2);
    wires[6] = new Wire(MIDI_E2);

    // Initialize pegs
    pegs = new Peg[7];
    for (int i = 1; i < pegs.length; i++) {
      // Create an instance of peg, pass the corresponding wire to it's
      // constructor.
      pegs[i] = new Peg(wires[i]);
    }
  }

  /**
   * Pluck a specific wire on the guitar.
   * 
   * @param wireNum The specific number of the wire you want to pluck.
   */
  public void pluck(int wireNum) {
    // Using the array find the wire object then 'pluck' the corresponding wire.
    wires[wireNum].pluck();
  }

  /**
   * Fret a wire at a specific spot on the wire.
   * 
   * @param wireNum
   *          The specific wire you want to fret on.
   * @param fretNum
   *          The position of fret on the specific wire.
   */
  public void fret(int wireNum, int fretNum) {
    wires[wireNum].fret(fretNum);
  }

  /**
   * Fret and pluck at the same time.
   * 
   * @param wireNum The specific wire you want to pluck and fret.
   * @param fretNum The position of fret on the specific wire.
   */
  public void hammerOn(int wireNum, int fretNum) {
    wires[wireNum].fret(fretNum);
    wires[wireNum].pluck();
  }

  /**
   * Change the tension of the wire therefore producing a different
   * sound.
   * 
   * @param pegNum The specific number that matches with the wire, that turns the pegs.
   * @param deltaTension Based on it's current position, how much do you want to turn it.
   */
  public void turn(int pegNum, int deltaTension) {
    // Using the pegs array, change the tension based on it's current position.
    pegs[pegNum].turn(deltaTension);
  }

}
