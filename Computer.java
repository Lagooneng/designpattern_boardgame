
public class Computer extends Player {
	
	public Computer() {
		this.name = "Computer";
	}

	// 템플릿 메소드에서 내용이 다른 절차
	@Override
	public void setTrap() {
		if( !place.hasTrap() ) {
			place.setTrap();
		}
	}

	// 스트라티지 패턴
	@Override
	public int rollDice() {
		return Dice.getNumber();
	}
}
