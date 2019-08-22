package game;

public enum DirectionVertical{
	TOP(0),
	MIDDLE(1),
	BOTTOM(2);
	
	private int directionNumber;
	
	private DirectionVertical(int number) {
		directionNumber = number;
	}

	public int getDirectionNumber() {
		return directionNumber;
	}
}
