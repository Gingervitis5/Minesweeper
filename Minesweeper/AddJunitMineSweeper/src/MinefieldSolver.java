/*	Author: Corbin Smith, Graham Mix, Van Nguyen
 * 	Revision #: 1
 * 	Revision Author: Graham Mix
 * 	Description: MinefieldSolver takes in a minefield in the
 * 	constructor, creates a new minefield with two extra rows and 
 * 	columns, and begins to solve the new minefield
 */

public class MinefieldSolver {

	private char[][] field;
	private int[][] solvedField;
	
	public MinefieldSolver(char[][] field) {
		this.field = field;
		solvedField = new int[field.length+2][field[0].length+2];
		setField();
		findMines();
	}
	
	//returns a solved minefield
	public int[][] getSolvedField() {
		return this.solvedField;
	}
	
	/* setField will use the newly created 2D array of integers in the constructor
	*  and fill it according to the original fields contents. This will represent 
	*  the unsolved minefield.
	*  An example of an unsolved 2x2 minefield would be-
	*  -2 -2 -2 -2
	*  -2 -1  0 -2
	*  -2  0 -1 -2
	*  -2 -2 -2 -2
	*  0 represents open spaces, -1 represents mines, and -2 represents out-of-bounds.
	*/
	private void setField() {
		int x = 0, y = 0, row = field.length, col = field[0].length;
		while (y < col+2) {
			solvedField[x][y] = -2;
			solvedField[row+1][y] = -2;
			y++;
		}//end while
		x = 1; y = 0;
		while (x < row+2) {
			solvedField[x][y] = -2;
			solvedField[x][col+1] = -2;
			x++;
		}//end while
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				solvedField[i][j] = 0;
			}//end j
		}//end i 
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				if (field[i-1][j-1] == '*') {
					solvedField[i][j] = -1;
				}
			}//end j
		}//end i
	}
	
	/* findMines will take look at a position in the minefield and it if 
	 * doesn't contains a mine, begin the check every position around
	 * it for mines. If one is found then it will increment the current position
	 * by 1.
	 */
	private void findMines() {
		for (int i = 1; i < solvedField.length-1; i++) {
			for (int j = 1; j < solvedField[0].length-1; j++) {
				if (solvedField[i][j] != -1) {
					for (int k = -1; k < 2; k++) {
						for (int l = -1; l < 2; l++) {
							if (solvedField[i+k][j+l] == -1) {
								++solvedField[i][j];
							}
						}//end l
					}//end k
				}
			}//end j
		}//end i
	}
}
