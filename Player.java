
public abstract class Player {
	private int budget;
	private int currentIdx;
	protected String name;
	protected Place place;
	
	public Player() {
		this.budget = 500;					// 초기 소지금 500
		this.currentIdx = 0;
	}
	
	public abstract int rollDice();
	public abstract void setTrap();
	
	// 템플릿 메소드 패턴
	public boolean action() {
		
		damegedByTrap();
		setTrap();
		localImpact();
		misfortune();
		// 훅
		if( checkBudget() ) {
			System.out.println(this.getName() + "가 패배했습니다.");
			return false;
		}
		System.out.println();
		
		return true;
	}
	
	public void localImpact() {
		String impact = this.place.localImpact();
		
		// 다음 턴에 효과가 적용됨
		if(impact.equals("Forset")) {
			System.out.println("숲에서 열매를 주워 팔았습니다. (+ 20)");
			this.setBudget(this.getBudget() + 20);
		}
		else if(impact.equals("Volcano")) {
			System.out.println("화산에서 물을 사먹었습니다. (- 20)");
		}
		else if(impact.equals("Desert")) {
			System.out.println("낙타를 타고 갑니다. (다음 턴 이동: 주사위 +1)");
			this.setCurrentIdx(this.getCurrentIdx() + 1);
		}
		else if(impact.equals("SnowMountain")) {
			System.out.println("추워서 움직이 느려집니다. (다음 턴 이동: 주사위 -1)");
			this.setCurrentIdx(this.getCurrentIdx() + 1);
		}
		else if(impact.equals("NoImpact")) {
			System.out.println("시작 지점입니다.");
		}
	}
	
	public void misfortune() {
		int mf = this.place.misfortuneCase();
		if(mf > 0) {
			System.out.println("병에 걸려 치료비를 소모했습니다.");
			this.setBudget(this.getBudget() - mf);
		}
	}
	
	public boolean checkBudget() {
		this.setBudget(this.getBudget() - this.place.getTex());
		System.out.println("현재 자금: " + this.getBudget());
		if( this.getBudget() <= 0 ) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void damegedByTrap() {
		if( place.hasTrap() ) {
			System.out.println(this.name + "가 함정에 타격");
			this.budget = this.budget - 10;
			place.removeTrap();
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	
	public int getCurrentIdx() {
		return this.currentIdx;
	}
	public void setCurrentIdx(int idx) {
		this.currentIdx = idx;
	}
	
	public void setPlace(Place place) {
		this.place = place;
	}
	public Place getPlace() {
		return this.place;
	}
	
}
