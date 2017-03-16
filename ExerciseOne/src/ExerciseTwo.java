
public class ExerciseTwo {
	
	//Declare the array
	public int[][] myArray;
	public final int ROWS = 8;
	public final int COLUMNS = 10;

	public ExerciseTwo() {
		//Instantiate the first array
		myArray = new int[ROWS][COLUMNS];
		
		//Populate the two dimensional array
		for (int i=0; i< myArray.length; i++){
			for (int j=0; j< myArray[i].length; j++){
				
				//Depending on the number of the row add 10. 
				myArray[i][j] = (j+((myArray[i].length)*(i)) + 1);
			}
		}	
	}
	
	public static void main(String[] args) {
		//Create a new instance of ExerciseTwo and run it's methods.
		ExerciseTwo exercise = new ExerciseTwo();
		exercise.printArrayStatement();
		exercise.displayArrayTotal();
		exercise.tester();
	}
	
	public void displayArrayTotal(){
		//Loop through each item and sum up each element.
		int add = 0;
		for(int[] i: myArray){
			for(int j: i){
				add = add + j;
			}
		}
		
		//Display the sum of the amount of elements.
		System.out.println("The total sum of the elements in myArray1[][] is "+ add);
	}
	
	public void printArrayStatement(){
		//Generate the code for the array with it populated it.
		System.out.println("int[][] outputArray = {");
		for (int i=0; i< myArray.length; i++){
			//Each row
			System.out.print("	{");
			for (int j=0; j< myArray[1].length; j++){
				//Each specific number.
				int value = myArray[i][j];
				System.out.print(value);
				
				//Determine if a comma is required.
				if(value%myArray[i].length != 0){
					System.out.print(",");
				}
			}
			System.out.print("}");
			
			//Determine is a comma is required.
			if (i != (myArray.length - 1)){
				System.out.print(",");
			}
			System.out.println();
		}
		
		System.out.println("};");
	}
	
	public void tester(){
		//The generated code from the console.
		int[][] outputArray = {
				{1,2,3,4,5,6,7,8,9,10},
				{11,12,13,14,15,16,17,18,19,20},
				{21,22,23,24,25,26,27,28,29,30},
				{31,32,33,34,35,36,37,38,39,40},
				{41,42,43,44,45,46,47,48,49,50},
				{51,52,53,54,55,56,57,58,59,60},
				{61,62,63,64,65,66,67,68,69,70},
				{71,72,73,74,75,76,77,78,79,80}
			};
		
		//Using the generated array, reconstruct it in the console. But the results are now mirrored.
		System.out.println("int[][] outputArray = {");
		for (int i=(outputArray.length - 1); i>=0; i--){
			//Loop through the rows (mirrored).
			System.out.print("	{");
			for (int j=(outputArray[1].length - 1); j>=0; j--){
				//Loop through each item (mirrored).
				int value = outputArray[i][j];
				System.out.print(value);
				
				//Determine if a comma is required.
				if(j != 0){
					System.out.print(",");
				}
			}
			System.out.print("}");
			
			//Determine if a comma is required.
			if (i != 0){
				System.out.print(",");
			}
			System.out.println();
		}
		
		System.out.println("};");	
	}
}
