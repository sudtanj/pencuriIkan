package pencuriIkan;

// TODO: Auto-generated Javadoc
/**
 * The Class JStaticObject.
 *
 * @author Sudono Tanjung
 */
public class JStaticObject extends JObjectPanel {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The object. */
	private StaticObject object=null;
	
	/**
	 * Instantiates a new j static object.
	 *
	 * @author Sudono Tanjung
	 * @param Object
	 *            the object
	 */
	public JStaticObject(StaticObject Object){
		super();
		this.setObject(Object);
		this.setObject((GameObject)object);
		
	}
	
	/* (non-Javadoc)
	 * @see pencuriIkan.JObjectPanel#getObject()
	 */
	//setter and getter
	public StaticObject getObject() {
		return object;
	}

	/**
	 * Sets the object.
	 *
	 * @author Sudono Tanjung
	 * @param object
	 *            the new object
	 */
	private void setObject(StaticObject object) {
		this.object = object;
	}
}
