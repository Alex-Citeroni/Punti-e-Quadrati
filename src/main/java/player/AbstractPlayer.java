package player;

import structure.Grid;

public abstract class AbstractPlayer implements Player {
	Grid grid;
	String name;

	AbstractPlayer(Grid grid, String name) {
		this.grid = grid;
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
}