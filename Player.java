
public abstract class Player {
	private int budget;
	private int currentIdx;
	protected String name;
	public Place place;
	
	public Player() {
		this.budget = 500;					// 초기 소지금 500
		this.currentIdx = 0;
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public abstract int rollDice();
	
	public abstract void setTrap();
	
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
	
	
	public void damegedByTrap() {
		if( place.hasTrap() ) {
			System.out.println(this.name + "가 함정에 타격");
			this.budget = this.budget - 10;
		}
	}
	
	public void setPlace(Place place) {
		this.place = place;
	}
	
}
