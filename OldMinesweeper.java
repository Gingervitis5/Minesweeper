/* Graham Mix

Problem 1.6.2 Minesweeper
For edge cases, I tested when there was-
1 row and m columns
m rows and 1 column
3 rows and 3 columns with a safe space in the middle
3 rows and 3 columns with a mine in the middle
1 row and 1 column with a safe space
1 row and 1 column with a mine
*/
import java.util.*;
import java.io.*;

public class Minesweeper {

	public static int[][] setField(int row, int col){
		int[][]field = new int[row+2][col+2];
		int x = 0, y = 0;
		while (y < col+2) {
			field[x][y] = -2;
			field[x+row+1][y] = -2;
			y++;
		}
		x = 1; y = 0;
		while (x < row+2) {
			field[x][y] = -2;
			field[x][y+col+1] = -2;
			x++;
		}
		x = 1; y = 1;
		for (;x < row; x++) {
			for (;y < col; y++) {
				field[x][y] = 0;
			}
		}
		
		return field;
	}
	
	public static void increment(int row, int col, int[][] field) {
		int x = -1, y = -1;
		for (;x <= 1; x++, y = -1) {
			for(;y <= 1; y++) {
				if (field[row+x][col+y] != -2 && field[row+x][col+y] != -1) {
					++field[row+x][col+y];
				}
			}
		}
	}
	
	public static void printField(int row, int col, int[][]field) {
		int x, y;
		for (x = 1; x <= row; x++, y = 1) {
			for (y = 1; y <= col; y++) {
				if (field[x][y] == -1) {
					System.out.print("*");
				}
				else {
					System.out.print(field[x][y]);
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		String inputFileName = "input.txt";
		if (args.length == 1) {
			inputFileName = args[0];
		}
		
		Scanner scan = new Scanner(new File(inputFileName));
		int x = 1, y = 1, num = 1;
		int row = scan.nextInt();
		int col = scan.nextInt();
		int[][]field = setField(row, col);
		
		while(row != 0 && col != 0) {
			for (;x <= row; x++, y = 1) {
				for(;y <= col; y++) {
					char element = scan.next().charAt(0);
					if (element == '*') {
						field[x][y] = -1;
						increment(x,y,field);
					}
				}
			}
			System.out.print("Field #" + num + "\n"); num++;
			printField(row, col, field);
			x = 1; y = 1;
			row = scan.nextInt();
			col = scan.nextInt();
			field = setField(row, col);
		}
		
		scan.close();
	}

}
