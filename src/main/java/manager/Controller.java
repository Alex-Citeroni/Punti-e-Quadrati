package manager;

import java.util.List;

import player.Player;
import player.PlayerPoints;
import structure.Grid;
import structure.Line;

public class Controller {
	private Grid grid;
	private PlayerPoints player1, player2, currentTurn;

	Controller(Player player1, Player player2, Grid grid) {
		this.grid = grid;
		this.player1 = new PlayerPoints(player1);
		this.player2 = new PlayerPoints(player2);
		this.currentTurn = this.player1;
	}

	public void nextTurn() {
		Line line = currentTurn.getPlayer().drawLine();
		insertLine(line);
		if (grid.checkForBoxes(line) != null) {
			int n = howManyBoxes(grid.checkForBoxes(line));
			currentTurn.addPoint(n);
			System.out.println(currentTurn.getPlayer().getName() + " ha formato " + n + " quadrato/i! PUNTEGGIO: "
					+ player1.getPlayer().getName() + " " + player1.getPoints() + " - " + player2.getPoints() + " "
					+ player2.getPlayer().getName());
		}
		currentTurn = currentTurn == player1 ? player2 : player1;
	}

	private void insertLine(Line line) throws IllegalArgumentException {
		if (grid.checkDot(line.getDot1()) || grid.checkDot(line.getDot2()))
			throw new IllegalArgumentException("La linea deve essere all'interno della griglia di gioco!");
		if (grid.getLines().contains(line))
			throw new IllegalArgumentException("Questa linea esiste già!");
		if (line.getDot1().equals(line.getDot2()) || !line.getDot1().isAdjacent(line.getDot2())) {
			System.out.println("I punti devono essere diversi e adiacenti! Riprova:");
			insertLine(currentTurn.getPlayer().drawLine());
		}
		grid.getLines().add(line);
		line.setLine();
		grid.addToGrid(line);
	}

	public void getWinner() {
		if (player1.getPoints() > player2.getPoints())
			System.out.println(player1.getPlayer().getName() + " vince la partita!");
		else if (player1.getPoints() < player2.getPoints())
			System.out.println(player2.getPlayer().getName() + " vince la partita!");
		else
			System.out.println("Pareggio!");
	}

	private int howManyBoxes(List<Line> list) {
		grid.setBoxesCounter(list.size() > 4 ? 2 : 1);
		return list.size() > 4 ? 2 : 1;
	}

	public Grid getGrid() {
		return grid;
	}

	public PlayerPoints getCurrentTurn() {
		return currentTurn;
	}

	public boolean finished() {
		return grid.getBoxesCounter() == (grid.getSize() - 1) * (grid.getSize() - 1);
	}
}