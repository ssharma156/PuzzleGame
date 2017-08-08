public class PlayingPiece {

	private String label;

	// You fill in the rest. You just need a constructor
	// & make sure you implement an equals() method & a
	// toString() method

	public PlayingPiece(String label) {
		this.label = label;
	}
	
	public boolean equals(Object o) {
		PlayingPiece p = (PlayingPiece) o;
		return label.equals(p.label);
	}
	
	public String toString() {
		return label;
	}
}