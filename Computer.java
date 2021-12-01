
public class Computer extends Player {
	
	public Computer() {
		this.name = "Computer";
	}

	@Override
	public void setTrap() {
		if( !place.hasTrap() ) {
			place.setTrap();
		}
	}

	@Override
	public int rollDice() {
		return Dice.getNumber();
	}
}
