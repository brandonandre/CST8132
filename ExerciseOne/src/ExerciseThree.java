
public class ExerciseThree {

	//Declare the array variable.
	public int[][][] myArray;
	public final int ROWS = 8; //The rows of the array
	public final int COLUMNS = 10; //The groups in the array
	public final int GROUPS = 3; //Split into 3 numbers
	
	public ExerciseThree() {
		//Instantiate the array with values.
		myArray = new int[ROWS][COLUMNS][GROUPS];
		
		//Initialize the array
		for (int i=0; i<myArray.length; i++){
			//Rows
			for (int j=0; j< myArray[i].length; j++){
				//Groups of threes
				for (int k=0; k < (myArray[i][j].length); k++){
					/*
					 * Each item in the groups.
					 * Based on the location of the group the following equation
					 * is used to figure out the exact number for that specific place.
					 */
					myArray[i][j][k] = ((myArray.length * myArray[i].length)*(k) + j + myArray[i].length*(i) + 1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		//Create a new ExerciseThree instance.
		ExerciseThree exercise = new ExerciseThree();
		exercise.printArrayStatement();
		exercise.displayArrayTotal();
	}
	
	public void printArrayStatement(){
		//Generate the array code, with it populated with numbers.
		System.out.println("int[][][] outputArray = {");
		System.out.println();
		for (int i=0; i<myArray.length; i++){
			//For each row.
			
			System.out.print("	{");
			for (int j=0; j<myArray[i].length; j++){
				//For each group of threes.
				
				System.out.print("{");
				for(int k=0; k < myArray[i][j].length; k++){
					//For each specific number.
					
					int value = myArray[i][j][k];
					System.out.print(value);
					
					//Determine if a comma is needed.
					if(k != (myArray[i][j].length - 1)){
						System.out.print(",");
					}					
				}	
				
				System.out.print("}");
				
				//Determine if a comma is needed.
				if(j != (myArray[i].length - 1)){
					System.out.print(",");
				}
			}
			System.out.print("}");
			
			//Determine if a comma is needed.
			if (i != (myArray.length - 1)){
				System.out.print(",");
				System.out.println();
			}
			System.out.println();
		}
		
		System.out.println("};");
	}
	
	public void displayArrayTotal(){
		//Loop through each item and sum up each element.
		int add = 0;
		for(int[][] i: myArray){
			for(int[] j: i){
				for(int k: j){
					add = add + k;
				}
			}
		}
		
		//Display the sum of all of the elements
		System.out.println("The sum total of all of the elements of the array is " + add);
	}

}
