import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Player> players = new ArrayList<Player>();
		ArrayList<Place> places = new ArrayList<Place>();
		
		players.add(new User());
		players.add(new Computer());
		
		StartAdapter sa = new StartAdapter(new Start());
		places.add(sa);
		
		PlaceMaker pm = new NormalPlaceMaker();
		for(int i = 0; i < 9; i++) {
			places.add(pm.createPlace("Forest"));
		}
		pm = new DangerousPlaceMaker();
		places.add(pm.createPlace("Forest"));
		
		pm = new NormalPlaceMaker();
		for(int i = 0; i < 9; i++) {
			places.add(pm.createPlace("Volcano"));
		}
		pm = new DangerousPlaceMaker();
		places.add(pm.createPlace("Volcano"));
		
		pm = new NormalPlaceMaker();
		for(int i = 0; i < 9; i++) {
			places.add(pm.createPlace("Desert"));
		}
		pm = new DangerousPlaceMaker();
		places.add(pm.createPlace("Desert"));
		
		pm = new NormalPlaceMaker();
		for(int i = 0; i < 9; i++) {
			places.add(pm.createPlace("SnowMountain"));
		}
		pm = new DangerousPlaceMaker();
		places.add(pm.createPlace("SnowMountain"));
		
		GameManager gm = new GameManager(players, places);
		
		while(gm.action()) {}
	}

}
