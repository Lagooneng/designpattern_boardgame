import misfortune.*;
import tex.*;

// 추상 팩토리 패턴
public interface PlaceFactory {
	public Tex creatTex();
	public Misfortune creatMisfortune();
	public String getDanger();
}
