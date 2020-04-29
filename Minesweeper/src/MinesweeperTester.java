import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

class MinesweeperTester {
	
	private char[][] testField, solution, solCompare;
	private MinefieldSolver solver;
	private Scanner scan;

	@Test
	void testOnexOneHundred_Zero() {
		try {
			scan = new Scanner(new File("minefields_JUnit/Solutions/1x100_0_sol.txt"));
			testField = buildArray(1, 100, new File("minefields_JUnit/Problems/1x100_0_prob.txt"));
			solver = new MinefieldSolver(testField);
			solCompare = extractArray(solver.getSolvedField());
			solution = new char[1][100];
			for (int i = 0; i < solution.length; i++) {
				solution[i] = scan.nextLine().toCharArray();
			}
		} catch (FileNotFoundException e) {
			System.out.print(e.getMessage());
		}
		assertArrayEquals(solCompare, solution);
	}
	
	@Test
	void testOneHundredxOneHundred_Fifty() {
		try {
			scan = new Scanner(new File("minefields_JUnit/Solutions/100x100_50_sol.txt"));	
			testField = buildArray(100, 100, new File("minefields_JUnit/Problems/100x100_50_prob.txt"));
			solver = new MinefieldSolver(testField);
			solCompare = extractArray(solver.getSolvedField());
			solution = new char[100][100];
			for (int i = 0; i < solution.length; i++) {
				String line = scan.nextLine();
				for (int j = 0, k = 0; j < solution.length && k < line.length(); j++, k++) {
					solution[i][j] = line.charAt(k);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.print(e.getMessage());
		}
		assertArrayEquals(solCompare, solution);
	}

	//builds an array from a specified problem build file
	private char[][] buildArray(int r, int c, File buildFile){
		char[][] array = new char[r][c];
		try {
			Scanner inp = new Scanner(buildFile);
			for (int i = 0; i < r; i++) {
				array[i] = inp.nextLine().toCharArray();
			}
		} catch (FileNotFoundException e) {
			System.out.print(e.getMessage());
		}
		return array;
	}
	
	// Removes the -2 border around the solved field
	private char[][] extractArray(int[][] array){
		char[][] newArray = new char[array.length-2][array[0].length-2];
		for (int i = 1; i < array.length-1; i++) {
			for (int j = 1; j < array[0].length-1; j++) {
				if (array[i][j] == -1) {
					newArray[i-1][j-1] = '*';
				}
				else {
					newArray[i-1][j-1] = (char)(array[i][j] + '0');
				}
			}
		}
		return newArray;
	}
	
}
