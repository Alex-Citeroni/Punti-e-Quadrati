package structure;

public class Line {
	private Dot dot1, dot2;

	public Line(Dot dot1, Dot dot2) {
		this.dot1 = dot1;
		this.dot2 = dot2;
	}

	public Dot getDot1() {
		return dot1;
	}

	public Dot getDot2() {
		return dot2;
	}

	boolean isVertical() {
		return getDot1().getX() < getDot2().getX();
	}

	public void setLine() {
		if (isVertical())
			dot1.setVerticalLine(true);
		else
			dot1.setHorizontalLine(true);
	}

	public Line getStandardForm() {
		return dot1.getX() > dot2.getX() || dot1.getY() > dot2.getY() ? new Line(dot2, dot1) : this;
	}

	// Controlla se l'elemento è una istanza di Line
	@Override
	public boolean equals(Object obj) {
		Line line = (Line) obj;
		return !(obj instanceof Line) ? false
				: dot1.equals(line.dot1) && dot2.equals(line.dot2) || dot1.equals(line.dot2) && dot2.equals(line.dot1);
	}
}