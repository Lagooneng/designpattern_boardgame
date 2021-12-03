import misfortune.*;
import tex.*;

//추상 팩토리 패턴
public class NormalPlaceFactory implements PlaceFactory {

	@Override
	public Tex creatTex() {
		return new LowTex();
	}

	@Override
	public Misfortune creatMisfortune() {
		return new NoMisfortune();
	}

	@Override
	public String getDanger() {
		return "Normal";
	}
}
