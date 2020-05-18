package projlab;


public abstract class Observable {
	private Observer observer;
	
	public void Register(Observer o) {
		observer = o;
	}
	
	public void UpdateObserver() {
		observer.Update(this);
	}
	
	public void Deregister() {
		observer = null;
	}

}
