package projlab;
/**
 * Defines the behavior of the TentBuilder Item
 * 
 */
public class TentBuilder extends Item{
	/**
	 * Builds a Tent
	 */
	public void Use() {
		Player p = this.GetPlayer();
		Field f = p.GetField();
		Tent t = new Tent();
		if(f.GetIgloo() == null) {
			f.BuildIgloo(t);
			Controller.AddTent(t);
			p.DeleteItem(this);
		}
	}
}
