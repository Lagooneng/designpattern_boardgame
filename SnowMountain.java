import localImpact.*;

//추상 팩토리 패턴
public class SnowMountain extends Place{
	
	public SnowMountain(PlaceFactory pf) {
		this.pf = pf;
		
		this.tex = this.pf.creatTex();
		this.mf = this.pf.creatMisfortune();
		this.lm = new SnowMountainImpact();
	}

	@Override
	public int getTex() {
		return this.tex.getTex() + 30;
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
		return pf.getDanger() + " Snow Mountain";
	}

}
