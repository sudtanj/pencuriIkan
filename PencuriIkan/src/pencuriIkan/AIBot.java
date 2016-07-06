package pencuriIkan;

import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class AIBot.
 *
 * @author Sudono Tanjung
 */
public class AIBot {
	
	/**
	 * Gets the direction.
	 *
	 * @author Sudono Tanjung
	 * @return the direction
	 */
	public int getDirection(){		
		return this.random();
	}
	
	/**
	 * Random.
	 *
	 * @author Sudono Tanjung
	 * @return the int
	 */
	private int random(){
		return new Random().nextInt(4)+1;
	}
}
