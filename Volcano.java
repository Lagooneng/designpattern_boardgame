import localImpact.*;

//추상 팩토리 패턴
public class Volcano extends Place {
	
	public Volcano(PlaceFactory pf) {
		this.pf = pf;
		
		this.tex = this.pf.creatTex();
		this.mf = this.pf.creatMisfortune();
		this.lm = new VolcanoImpact();
	}

	@Override
	public int getTex() {
		return this.tex.getTex() + 20;
	}

	@Override
	public String localImpact() {
		return lm.impact();
	}

	@Override
	public int misfortuneCase() {
		return mf.getMisfortune();
	}

	@Override
	public String getName() {
		return pf.getDanger() + " Volcano";
	}
	
}
