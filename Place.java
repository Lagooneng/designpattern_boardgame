
public abstract class Place {
	boolean trap;
	
	public Place() {
		trap = false;
	}
	
	public abstract int getTex();
	public abstract String localImpact();
	public abstract int MisfortuneCase();
	public abstract String getName();
	
	public void setTrap() {
		trap = true;
	}
	public boolean hasTrap() {
		return trap;
	}
	public void removeTrap() {
		trap = false;
	}
}
