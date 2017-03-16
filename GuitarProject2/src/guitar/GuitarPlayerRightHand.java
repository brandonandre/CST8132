package guitar;

public interface GuitarPlayerRightHand {

  /*
   * Pluck the given wires simultaneously (pluck them one after the other not
   * pausing between plucks) (notice the variable length argument list)
   */
  public void pluck(int... wires);

  /*
   * Pluck all wires from 6 to 1, pausing 80 milliseconds between plucks
   */
  public void strum();

  /*
   * Pluck all wires from Wire wireNum down to 1, pausing 80 milliseconds
   * between plucks
   */
  public void strum(int wireNum);

  /*
   * Pause milliSeconds number of milliseconds see SimpleSong.java for an
   * implementation of this method that you can adapt. That one takes a number
   * of seconds as its parameter, but this one will take milliseconds as its
   * parameter.
   */
  public void pause(int milliSeconds);
}
