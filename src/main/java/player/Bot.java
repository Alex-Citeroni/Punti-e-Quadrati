package player;

import strategy.Strategy;
import structure.Grid;
import structure.Line;

public class Bot extends AbstractPlayer {
	private Strategy strategy;

	public Bot(Grid grid, Strategy strategy, String name) {
		super(grid, name);
		this.strategy = strategy;
	}

	@Override
	public Line drawLine() {
		Line line = strategy.suggestLine(grid);
		while (grid.getLines().contains(line))
			line = strategy.suggestLine(grid);
		return line;
	}
}