import java.util.*;

class PuzzleGame {
	
	Board boardSolution, boardField;
	Scanner input;

	public static void main(String [] args) {
		PuzzleGame puzzleGame = new PuzzleGame();
		puzzleGame.initialize();
		puzzleGame.play();
	}

	private void initialize() {
		input = new Scanner(System.in);

		//get solution and playing field
		boardSolution = BoardFactory.getSolution();
		/*System.out.println(boardSolution);*/
		boardField = BoardFactory.getField();
	}

	private void play() {
		// display board, get move, check for win, repeat
		while(!isWin()) {
			displayBoard();
			getMove();
		}
		System.out.println("Congratulations, You won! :-)");
	}

	private void displayBoard() {
		//a single line of code goes here.
		//Use toString() method of Board
		System.out.println(boardField);
	}

	private void getMove() {
		//...
		System.out.print("Enter move [u/d/l/r] :");
		String inpMove = input.next();
		switch(inpMove.toLowerCase()) {
		case "u":
			boardField.moveUp();
			break;
		case "d":
			boardField.moveDown();
			break;
		case "l":
			boardField.moveLeft();
			break;
		case "r":
			boardField.moveRight();
			break;
		}
		
	}

	private boolean isWin() {
		//a win occurs when the playing field is equal to the solution
		return boardField.equals(boardSolution);
	}
} // end class PuzzleGame