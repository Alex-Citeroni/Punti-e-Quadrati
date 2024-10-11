package player;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import structure.Dot;
import structure.Grid;
import structure.Line;

public class RealPlayer extends AbstractPlayer {
	private Scanner scanner = new Scanner(System.in);

	public RealPlayer(Grid grid, String name) {
		super(grid, name);
	}

	@Override
	public Line drawLine() {
		boolean end = false;
		Line line = null;
		while (!end) {
			Matcher match = Pattern.compile("\\((\\d+),(\\d+)\\) \\((\\d+),(\\d+)\\)").matcher(scanner.nextLine());
			if (match.matches()) {
				end = true;
				line = new Line(new Dot(Integer.parseInt(match.group(1)), Integer.parseInt(match.group(2))),
						new Dot(Integer.parseInt(match.group(3)), Integer.parseInt(match.group(4))));
			} else
				System.out.println("Coordinate non corrette, riprova.");
		}
		return line.getStandardForm();
	}
}