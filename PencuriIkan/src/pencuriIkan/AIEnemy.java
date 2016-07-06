package pencuriIkan;

import java.awt.Point;
import java.awt.Rectangle;

// TODO: Auto-generated Javadoc
/**
 * The Class AIEnemy.
 *
 * @author Sudono Tanjung
 */
public class AIEnemy extends AIBot {
	
	/** The escape point. */
	private Rectangle escapePoint=null;
	
	/** The enemy. */
	private MovingObject enemy=null;
	
	/** The object enemy. */
	private Rectangle objectEnemy=null;
	
	/**
	 * Instantiates a new AI enemy.
	 *
	 * @author Sudono Tanjung
	 * @param escapePoint
	 *            the escape point
	 * @param enemyObject
	 *            the enemy object
	 * @param selfObject
	 *            the self object
	 */
	public AIEnemy(Rectangle escapePoint, Rectangle enemyObject,MovingObject selfObject){
		this.setEscapePoint(escapePoint);
		this.setObjectEnemy(enemyObject);
		this.setEnemyObject(selfObject);
		this.aiStart();
	}
	
	/**
	 * Sets the enemy object.
	 *
	 * @author Sudono Tanjung
	 * @param enemy
	 *            the new enemy object
	 */
	public void setEnemyObject(MovingObject enemy){
		this.enemy=enemy;
	}
	
	/**
	 * Ai start.
	 *
	 * @author Sudono Tanjung
	 */
	public void aiStart(){
		new Thread(){
			public void run(){
				while (!enemy.getObjectBounds().intersects(new Rectangle((int)getEscapePoint().getX()-1,(int)escapePoint.getY()-1,(int)escapePoint.getWidth()+1,(int)escapePoint.getHeight()+1))){
					moveEnemy();
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
	
	/**
	 * Move enemy.
	 *
	 * @author Sudono Tanjung
	 */
	public void moveEnemy(){
		Double lastDistance=new Double(enemy.getObjectLocation().distance(escapePoint.getLocation()));
		Point lastPoint=enemy.getObjectLocation();
		enemy.move(getDirection());
		if (lastDistance<=enemy.getObjectLocation().distance(escapePoint.getLocation()))
			enemy.setObjectLocation(lastPoint);
		lastDistance=null;
	}
	
	/**
	 * Gets the object enemy.
	 *
	 * @author Sudono Tanjung
	 * @return the object enemy
	 */
	// Setter and Getter
	public Rectangle getObjectEnemy() {
		return objectEnemy;
	}
	
	/**
	 * Sets the object enemy.
	 *
	 * @author Sudono Tanjung
	 * @param objectEnemy
	 *            the new object enemy
	 */
	private void setObjectEnemy(Rectangle objectEnemy) {
		this.objectEnemy = objectEnemy;
	}
	
	/**
	 * Gets the escape point.
	 *
	 * @author Sudono Tanjung
	 * @return the escape point
	 */
	private Rectangle getEscapePoint() {
		return escapePoint;
	}
	
	/**
	 * Sets the escape point.
	 *
	 * @author Sudono Tanjung
	 * @param escapePoint
	 *            the new escape point
	 */
	private void setEscapePoint(Rectangle escapePoint) {
		this.escapePoint = escapePoint;
	}
}
