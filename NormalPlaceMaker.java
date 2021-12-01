public class NormalPlaceMaker implements PlaceMaker {

	@Override
	public Place createPlace(String name) {
		Place place = null;
		PlaceFactory placeFactory = new NormalPlaceFactory();
		
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
