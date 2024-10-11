package structureTest;

import static org.junit.Assert.*;
import org.junit.Test;

import structure.Grid;

public class testGrid {
	@Test()
	public void testCreateGrid() {
		assertEquals(3, new Grid(3).getSize());
	}
}