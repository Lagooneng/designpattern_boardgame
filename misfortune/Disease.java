package misfortune;

//추상 팩토리 패턴
public class Disease implements Misfortune {
	@Override
	public int getMisfortune() {
		return 80;
	}

}
