package player;

public class PlayerPoints {
	private int points;
	private Player player;

	public PlayerPoints(Player player) {
		this.player = player;
	}

	public int getPoints() {
		return points;
	}

	public void addPoint(int n) {
		points = points + n;
	}

	public Player getPlayer() {
		return player;
	}
}