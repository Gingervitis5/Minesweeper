/*	Author: Graham Mix
 * 	Revision #: 1
 * 	Revision Author: Graham Mix
 * 	Description: MinesweeperMain will create a minefield by reading from 
 * 	standard input. The minefield is then passed to MinefieldSolver,
 * 	solved, and returned to this class. Main will then print out the minefield.
 */	
import java.util.*;

public class MinesweeperMain {

	private static MinefieldSolver solver;
	private static int fieldNum = 1;
	
	/* main will collect information about the current minefield and
	 * pass it to the solver. The best way to enter input is to use
	 * MinefieldBuilder and copy/paste the contents of minefields.txt
	 * into the console when running this program.
	*/
	public static void main(String[] args) {
		Scanner sysIn = new Scanner(System.in);
		char[][] minefield;
		int rows, cols;
		rows = sysIn.nextInt();
		cols = sysIn.nextInt();
		System.out.println();
		sysIn.nextLine();
		
		while (rows > 0 && cols > 0) {
			minefield = new char[rows][cols];
			for (int i = 0; i < rows; i++) {
				minefield[i] = sysIn.nextLine().toCharArray();
			}//end i
			solver = new MinefieldSolver(minefield);
			int[][] solved = solver.getSolvedField();
			printField(solved);
			rows = sysIn.nextInt();
			cols = sysIn.nextInt();
			sysIn.nextLine();
		}//end while
		sysIn.close();
	}
	
	//prints out a solved minefield
	private static void printField(int[][] field) {
		System.out.println("Field #" + fieldNum + ":"); fieldNum++;
		for (int i = 1; i < field.length-1; i++) {
			for (int j = 1; j < field[0].length-1; j++) {
				if (field[i][j] == -1) {
					System.out.print("*");
				}
				else {
					System.out.print(field[i][j]);
				}
			}//end j
			System.out.println();
		}//end i
		System.out.println();
	}

}
