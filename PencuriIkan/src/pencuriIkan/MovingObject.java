package pencuriIkan;

import java.awt.Point;
import java.awt.Rectangle;

// TODO: Auto-generated Javadoc
/**
 * The Class MovingObject.
 *
 * @author Sudono Tanjung
 */
public abstract class MovingObject extends GameObject {
	
	/** The moving up. */
	public final int MOVING_UP = 1;
	
	/** The moving down. */
	public final int MOVING_DOWN = 2;
	
	/** The moving left. */
	public final int MOVING_LEFT = 3;
	
	/** The moving right. */
	public final int MOVING_RIGHT = 4;
	
	/** The object is enemy. */
	public final boolean OBJECT_IS_ENEMY = false;
	
	/** The object is friendly. */
	public final boolean OBJECT_IS_FRIENDLY = true;
	
	/** The object status. */
	private boolean objectStatus=this.OBJECT_IS_FRIENDLY;
	
	/** The object target degree. */
	private double objectTargetDegree = 0;
	
	/** The object current degree. */
	private double objectCurrentDegree=0;
	
	/** The other intersect. */
	private boolean otherIntersect=false;
	
	/** The other pixel point. */
	private Point otherPixelPoint=null;
	
	/**
	 * Instantiates a new moving object.
	 *
	 * @author Sudono Tanjung
	 * @param objectPoint
	 *            the object point
	 * @param filePath
	 *            the file path
	 */
	public MovingObject(Point objectPoint, String filePath){
		this.setObjectLocation(objectPoint);
		this.setObjectImage(filePath);
	}
	
	/**
	 * Run ai as enemy.
	 *
	 * @author Sudono Tanjung
	 * @param escapePoint
	 *            the escape point
	 */
	public void runAIAsEnemy(Rectangle escapePoint){
		this.setObjectStatus(this.OBJECT_IS_ENEMY);
		new AIEnemy(escapePoint,null,this);
	}
	
	/**
	 * Move.
	 *
	 * @author Sudono Tanjung
	 * @param direction
	 *            the direction
	 */
	public void move(int direction) {
		switch (direction) {
		case MOVING_UP:
			this.setY(this.getY() - 1);
			this.setObjectTargetDegree(90);
			break;
		case MOVING_DOWN:
			this.setY(this.getY() + 1);
			this.setObjectTargetDegree(270);
			break;
		case MOVING_LEFT:
			this.setX(this.getX() - 1);
			this.setObjectTargetDegree(0);
			break;
		case MOVING_RIGHT:
			this.setX(this.getX() + 1);
			this.setObjectTargetDegree(180);
			break;
		}
	}
	
