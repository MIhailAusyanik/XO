package game;

public enum DirectionHorizontal{
	LEFT (0),
	CENTER (1),
	RIGHT (2);
	
	private int directionNumber;
	
	private DirectionHorizontal(int number) {
		directionNumber = number;
	}

	public int getDirectionNumber() {
		return directionNumber;
	}
}
