package structure;

public class Dot {
	private final int x, y;
	private boolean verticalLine, horizontalLine;

	public Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}

	boolean getVerticalLine() {
		return verticalLine;
	}

	boolean getHorizontalLine() {
		return horizontalLine;
	}

	void setVerticalLine(boolean value) {
		verticalLine = value;
	}

	void setHorizontalLine(boolean value) {
		horizontalLine = value;
	}

	void update(Dot dot) {
		if (!horizontalLine)
			horizontalLine = dot.horizontalLine;
		if (!verticalLine)
			verticalLine = dot.verticalLine;
	}

	// Controlla se l'elemento é un istanza di Dot
	@Override
	public boolean equals(Object object) {
		Dot dot = (Dot) object;
		return !(object instanceof Dot) ? false : x == dot.x && y == dot.y;
	}

	public boolean isAdjacent(Dot dot2) {
		return x == dot2.x && Math.abs(y - dot2.y) == 1 || y == dot2.y && Math.abs(x - dot2.x) == 1 ? true : false;
	}
}