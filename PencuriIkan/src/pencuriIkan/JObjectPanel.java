package pencuriIkan;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class JObjectPanel.
 *
 * @author Sudono Tanjung
 */
public abstract class JObjectPanel extends JPanel {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The object rotation. */
	private AffineTransform objectRotation = null;	
	
	/** The object. */
	private GameObject object=null;
	
	/**
	 * Instantiates a new j object panel.
	 *
	 * @author Sudono Tanjung
	 */
	public JObjectPanel() {
		super();
		this.setOpaque(false);
		this.setObjectRotation(new AffineTransform());
	}
	
	/**
	 * Gets the class type.
	 *
	 * @author Sudono Tanjung
	 * @return the class type
	 */
	public String getClassType(){
		if(this.getObject()!=null)
			return this.getObject().getClass().getName();
		else 
			return "";
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (this.getObject() != null) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.drawImage(this.getObject().getObjectImageAsBufferedImage(),0,0,200,200, null);
			g2d.dispose();
		} 
	}
	
	/**
	 * Gets the object rotation.
	 *
	 * @author Sudono Tanjung
	 * @return the object rotation
	 */
	// Setter and Getter
	public AffineTransform getObjectRotation() {
		return objectRotation;
	}

	/**
	 * Sets the object rotation.
	 *
	 * @author Sudono Tanjung
	 * @param objectRotation
	 *            the new object rotation
	 */
	private void setObjectRotation(AffineTransform objectRotation) {
		this.objectRotation = objectRotation;
	}
	
	/**
	 * Sets the object.
	 *
	 * @author Sudono Tanjung
	 * @param object
	 *            the new object
	 */
	protected void setObject(GameObject object) {
		this.object = object;
		this.setBounds(object.getObjectBounds());
	}
	
	/**
	 * Gets the object.
	 *
	 * @author Sudono Tanjung
	 * @return the object
	 */
	public GameObject getObject() {
		return this.object;
	}
}
