import misfortune.*;
import tex.*;
import localImpact.*;

public class SnowMountain extends Place{
	PlaceFactory pf;
	Misfortune mf;
	Tex tex;
	LocalImpact lm;
	
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
	public int MisfortuneCase() {
		return mf.getMisfortune();
	}

	@Override
	public String getName() {
		return pf.getDanger() + " Snow Mountain";
	}

}
