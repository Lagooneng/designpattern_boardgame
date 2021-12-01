import misfortune.*;
import tex.*;
import localImpact.*;

public class Forest extends Place {
	PlaceFactory pf;
	Misfortune mf;
	Tex tex;
	LocalImpact lm;
	
	public Forest(PlaceFactory pf) {
		this.pf = pf;
		
		this.tex = this.pf.creatTex();
		this.mf = this.pf.creatMisfortune();
		lm = new ForestImpact();
	}

	@Override
	public int getTex() {
		return this.tex.getTex() - 10;
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
		return pf.getDanger() + " Forest";
	}

}
