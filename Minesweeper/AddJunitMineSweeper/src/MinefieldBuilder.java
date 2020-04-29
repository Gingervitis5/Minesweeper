/*	Author: Graham Mix
 * 	Revision #: 1
 * 	Revision Author: Graham Mix
 * 	Description: MinefieldBuilder will write to a file called minefields.txt
 * 	by asking the user over and over for the number of rows, columns, and
 * 	percentage of mines in a field. Only when a user enters a 0 for both rows 
 * 	and columns will the program stop. minefields.txt is there so the user 
 * 	may copy and paste the file's contents into the console when running
 * 	MinesweeperMain.java.
*/
import java.io.*;
import java.util.*;

public class MinefieldBuilder {

	/* main will repeatedly ask the user for minefield input,
	 * write a minefield to the file that represents the input,
	 * and repeat. 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sysIn = new Scanner(System.in);
		PrintStream fileOut = new PrintStream(new File("minefield_input.txt"));
		int numRows = 1, numCols = 1;
		double minePercentage;
		
		System.out.println("Enter a 0 for both rows or columns when finished");
		while (numRows > 0 || numCols > 0) {
			System.out.print("Enter the number of rows: ");
			numRows = sysIn.nextInt();
			if (numRows > 100) {
				System.out.println("Too many rows, setting to 100");
				numRows = 100;
			}
			System.out.print("Enter the number of columns: ");
			numCols = sysIn.nextInt();
			if (numCols > 100) {
				System.out.println("Too many columns, setting to 100");
				numCols = 100;
			}
			System.out.print("Enter the percentage between 0 and 100 of mines: ");
			minePercentage = sysIn.nextInt();
			if (minePercentage < 0) {
				System.out.println("Percentage less than 0, setting to 0");
				minePercentage = 0;
			}
			else if (minePercentage > 100) {
				System.out.println("Percentage greater than 100, setting to 100");
				minePercentage = 100;
			}
			minePercentage = minePercentage*0.01;
			
			fileOut.println(numRows + " " + numCols);
			for (int i = 0; i < numRows; i++) {
				for (int j = 0; j < numCols; j++) {
					char c;
					if (Math.random() < minePercentage) {
						c = '*';
					}
					else {
						c = '.';
					}
					fileOut.append(c);
				}//end j
				fileOut.println();
			}//end i
		}
		sysIn.close();
	}

}
