import java.util.Scanner;

public class User extends Player{
	private Scanner scan;
	
	public User() {
		this.name = "User";
		scan = new Scanner(System.in);
	}

	// 템플릿 메소드에서 내용이 다른 절차
	@Override
	public void setTrap() {
		if( !place.hasTrap() ) {
			System.out.print("트랩을 설치하겠습니까? (y): ");
			if( scan.nextLine() == "y" )  {
				place.setTrap();
			}
		}
	}

	// 스트라티지 패턴
	@Override
	public int rollDice() {
		System.out.print("주사위를 굴리려면 아무거나 입력");
		scan.nextLine();
		return Dice.getNumber();
	}

}
