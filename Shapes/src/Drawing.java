/** A Drawing object is an array of non-overlapping {@link Shape} objects.   The shapes do not
 * have any positioning or orientation information.
 * @author tgk
 */
public class Drawing {
	
	/** The array of shapes in the drawing.
	 */
    private Shape[] shapes = new Shape[10];
    
    /** The index of the last drawing in shapes.
     */
    int lastShape = 0;
    
    /** Prints out a description of each shape in the drawing.
     */
    public void describe(){
    	for (Shape s: shapes){
    		if (s != null){
    			System.out.format("%s %s%n", s.getColor().toString(), s.toString());
    		}
    	}
    }
    
    /** Calculates the total area of all the shapes in the drawing (unit of length
     * is not specified).
     *
     * @return the total area of all the shapes in the drawing.
     */
    public double area(){
    	double total = 0;
    	for (Shape s: shapes){
    		if (s != null){
    			total += s.area();
    		}
    	}
    	return total;
    }
    
    /** Adds a shape to the drawing's array.
     * 
     * @param s the shape to be added to the drawing.
     */
    public void addShape(Shape s){
    	shapes[lastShape++] = s;
    }
}
