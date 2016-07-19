package pencuriIkan;
import java.awt.Point;

import pencuriIkan.StaticObject;

// TODO: Auto-generated Javadoc
/**
 * The Class Island.
 *
 * @author Sudono Tanjung
 */
public class Pulau extends StaticObject {

	/**
	 * Instantiates a new island.
	 *
	 * @author Sudono Tanjung
	 * @param island
	 *            the p
	 */
	public Pulau(Point island) {
		super(island);
		this.setObjectImage("pulau2.png");
		this.setObjectSize(200, 200);
		this.setObjectLocation(island);
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
	public Pulau(int x,int y){
		this(new Point(x,y));
	}
	
}
