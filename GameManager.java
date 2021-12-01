import java.util.ArrayList;
import java.util.Scanner;

public class GameManager {
	ArrayList<Player> players;
	ArrayList<Place> places;
	Player player;
	Place place;
	Scanner scan;
	
	public GameManager(ArrayList<Player> players, ArrayList<Place> places) {
		this.players = players;
		this.places = places;
		this.scan =  new Scanner(System.in);
	}
	
	public boolean action() {
		int size = players.size();
		
		for( int i = 0; i < size; i++ ) {
			player = players.get(i);
			
			// 주사위 굴리기
			this.rollDice();
			
			// 트랩 대미지
			this.damegedByTrap();
						
			// 트랩 설치
			this.setTrap();
						
			// 지역 특수 효과
			this.localImpact();
			
			// 운이 나쁨
			this.misfortune();
			
			// 지갑 체크
			if( this.checkBudget() ) {
				System.out.println(player.name + "가 패배했습니다.");
				return false;
			}
			
			
			System.out.println();
			/*
			try {
				Thread.sleep(800);
			} catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
			*/
		}
		
		return true;
		
	}
	
	public void rollDice() {
		int num = player.rollDice();
		player.currentIdx = (player.currentIdx + num) % places.size();
		place = places.get(player.currentIdx);
		player.setPlace(place);
		System.out.print(player.getName() + "의 주사위: " + num);
		System.out.println(", 도착 장소: " + place.getName());
	}
	
	public boolean checkBudget() {
		player.budget = player.budget - player.place.getTex();
		System.out.println("현재 자금: " + player.budget);
		if( player.budget <= 0 ) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void damegedByTrap() {
		player.damegedByTrap();
	}
	
	public void setTrap() {
		if( !place.hasTrap() ) {
			if(player.getName().equals("User")) {
				System.out.print("트랩을 설치하겠습니까? (y): ");
				if( scan.nextLine() == "y" )  {
					player.setTrap();
				}
			}
			else {
				player.setTrap();
			}
			
		}
	}
	
	public void localImpact() {
		String impact = player.place.localImpact();
		
		// 다음 턴에 효과가 적용됨
		if(impact.equals("Forset")) {
			System.out.println("숲에서 열매를 주워 팔았습니다. (+ 20)");
			player.budget = player.budget + 20;
		}
		else if(impact.equals("Volcano")) {
			System.out.println("화산에서 물을 사먹었습니다. (- 20)");
		}
		else if(impact.equals("Desert")) {
			System.out.println("낙타를 타고 갑니다. (다음 턴 주사위 +1)");
			player.currentIdx = player.currentIdx + 1;
		}
		else if(impact.equals("SnowMountain")) {
			System.out.println("추워서 움직이 느려집니다. (다음 턴 주사위 -1)");
			player.currentIdx = player.currentIdx - 1;
		}
	}
	
	public void misfortune() {
		int mf = player.place.MisfortuneCase();
		if(mf > 0) {
			System.out.println("병에 걸려 치료비를 소모했습니다.");
			player.budget = player.budget - mf;
		}
	}
}
