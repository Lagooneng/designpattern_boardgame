import localImpact.LocalImpact;
import misfortune.Misfortune;
import tex.Tex;

public abstract class Place {
	protected boolean trap;
	protected Misfortune mf;
	protected Tex tex;
	protected LocalImpact lm;
	protected PlaceFactory pf;
	
	public Place() {
		trap = false;
	}
	
	public abstract int getTex();
	public abstract String localImpact();
	public abstract int misfortuneCase();
	public abstract String getName();
	
	public void setTrap() {
		this.trap = true;
	}
	public boolean hasTrap() {
		return trap;
	}
	public void removeTrap() {
		this.trap = false;
	}
}
