package strategy;

import java.util.Random;

import structure.Dot;
import structure.Grid;
import structure.Line;

public class DumbStrategy implements Strategy {
	@Override
	public Line suggestLine(Grid grid) {
		Random random = new Random();
		int x = random.nextInt(grid.getSize()), y = random.nextInt(grid.getSize());
		return new Line(new Dot(x, y),
				getAdjacence(x, y, grid.getSize())[random.nextInt(getAdjacence(x, y, grid.getSize()).length)])
						.getStandardForm();
	}

	private Dot[] getAdjacence(int x, int y, int size) {
		return x == 0
				? y == 0 ? new Dot[] { new Dot(1, 0), new Dot(0, 1) }
						: y == size - 1 ? new Dot[] { new Dot(0, y - 1), new Dot(1, y) }
								: new Dot[] { new Dot(x + 1, y), new Dot(x, y + 1), new Dot(x, y - 1) }
				: x == size - 1
						? y == 0 ? new Dot[] { new Dot(x - 1, 0), new Dot(x, 1) }
								: y == size - 1 ? new Dot[] { new Dot(x - 1, y), new Dot(x, y - 1) }
										: new Dot[] { new Dot(x - 1, y), new Dot(x, y + 1), new Dot(x, y - 1) }
						: y == 0 ? new Dot[] { new Dot(x + 1, y), new Dot(x - 1, y), new Dot(x, y + 1) }
								: y == size - 1 ? new Dot[] { new Dot(x + 1, y), new Dot(x - 1, y), new Dot(x, y - 1) }
										: new Dot[] { new Dot(x, y - 1), new Dot(x, y + 1), new Dot(x + 1, y),
												new Dot(x - 1, y) };
	}
}