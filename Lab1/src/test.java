
public class test {

	int myArray [] [] = new int [24] [10];

	public static void main(String[] args) {
		test ex3 =new test();
		ex3.printArrayStatement();
		ex3.displayArrayTotal();
	}

	public test() {
		for (int i = 0; i < 24; i++) {
			for (int j = 0; j < 10; j++) {
				myArray[i] [j] = (i*10) + j + 1;
			}
		}
		
	}
	public void printArrayStatement() {
		
		int nextrow = 0;
		System.out.print("int[] [] outputArray = {\n");
		for (int end = 0; end < 8; end++) {
			for (int j = 0; j < 10; j++) {
				System.out.print("{");
				int k=0;
				for (int i = 0; k < 3; i++) {
					System.out.print(myArray[i+nextrow][j]);
					k += 1;
					i += 7;
					if (k<3) {
						System.out.print(",");
					}
				}
				System.out.print("}");
			}
			if (end < 7) {
				System.out.print(",\n");
			}
			nextrow+=1;
		}
		System.out.print("};");
		System.out.println("");
	}

	public void displayArrayTotal() {
		int total = 0;
		for (int[] i : myArray) {
			for (int number : i) {
				total += number;
			}
		}
		System.out.println("The sum total of all elements of the array is " + total);
	}
}