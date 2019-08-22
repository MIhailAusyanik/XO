package game;

public class DirectionPair {
	private DirectionHorizontal horizontal;
	private DirectionVertical vertical;
	
	public DirectionPair(DirectionHorizontal horizontal, DirectionVertical vertical) {
		super();
		this.horizontal = horizontal;
		this.vertical = vertical;
	}

	public DirectionHorizontal getHorisontal() {
		return horizontal;
	}

	public DirectionVertical getVertical() {
		return vertical;
	}
}
