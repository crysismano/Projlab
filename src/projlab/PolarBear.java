package projlab;

import java.util.ArrayList;
/**
 *Defines the behavior of the polar bear
 *
 */
public class PolarBear extends Character {
	
	/**
	 * Moves the polarbear to the given direction
	 * @param dir the given direction
	 */
	public void Step(int dir) {
		Field f1 = this.GetField();
		Field f2 = f1.GetNeighbour(dir);
		
		if(f2 == null) {
			return;
		}
		
		f1.RemoveCharacter(this);
		f1.SetDeadly();
		
		f2.AddCharacter(this);
		
		ArrayList<Character> characters = f2.GetCharacters();
		
		if(characters.size() > 1) {
			Igloo i;
			i = f2.GetIgloo();
			if(i != null) {
				if(i.Invadable())
					Controller.GameOver();
			}
			else
				Controller.GameOver();
		}
	}
	
	public void SetField(Field f) {
		 super.SetField(f);
		 f.SetDeadly();
	}
	/**
	 * Nothing happens when it falls in water
	 */
	public void FellInWater() {}
	/**
	 * Return false, because it can't be pulled by rope
	 * @return false
	 */
	public boolean Rescuable() {
		return false;
	}
	/**
	 * Nothing happens when snow falls on it
	 */
	public void SnowFall() {}
}
