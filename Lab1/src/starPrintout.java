/*
 * Created by Brandon Andre
 */

public class starPrintout {
	
	public static final int WIDTH = 30;
	
	public static void main(String[] args) {
		
	  int[] array = new int[10];
	  for (int i = array.length; i >= 0; i--){
	      array[i - 1] = 50;
	      System.out.println(i);
	  }

	  
		//Star pattern one
		for(int rows=1; rows<(WIDTH + 1); rows++){
			
			//Print stars
			for(int stars=0; stars<rows; stars++){
				System.out.print("*");
			}
			
			System.out.println("");
		}
		
		System.out.println("");
		
		//Star pattern two
		for(int rows=1; rows<(WIDTH + 1); rows++){
			
			//Print stars
			for(int stars=WIDTH + 1; stars>rows; stars--){
				System.out.print("*");
			}
			
			System.out.println("");
		}
		
		System.out.println("");
		
		//Star pattern three
		for(int row=0; row<(WIDTH + 1); row++){
			
			//Print spaces
			for(int space=(WIDTH); space>(WIDTH-row); space--){
				System.out.print(" ");
			}
			
			//Print stars
			for(int stars=WIDTH; stars>row; stars--){
				System.out.print("*");
			}
			
			System.out.println("");
		}
		
		//Star pattern four
		for(int row=1; row<(WIDTH + 1); row++){
			
			//Print spaces
			for(int space=0; space<(WIDTH-row); space++){
				System.out.print(" ");
			}
			
			//Print stars
			for(int stars=0; stars<row; stars++){
				System.out.print("*");
			}
			
			System.out.println("");
		}
		
	}

}
