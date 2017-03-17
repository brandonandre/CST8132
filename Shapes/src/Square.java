/** Square objects are {@link Rectangle} objects whose sides are the same length.
 * 
 * @author tgk
 *
 */
public class Square extends Rectangle {

	/** Sole constructor.
	 * 
	 * @param sideLength The length of the side of the square in unspecified units.
	 */
	public Square (double sideLength) {
    	super (sideLength, sideLength);
	}
}
