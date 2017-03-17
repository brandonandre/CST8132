import java.awt.Color;

/** TestShapes is a test class for {@link Drawing} and {@link Shape}.
 * A TestShape object creates a new Drawing, describes it, and then prints out
 * its area.
 * 
 * @author tgk
 *
 */
public class TestShapes {

	public static void main(String[] args) {
		Shape s;
        Drawing drawing = new Drawing();
        System.out.println("Creating a Circle");
        s = new Circle(1);
        s.setColor(Color.RED);
        drawing.addShape(s);
        System.out.println("Creating a Square");
        s = new Square(1);
        s.setColor(Color.BLUE);
        drawing.addShape(s);
        System.out.println("Creating a Rectangle");
        s = new Rectangle(1,1);
        s.setColor(Color.GREEN);
        drawing.addShape(s);
        System.out.println("Creating a Triangle");
        s = new Triangle(1,1);
        s.setColor(Color.YELLOW);
        drawing.addShape(s);
        
        drawing.addShape(new Shape(){
        	{setColor(Color.BLACK);};
        	
        	int breadth;
        	public double area(){
        		return breadth;
        	}
        });
        
        drawing.addShape(new Shape(){
        	{setColor(Color.GRAY);};
        	double whozitz;
        	public double area(){
        		return 75;
        	}
        });
        
        drawing.describe();
        System.out.println("The total area is " + drawing.area());

	}
}
