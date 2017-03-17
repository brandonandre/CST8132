/** Circle objects have a radius.
 * 
 * @author tgk
 *
 */
public class Circle extends Shape {

	/** The radius of the circle.
	 */
	double radius;
	
	/** Sole constructor.
	 * 
	 * @param radius The radius of the circle object in unspecified units.
	 */
	public Circle (double radius) {
		
		this.radius = radius;
	}
	
	/** Calculates the area of the circle with the standard formula.
	 * @return The area of the circle.
	 */
	@Override
	public double area() {
		return radius * radius * Math.PI;
	}
}
