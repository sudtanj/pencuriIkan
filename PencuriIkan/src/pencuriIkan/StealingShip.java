package pencuriIkan;

import java.awt.Point;

// TODO: Auto-generated Javadoc
/**
 * The Class StealingShip.
 *
 * @author Sudono Tanjung
 */
public class StealingShip extends MovingObject {

	/**
	 * Instantiates a new stealing ship.
	 *
	 * @author Sudono Tanjung
	 * @param objectPoint
	 *            the object point
	 */
	public StealingShip(Point objectPoint) {
		super(objectPoint,"ship.png");
		// TODO Auto-generated constructor stub
		this.setObjectSize(200,200);
		this.setObjectLocation(objectPoint);
	}
	
	/**
	 * Instantiates a new stealing ship.
	 *
	 * @author Sudono Tanjung
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public StealingShip(int x,int y){
		this(new Point(x,y));
	}

}
