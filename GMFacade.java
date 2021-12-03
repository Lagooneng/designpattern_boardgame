// 파사드 패턴
public class GMFacade {
	GameManager gm;
	
	public GMFacade() {
		gm = new GameManager();
	}
	
	public void gameOn() {
		while(gm.action());
	}
}
