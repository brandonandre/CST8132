import java.awt.Color;

/** The abstract Shape class for all geometric shapes of a certain color and
 * area in unspecified units.
 * 
 * @author tgk
 *
 */
public abstract class Shape {
	
	
	
	/** The color of paint needed to paint the color.
	 */
	private Color color;
	
	/** Color getter.
	 * 
	 * @return The color of the shape.
	 */
	public Color getColor() {
		return color;
	}
	
	/** Color setter.
	 * 
	 * @param color The new color of the shape.
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/** Calculates the area of the shape in unspecified units.
	 * 
	 * @return The area of the shape.
	 */
    public abstract double area();
}
