package projlab;

/**
 * Extends the Field class
 * Implements Unstable fields
 */
public class Unstable extends Field {
	private int maxCharacter = 2;
	private boolean flipped = false;

	/**
	 * Flips the unstable field:
	 * Sets the temperature of the characters on this field to 0, if not stabilized
	 * Removes the snow and igloo on this field, if not stabilized
	 */
	public void Flip() {

		flipped = !flipped;

		if (flipped) {
			for (Character c : GetCharacters()) {
				c.FellInWater();
			}
			igloo = null;
			snow = 0;
		}
		UpdateObserver();
	}

	/**
	 * Adds c character to the list of characters
	 * Checks the number of characters on the field after addition
	 * and flips, if applicable (more characters on the field than maxCharacters)
	 * @param c The character to be added
	 */
	public void AddCharacter(Character c) {
		super.AddCharacter(c); 
		
		if (flipped){
			c.FellInWater();
		} 
		else if (GetCharacters().size() > maxCharacter) {
			Flip();
		}
		UpdateObserver();
	}

	/**
	 * Removes the given character from the list of characters
	 * Checks the number of characters on the field after removal
	 * and flips back, if applicable (no characters on the field)
	 * @param c The character to be removed
	 */
	public void RemoveCharacter(Character c) {
		super.RemoveCharacter(c); 
		
		if (GetCharacters().size() == 0 && flipped) {
			Flip();
		}
		UpdateObserver();
	}

	/**
	 * Returns the max amount of characters the field can safely carry
	 * @return The max number of characters the field can carry
	 */
	public int GetMaxCharacter() {
		return maxCharacter;
	}

	/**
	 * Sets the max amount of characters the field can safely carry
	 * @param characters the new max number of characters the field can carry
	 */
	public void SetMaxCharacter(int characters) {
		maxCharacter = characters;
	}
	
	public boolean IsFlipped() {
		return flipped;
	}
	
	@Override
	public void ResetField() {
		super.ResetField();
		flipped = false;
	}
	
}
