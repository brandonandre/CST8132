/** The Rectangle class of shapes.
 * 
 * @author tgk
 *
 */
public class Rectangle extends Shape {

	 /** The length of the rectangle in unspecified units.
	  */
	 double length;
	 
	 /** The width of the rectangle in unspecified units.
	  */
	 double width;
	 
	 /** Sole constructor.
	  * 
	  * @param length The length in unspecified units.
	  * @param width The width in unspecified units.
	  */
	 public Rectangle (double length, double width) {
		 
		 this.length = length;
		 this.width = width;
	 }
	 
	 /** Calculates the area of the rectangle using the standard formula.
	  * @return The area of the rectangle in unspecified units.
	  */
	 @Override
	 public double area() {
		 return length * width;
	 }
}
