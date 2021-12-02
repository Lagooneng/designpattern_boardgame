import localImpact.*;
import misfortune.*;

// 어댑터 패턴
public class StartAdapter extends Place{
	private Start start;
	private LocalImpact lm = new NoImpact();
	private Misfortune mf = new NoMisfortune();
	
	public StartAdapter(Start start) {
		this.start = start;
	}

	@Override
	public int getTex() {
		return -start.getBonus();
	}

	@Override
	public String localImpact() {
		return lm.impact();
	}

	@Override
	public int MisfortuneCase() {
		return mf.getMisfortune();
	}

	@Override
	public String getName() {
		return "Start Point";
	}

}
