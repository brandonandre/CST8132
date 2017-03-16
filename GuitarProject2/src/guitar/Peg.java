package guitar;

/**
 * The peg is used to change the wire tension. Because the more you turn the peg
 * the more the wire is going to wrap around said peg. The more it wraps around
 * it the tighter the string gets creating a higher pitch noise.
 * 
 * This class is in charge of changing the tension of the wire dependent on how
 * much the peg is turned.
 * 
 * @author brandonandre
 *
 */
public class Peg {

  /**
   * Each peg is attached to a wire, so this is the wire it's referencing.
   */
  private Wire wire;

  /**
   * Constructor, passes the wire that the peg is attached to allowing it to be
   * altered.
   * 
   * @param wire The specific wire you want to attach to the peg object.
   */
  public Peg(Wire wire) {
    // Default constructor, when Peg is created pass the wire that pairs with
    // the peg.
    this.wire = wire;
  }

  /**
   * When the peg is turned, it therefore affects the wire attached to it.
   * 
   * @param deltaTension
   *          The change is relative to it's current position. The more you turn
   *          it positively the tighter the string gets creating a higher pitch
   *          noise. The more you turn it negatively, the more lose the string
   *          gets creating a lower pitch noise.
   */
  public void turn(int deltaTension) {
    // When the peg is turned change the wire that is attached to the peg.
    wire.changeTension(deltaTension);
  }

}
