import java.util.Random;

// 싱글턴 패턴
public class Dice {
	private volatile static Random random = null;
	
	public static int getNumber() {
		if(random == null) {
			synchronized(Dice.class) {
				if(random == null) {
					random = new Random();
				}
			}
		}
		
		return random.nextInt(6) + 1;
	}
}
