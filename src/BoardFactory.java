import java.util.Random;

public class BoardFactory {

	public static Board getSolution() {
		PlayingPiece[][] pieces = new PlayingPiece[3][3];
		pieces[0][0] = new PlayingPiece(" ");
		pieces[1][0] = new PlayingPiece("1");
		pieces[2][0] = new PlayingPiece("2");
		pieces[0][1] = new PlayingPiece("3");
		pieces[1][1] = new PlayingPiece("4");
		pieces[2][1] = new PlayingPiece("5");
		pieces[0][2] = new PlayingPiece("6");
		pieces[1][2] = new PlayingPiece("7");
		pieces[2][2] = new PlayingPiece("8");

		Board b = new Board(0, 0, pieces);
		return b;
	}

	public static Board getField() {
		Board randomBoard = BoardFactory.getSolution();
		String[] choices = new String[]{"u", "r", "d", "l"};
		Random random = new Random();
		int limit = random.nextInt(100), i = 1;
		int randomIndex = 0;
		while(i++ < limit) {
			randomIndex = random.nextInt(4);
			switch(choices[randomIndex].toLowerCase()) {
			case "u":
				randomBoard.moveUp();
				break;
			case "d":
				randomBoard.moveDown();
				break;
			case "l":
				randomBoard.moveLeft();
				break;
			case "r":
				randomBoard.moveRight();
				break;
			}
		}
		return randomBoard;
	}

}