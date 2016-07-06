package pencuriIkan;

import java.awt.Component;
import java.awt.Rectangle;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class JMovingObject.
 *
 * @author Sudono Tanjung
 */
public class JMovingObject extends JObjectPanel {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The object. */
	private MovingObject object=null;
	
	/** The other moving object. */
	private ArrayList<Component> otherMovingObject=null;
	
	/**
	 * Instantiates a new j moving object.
	 *
	 * @author Sudono Tanjung
	 * @param object
	 *            the object
	 */
	public JMovingObject(MovingObject object) {
		super();
		this.setObject(object);
		super.setObject(object);
		this.setOtherMovingObject(new ArrayList<Component>());
		// TODO Auto-generated constructor stub
	}
	
	/* (non-Javadoc)
	 * @see pencuriIkan.JObjectPanel#getObject()
	 */
	//setter and getter
	public MovingObject getObject() {
		return object;
	}
	
	/**
	 * Checks if is collide.
	 *
	 * @author Sudono Tanjung
	 * @return true, if is collide
	 */
	public boolean isCollide(){
		if(this.getOtherMovingObject()!=null && this.getParent().getComponents()!=null){
			for (Component values: this.getParent().getComponents()){
				if(!values.equals(this))
				this.getOtherMovingObject().add(values);
			}
		}
		for (Component values:this.getOtherMovingObject()){
			if(this.getObject().isCollide(((JObjectPanel)values).getObject())){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Move.
	 *
	 * @author Sudono Tanjung
	 * @param direction
	 *            the direction
	 */
	public void move(int direction){
		this.getObject().move(direction);
		if(this.isCollide())
			this.getObject().setObjectBounds(this.getBounds());
		else
			this.setBounds(this.getObject().getObjectBounds());
		this.repaint();
	}
	
	/**
	 * Run as ai enemy.
	 *
	 * @author Sudono Tanjung
	 * @param escapePoint
	 *            the escape point
	 */
	public void runAsAIEnemy(Rectangle escapePoint){
		this.getObject().runAIAsEnemy(escapePoint);
		this.repaint();
	}
	
	/**
	 * Gets the other moving object.
	 *
	 * @author Sudono Tanjung
	 * @return the other moving object
	 */
	private ArrayList<Component> getOtherMovingObject() {
		return otherMovingObject;
	}
	
	/**
	 * Sets the object.
	 *
	 * @author Sudono Tanjung
	 * @param object
	 *            the new object
	 */
	private void setObject(MovingObject object) {
		this.object = object;
	}
	
	/**
	 * Sets the other moving object.
	 *
	 * @author Sudono Tanjung
	 * @param otherMovingObject
	 *            the new other moving object
	 */
	private void setOtherMovingObject(ArrayList<Component> otherMovingObject) {
		this.otherMovingObject = otherMovingObject;
	}

}
