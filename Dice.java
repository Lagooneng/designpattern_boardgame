import java.util.Random;

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
