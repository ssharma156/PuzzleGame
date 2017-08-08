import java.util.*;

public class Board {
	
	private int holeX, holeY;
	private PlayingPiece[][] pieces;

	public Board( int holeX, int holeY, PlayingPiece[][] pieces) {
		this.holeX = holeX;
		this.holeY = holeY;
		this.pieces = pieces;
	}

	public boolean equals(Object o) {
		//Make sure you explain this cast
		Board b = (Board) o;

		// Explain what deepEquals is in your code
		return Arrays.deepEquals(pieces, b.pieces);
	}

	public void moveUp() {
		// we can only move up if the hole is in the top two rows
		if (holeY == 0 || holeY == 1)
			// hole moves down when a piece moves up
			move(holeX, holeY + 1);
	}

	public void moveDown() {
		if(holeY == 1 || holeY == 2) 
			move(holeX, holeY - 1);
	}

	public void moveLeft() {
		if( holeX == 0 || holeX == 1)
			move(holeX + 1, holeY);
	}

	public void moveRight() {
		if(holeX == 1 || holeX == 2)
			move(holeX - 1, holeY);
	}

	private void move(int newHoleX, int newHoleY) {
		// swap the playing piece in (holeX, holeY) with the playing piece
 		// in newHoleX, newHoleY and update the position of the hole
		PlayingPiece temp = pieces[holeX][holeY];
		pieces[holeX][holeY] = pieces[newHoleX][newHoleY];
		pieces[newHoleX][newHoleY] = temp;
		holeX = newHoleX;
		holeY = newHoleY;
	}

	public String toString() {
		// output the board. Make it look as good as you can with ASCII
		StringBuilder pattern = new StringBuilder("");
		for (int i = 0; i <= 2; i++) {
			pattern.append("+---+---+---+\n");
			switch (i) {
			case 0:
				pattern.append("| " + pieces[i][i] + " | " + pieces[i+1][i] + " | " + pieces[i+2][i] + " |\n");
				break;
			case 1:
				pattern.append("| " + pieces[i-1][i] + " | " + pieces[i][i] + " | " + pieces[i+1][i] + " |\n");
				break;
			case 2:
				pattern.append("| " + pieces[i-2][i] + " | " + pieces[i-1][i] + " | " + pieces[i][i] + " |\n");
				break;
			}
		}
		pattern.append("+---+---+---+");
		return pattern.toString();
	}

}