package pencuriIkan;

import java.awt.Point;

// TODO: Auto-generated Javadoc
/**
 * The Class Island.
 *
 * @author Sudono Tanjung
 */
public class Island extends StaticObject {

	/**
	 * Instantiates a new island.
	 *
	 * @author Sudono Tanjung
	 * @param p
	 *            the p
	 */
	public Island(Point p) {
		super(p);
		this.setObjectImage("island.png");
		this.setObjectSize(200, 200);
		this.setObjectLocation(p);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instantiates a new island.
	 *
	 * @author Sudono Tanjung
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public Island(int x,int y){
		this(new Point(x,y));
	}
	
}
