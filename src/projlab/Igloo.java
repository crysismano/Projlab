package projlab;

/**
 * Represent the igloo's behavior
 */
public class Igloo extends Observable {
	
	/**
	 * the igloo's current health
	 */
	private int health = 5;
	
	
	/**
	 * Decreases the igloo's health by the given amount
	 * @param s The given amount
	 * @return true if the igloo is completely destroyed, false if it's not
	 */
	public boolean Destroy(int s) {
		health -= s;
		return (health <= 0);
	}
	/**
	 * Returns with false, the igloo is not invadable
	 * @return false
	 */
	public boolean Invadable() {
		return false;
	}
}
