package manager;

import player.Bot;
import player.RealPlayer;
import strategy.DumbStrategy;
import structure.Grid;

public class MatchController {
	private static Grid grid;

	public static Controller create1vsCPManager(int n, String name) {
		grid = new Grid(n);
		return new Controller(new RealPlayer(grid, name), new Bot(grid, new DumbStrategy(), "BOT"), grid);
	}

	public static Controller createCPvsCPManager(int n) {
		grid = new Grid(n);
		return new Controller(new Bot(grid, new DumbStrategy(), "BOT1"), new Bot(grid, new DumbStrategy(), "BOT2"),
				grid);
	}

	public static Controller create1vs1Manager(int n, String name1, String name2) {
		grid = new Grid(n);
		return new Controller(new RealPlayer(grid, name1), new RealPlayer(grid, name2), grid);
	}
}