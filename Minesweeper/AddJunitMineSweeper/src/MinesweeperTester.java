import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

class MinesweeperTester {
	/*
	4 other tests of your choice
	 */
	private char[][] testField, solution, solCompare;
	private MinefieldSolver solver;
	private Scanner scan;
	@Test
	void OnexOne_Zero() {
		//1 x 1, no mine
		try {
			scan = new Scanner(new File("1x1_0_sol.txt"));
			testField = buildArray(1, 100, new File("1x1_0_prob.txt"));
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
	void OnexOne_One(){
		//1 x 1, 1 mine
		try {
			scan = new Scanner(new File("1x1_100_sol.txt"));
			testField = buildArray(1, 100, new File("1x1_100_prob.txt"));
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
	void testOnexOneHundred_Zero() {
		//1 x 100, no mines
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
	void testOnexOneHundred_OneHundred() {
		//1 x 100, all mines
		try {
			scan = new Scanner(new File("1x100_100_sol.txt"));
			testField = buildArray(1, 100, new File("1x100_100_prob.txt"));
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
	void testOnexOneHundred_Fifty() {
		//1 x 100, 50% mines
		try {
			scan = new Scanner(new File("1x100_50_sol.txt"));
			testField = buildArray(1, 100, new File("1x100_50_prob.txt"));
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
	void OneHundredxOne_Zero() {
		//100 x 1, no mines
		try {
			scan = new Scanner(new File("100x1_0_sol.txt"));
			testField = buildArray(1, 100, new File("100x1_0_prob.txt"));
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
	void OneHundredxOne_OneHundred() {
		//100 x 1, all mines
		try {
			scan = new Scanner(new File("100x1_100_sol.txt"));
			testField = buildArray(1, 100, new File("100x1_100_prob.txt"));
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
	void OneHundredxOne_Fifty() {
		//100 x 1, 50% mines
		try {
			scan = new Scanner(new File("100x1_50_sol.txt"));
			testField = buildArray(1, 100, new File("100x1_50_prob.txt"));
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
		//100 x 100, 50% mines
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
	@Test
	void testOneHundredxOneHundred_OneHundred() {
		//100 x 100, all mines
		try {
		scan = new Scanner(new File("100x100_100_sol.txt"));	
		testField = buildArray(100, 100, new File("100x100_100_prob.txt"));
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
	@Test
	void testOneHundredxOneHundred_Zero() {
		//100 x 100, no mines
		try {
		scan = new Scanner(new File("100x100_0_sol.txt"));	
		testField = buildArray(100, 100, new File("100x100_0_prob.txt"));
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
	@Test
	void testTwentyxFiveteeth_RandomChoice() {
		try {
			scan = new Scanner(new File("20x15_sol.txt"));	
			testField = buildArray(20, 15, new File("20x15_prob.txt"));
			solver = new MinefieldSolver(testField);
			solCompare = extractArray(solver.getSolvedField());
			solution = new char[20][15];
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
	@Test
	void testFivexFive_RandomChoice() {
		try {
			scan = new Scanner(new File("5x5_sol.txt"));	
			testField = buildArray(5, 5, new File("5x5_prob.txt"));
			solver = new MinefieldSolver(testField);
			solCompare = extractArray(solver.getSolvedField());
			solution = new char[5][5];
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
	@Test
	void testEightxFour_RandomChoice() {
		try {
			scan = new Scanner(new File("8x4_sol.txt"));	
			testField = buildArray(8, 4, new File("8x4_prob.txt"));
			solver = new MinefieldSolver(testField);
			solCompare = extractArray(solver.getSolvedField());
			solution = new char[8][4];
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
	@Test
	void testTwoxOne_RandomChoice() {
		try {
			scan = new Scanner(new File("2x1_sol.txt"));	
			testField = buildArray(2, 1, new File("2x1_prob.txt"));
			solver = new MinefieldSolver(testField);
			solCompare = extractArray(solver.getSolvedField());
			solution = new char[2][1];
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
