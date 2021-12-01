import java.util.Scanner;

public class User extends Player{
	private Scanner scan;
	
	public User() {
		this.name = "User";
		scan = new Scanner(System.in);
	}

	@Override
	public void setTrap() {
		place.setTrap();
	}

	@Override
	public int rollDice() {
		System.out.print("주사위를 굴리려면 아무거나 입력");
		scan.nextLine();
		return Dice.getNumber();
	}

}
