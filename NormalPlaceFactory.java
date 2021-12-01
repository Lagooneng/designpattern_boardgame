import misfortune.*;
import tex.*;

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
