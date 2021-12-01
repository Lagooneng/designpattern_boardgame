import misfortune.*;
import tex.*;
import localImpact.*;

public class Desert extends Place{
	PlaceFactory pf;
	Misfortune mf;
	Tex tex;
	LocalImpact lm;
	
	public Desert(PlaceFactory pf) {
		this.pf = pf;
		
		this.tex = this.pf.creatTex();
		this.mf = this.pf.creatMisfortune();
		this.lm = new DesertImpact();
	}

	@Override
	public int getTex() {
		return this.tex.getTex();
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
		return pf.getDanger() + " Desert";
	}

}