	/**
	 * Checks if is collide.
	 *
	 * @author Sudono Tanjung
	 * @param other
	 *            the other
	 * @return true, if is collide
	 */
	public boolean isCollide(GameObject other) {
		if (this.getObjectBounds().intersects(other.getObjectBounds())){
			if(this.pixelCollide(other, this.getCollideArea(this.getObjectBounds(), other.getObjectBounds()))){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Pixel collide.
	 *
	 * @author Sudono Tanjung
	 * @param other
	 *            the other
	 * @param collideArea
	 *            the collide area
	 * @return true, if successful
	 */
	private boolean pixelCollide(GameObject other, Rectangle collideArea){
			double x=collideArea.getX()-other.getObjectBounds().getX();
			double y=collideArea.getY()-other.getObjectBounds().getY();
			double thisx=collideArea.getX()-this.getObjectBounds().getX();
			int thisY=(int)(collideArea.getY()-this.getObjectBounds().getY());
			int otherTotalWidth=(int)(collideArea.getWidth()+x);
			int thisTotalWidth=(int)(collideArea.getWidth()+thisx);
			for(double j=y;j<(collideArea.getHeight()+y);j++){
				if(other.getTransparentMapping().get((int)j).get((int)x,otherTotalWidth).intersects(this.getTransparentMapping().get(thisY).get((int)thisx, thisTotalWidth))){
					return true;
				}
				thisY++;
			}
		return false;
	}
	
	/**
	 * Gets the collide area.
	 *
	 * @author Sudono Tanjung
	 * @param a1
	 *            the a1
	 * @param a2
	 *            the a2
	 * @return the collide area
	 */
	private Rectangle getCollideArea(Rectangle a1,Rectangle a2){
		return a1.intersection(a2);
	}
	
	/**
	 * Rotate.
	 *
	 * @author Sudono Tanjung
	 */
	public void rotate(){
		if (this.getObjectCurrentDegree()>=0 && this.getObjectCurrentDegree()<=90)
			if(this.getObjectCurrentDegree()>=270 && this.getObjectCurrentDegree()<=359)
				this.setScaleX(-1.07);
				this.setScaleY(1.07);
		if(this.getObjectTargetDegree()>this.getObjectCurrentDegree())
			this.setObjectCurrentDegree(this.getObjectCurrentDegree()+1);
		else if(this.getObjectTargetDegree()<this.getObjectCurrentDegree())
			this.setObjectCurrentDegree(this.getObjectCurrentDegree()-1);
	}
	
	/**
	 * Gets the object target degree.
	 *
	 * @author Sudono Tanjung
	 * @return the object target degree
	 */
	// List of setter and getter
	public double getObjectTargetDegree() {
		return Math.toRadians(objectTargetDegree);
	}
	
	/**
	 * Sets the object target degree.
	 *
	 * @author Sudono Tanjung
	 * @param objectRotationDegree
	 *            the new object target degree
	 */
	public void setObjectTargetDegree(double objectRotationDegree) {
		this.objectTargetDegree = objectRotationDegree;
	}
	
	/**
	 * Gets the object current degree.
	 *
	 * @author Sudono Tanjung
	 * @return the object current degree
	 */
	public double getObjectCurrentDegree() {
		return objectCurrentDegree;
	}
	
	/**
	 * Sets the object current degree.
	 *
	 * @author Sudono Tanjung
	 * @param objectCurrentDegree
	 *            the new object current degree
	 */
	private void setObjectCurrentDegree(double objectCurrentDegree) {
		if (objectCurrentDegree<=360 && objectCurrentDegree>=0)
		this.objectCurrentDegree = objectCurrentDegree;
	}
	
	/**
	 * Sets the object image.
	 *
	 * @author Sudono Tanjung
	 * @param fileName
	 *            the new object image
	 */
	protected void setObjectImage(String fileName) {
		super.setObjectImage(fileName, this.getObjectBounds());
	}
	
	/**
	 * Gets the object status.
	 *
	 * @author Sudono Tanjung
	 * @return the object status
	 */
	public boolean getObjectStatus() {
		return this.objectStatus;
	}
	
	/**
	 * Sets the object status.
	 *
	 * @author Sudono Tanjung
	 * @param objectStatus
	 *            the new object status
	 */
	private void setObjectStatus(boolean objectStatus) {
		this.objectStatus = objectStatus;
	}
	
	/* (non-Javadoc)
	 * @see pencuriIkan.GameObject#setObjectSize(int, int)
	 */
	protected void setObjectSize(int width, int height){
		this.getObjectBounds().setSize(width, height);
	}
	
	/**
	 * Gets the other pixel point.
	 *
	 * @author Sudono Tanjung
	 * @return the other pixel point
	 */
	public Point getOtherPixelPoint() {
		return otherPixelPoint;
	}
	
	/**
	 * Sets the other pixel point.
	 *
	 * @author Sudono Tanjung
	 * @param otherPixelPoint
	 *            the new other pixel point
	 */
	private void setOtherPixelPoint(Point otherPixelPoint) {
		this.otherPixelPoint = otherPixelPoint;
	}
	
	/**
	 * Checks if is other intersect.
	 *
	 * @author Sudono Tanjung
	 * @return true, if is other intersect
	 */
	private boolean isOtherIntersect() {
		return otherIntersect;
	}
	
	/**
	 * Sets the other intersect.
	 *
	 * @author Sudono Tanjung
	 * @param otherIntersect
	 *            the new other intersect
	 */
	private void setOtherIntersect(boolean otherIntersect) {
		this.otherIntersect = otherIntersect;
	}
}