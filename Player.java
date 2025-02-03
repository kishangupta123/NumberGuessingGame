
public class Player {
	private int chances;
	private int attempts;
	
	public Player(int chances) {
		this.chances = chances;
		this.attempts = 0;
	}
	
	public int getChances() {
		return chances;
	}
	
	public void incrementAttempts(){
		this.attempts++;
	}
	
	public void decrementChances() {
		this.chances--;
	}
	
	public int getAttempts() {
		return attempts;
	}
}
