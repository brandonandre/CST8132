
public class ExerciseOne {

  // declare the array variable.
  public int[] myArray;
  public final int AMOUNT = 10; // The amount of numbers in the array.

  public ExerciseOne() {
    // Instantiate the array variable.
    myArray = new int[AMOUNT];

    // Populate the array from 1 to 10.
    for (int i = 0; (i < (myArray.length)); i++) {
      myArray[i] += (i + 1);
    }

  }

  public static void main(String[] args) {
    // Create an object of the class, then run its methods.
    ExerciseOne exercise = new ExerciseOne();
    exercise.printArrayStatement();
    exercise.displayArrayTotal();

    // Test to make sure the output worked.
    exercise.tester();
  }

  // Generates the int[] outputArray using myArray.
  public void printArrayStatement() {
    System.out.print("int[] outputArray = {");
    for (int i = 0; i < myArray.length; i++) {
      System.out.print(myArray[i]);

      // Check if a comma is required.
      if (i != (myArray.length - 1)) {
        System.out.print(",");
      }

    }
    System.out.print("};");
    System.out.println();
  }

  // Test to make sure the output in the console is correct.
  public void tester() {
    // Copied output from console
    int[] outputArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

    System.out.print("int[] outputArray = {");
    for (int i = 0; i < outputArray.length; i++) {
      System.out.print(outputArray[i]);

      // If it's the last value, you don't need a comma.
      if (i != (outputArray.length - 1)) {
        System.out.print(",");
      }

    }
    System.out.print("};");
    System.out.println();

  }

  // Calculate the sum of all the numbers in the 'myArray' array.
  public void displayArrayTotal() {
    int add = 0;
    for (int i : myArray) {
      add = add + i;
    }
    System.out.println("The sum total of all elements of myArray is " + add);
  }

}
