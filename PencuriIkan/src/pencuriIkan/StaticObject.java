package pencuriIkan;

import java.awt.Point;
import java.awt.Rectangle;

// TODO: Auto-generated Javadoc
/**
 * The Class StaticObject.
 *
 * @author Sudono Tanjung
 */
public abstract class StaticObject extends GameObject{
	
	/**
	 * Instantiates a new static object.
	 *
	 * @author Sudono Tanjung
	 * @param p
	 *            the p
	 */
	public StaticObject(Point p){
		this.setObjectLocation(p);;
	}
	
	/**
	 * Sets the object image.
	 *
	 * @author Sudono Tanjung
	 * @param filePath
	 *            the new object image
	 */
	//setter and getter
	protected void setObjectImage(String filePath){
		super.setObjectImage(filePath, this.getObjectBounds());
	}
	
	/* (non-Javadoc)
	 * @see pencuriIkan.GameObject#setObjectSize(int, int)
	 */
	protected void setObjectSize(int width, int height){
		super.setObjectSize(width, height);
	}
}
