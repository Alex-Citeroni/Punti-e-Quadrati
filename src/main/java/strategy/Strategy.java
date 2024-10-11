package strategy;

import structure.Grid;
import structure.Line;

public interface Strategy {
	Line suggestLine(Grid grid);
}