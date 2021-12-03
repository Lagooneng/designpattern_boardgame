import misfortune.*;
import tex.*;

//추상 팩토리 패턴
public class DangerousPlaceFactory implements PlaceFactory {

	@Override
	public Tex creatTex() {
		return new HighTex();
	}

	@Override
	public Misfortune creatMisfortune() {
		return new Disease();
	}

	@Override
	public String getDanger() {
		return "Dangerous";
	}

}
