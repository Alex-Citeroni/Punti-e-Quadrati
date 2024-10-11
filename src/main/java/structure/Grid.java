package structure;

import java.util.ArrayList;
import java.util.List;

public class Grid {
	private Dot[][] grid;
	private int size, boxesCounter;
	private List<Line> lines = new ArrayList<Line>();

	public Grid(int size) {
		this.size = size;
		this.grid = new Dot[size][size];
	}

	public List<Line> checkForBoxes(Line line) {
		return position(line) == 0 ? type0CheckingLines(line)
				: position(line) == 2 ? type2CheckingLines(line) : type1CheckingLines(line);
	}

	private List<Line> type1CheckingLines(Line line) {
		List<Line> list = new ArrayList<Line>();
		if (type0CheckingLines(line) != null)
			list.addAll(type0CheckingLines(line));
		if (type2CheckingLines(line) != null)
			list.addAll(type2CheckingLines(line));
		return list.size() > 0 ? list : null;
	}

	private List<Line> type2CheckingLines(Line line) {
		List<Line> list = new ArrayList<Line>();
		list.add(line);
		lines.stream().filter(l -> (line.isVertical() && (line.getDot1().equals(l.getDot2()) && !l.isVertical()
				|| line.getDot2().equals(l.getDot2()) && !l.isVertical() || hasType2OppositeParallelLine(line, l))
				|| (!line.isVertical() && (line.getDot1().equals(l.getDot2()) && l.isVertical()
						|| line.getDot2().equals(l.getDot2()) && l.isVertical()
						|| hasType2OppositeParallelLine(line, l)))))
				.forEach(l -> list.add(l));
		return list.size() == 4 ? list : null;
	}

	private List<Line> type0CheckingLines(Line line) {
		List<Line> list = new ArrayList<Line>();
		list.add(line);
		lines.stream().filter(l -> (line.isVertical() && (line.getDot1().equals(l.getDot1()) && !l.isVertical()
				|| line.getDot2().equals(l.getDot1()) && !l.isVertical() || hasType0OppositeParallelLine(line, l))
				|| (!line.isVertical() && ((line.getDot1().equals(l.getDot1()) && l.isVertical())
						|| line.getDot2().equals(l.getDot1()) && l.isVertical()
						|| hasType0OppositeParallelLine(line, l)))))
				.forEach(l -> list.add(l));
		return list.size() == 4 ? list : null;
	}

	private boolean hasType2OppositeParallelLine(Line line, Line l) {
		return line.isVertical()
				? line.getDot1().getY() - 1 == l.getDot1().getY() && line.getDot1().getX() == l.getDot1().getX()
						&& line.getDot2().getY() - 1 == l.getDot2().getY()
						&& line.getDot2().getX() == l.getDot2().getX()
				: line.getDot1().getX() - 1 == l.getDot1().getX() && line.getDot1().getY() == l.getDot1().getY()
						&& line.getDot2().getX() - 1 == l.getDot2().getX()
						&& line.getDot2().getY() == l.getDot2().getY();
	}

	private boolean hasType0OppositeParallelLine(Line line, Line l) {
		return line.isVertical()
				? line.getDot1().getY() + 1 == l.getDot1().getY() && line.getDot1().getX() == l.getDot1().getX()
						&& line.getDot2().getY() + 1 == l.getDot2().getY()
						&& line.getDot2().getX() == l.getDot2().getX()
				: line.getDot1().getX() + 1 == l.getDot1().getX() && line.getDot1().getY() == l.getDot1().getY()
						&& line.getDot2().getX() + 1 == l.getDot2().getX()
						&& line.getDot2().getY() == l.getDot2().getY();
	}

	private int position(Line line) {
		return line.getDot1().getY() == 0 && line.isVertical() || line.getDot1().getX() == 0 && !line.isVertical() ? 0
				: line.getDot1().getY() == size - 1 && line.isVertical()
						|| line.getDot1().getX() == size - 1 && !line.isVertical() ? 2 : 1;
	}

	public void addToGrid(Line line) {
		if (grid[line.getDot1().getX()][line.getDot1().getY()] != null)
			grid[line.getDot1().getX()][line.getDot1().getY()].update(line.getDot1());
		else
			grid[line.getDot1().getX()][line.getDot1().getY()] = line.getDot1();
		if (grid[line.getDot2().getX()][line.getDot2().getY()] != null)
			grid[line.getDot2().getX()][line.getDot2().getY()].update(line.getDot2());
		else
			grid[line.getDot2().getX()][line.getDot2().getY()] = line.getDot2();
	}

	public boolean checkDot(Dot dot) {
		return dot.getX() >= size || dot.getY() >= size;
	}

	public int getBoxesCounter() {
		return boxesCounter;
	}

	public void setBoxesCounter(int n) {
		boxesCounter += n;
	}

	Dot[][] getGrid() {
		return grid;
	}

	public List<Line> getLines() {
		return lines;
	}

	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("  ");
		for (int i = 0; i < size; i++)
			stringBuffer.append(i + "  ");
		stringBuffer.append("\n");
		for (int row = 0; row < size; row++) {
			stringBuffer.append(row + " ");
			for (int col = 0; col < size; col++) {
				stringBuffer.append(".");
				if (grid[row][col] == null || !grid[row][col].getHorizontalLine())
					stringBuffer.append("  ");
				else if (grid[row][col].getHorizontalLine())
					stringBuffer.append("__");
			}
			stringBuffer.append("\n");
			for (int col = 0; col < size; col++) {
				stringBuffer.append("  ");
				if (grid[row][col] == null || !grid[row][col].getVerticalLine())
					stringBuffer.append(" ");
				else if (grid[row][col].getVerticalLine())
					stringBuffer.append("|");
			}
			stringBuffer.append("\n");
		}
		return stringBuffer.toString();
	}
}