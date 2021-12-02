import java.util.ArrayList;

public class GameManager {
	private ArrayList<Player> players;
	private ArrayList<Place> places;
	private Player player;
	private Place place;
	
	public GameManager(ArrayList<Player> players, ArrayList<Place> places) {
		this.players = players;
		this.places = places;
	}
	
	public boolean action() {
		int size = players.size();
		
		for( int i = 0; i < size; i++ ) {
			player = players.get(i);
			
			// 주사위 굴리기
			this.rollDice();
			
			if(!player.action()) return false;
			
			try {
				Thread.sleep(800);
			} catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		return true;
		
	}
	
	public void rollDice() {
		int num = player.rollDice();
		player.setCurrentIdx((player.getCurrentIdx() + num) % places.size());
		place = places.get(player.getCurrentIdx());
		player.setPlace(place);
		System.out.print(player.getName() + "의 주사위: " + num);
		
		int money = place.getTex();
		if(money < 0) {
			System.out.println(", 도착 장소: " + place.getName() + ", 보너스" + (-place.getTex()) +", 넘버: " + player.getCurrentIdx());
		}
		else {
			System.out.println(", 도착 장소: " + place.getName() + ", 통행료" + place.getTex() +", 넘버: " + player.getCurrentIdx());
		}
	}
	
	
}
