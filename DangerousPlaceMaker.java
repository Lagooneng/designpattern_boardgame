// 추상 팩토리 패턴
public class DangerousPlaceMaker implements PlaceMaker {

	@Override
	public Place createPlace(String name) {
		Place place = null;
		PlaceFactory placeFactory = new DangerousPlaceFactory();
		
		if(name.equals("Volcano")) {
			place = new Volcano(placeFactory);
		}
		else if(name.equals("Forest")) {
			place = new Forest(placeFactory);
		}
		else if(name.equals("Desert")) {
			place = new Desert(placeFactory);
		}
		else if(name.equals("SnowMountain")) {
			place = new SnowMountain(placeFactory);
		}
		
		return place;
	}

}
