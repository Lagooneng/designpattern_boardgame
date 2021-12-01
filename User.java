import java.util.Scanner;

public class User extends Player{
	Scanner scan = new Scanner(System.in);
	
	public User() {
		this.name = "User";
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
