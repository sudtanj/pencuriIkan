package pencuriIkan;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImagingOpException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.BitSet;

import javax.imageio.ImageIO;

import scalr.Scalr;

// TODO: Auto-generated Javadoc
/**
 * The Class GameObject.
 *
 * @author Sudono Tanjung
 */
public abstract class GameObject {
	
	/** The object image buffered. */
	private BufferedImage objectImageBuffered=null;
	
	/** The object image mapping. */
	private ArrayList<BitSet> objectImageMapping=new ArrayList<BitSet>();;
	
	/** The object bounds. */
	private Rectangle objectBounds=new Rectangle(0,0,200,200);
	
	/** The scale x. */
	private double scaleX;
	
	/** The scale y. */
	private double scaleY;
	
	/**
	 * Sets the object image.
	 *
	 * @author Sudono Tanjung
	 * @param fileName
	 *            the file name
	 * @param objectBounds
	 *            the object bounds
	 */
	protected void setObjectImage(String fileName,Rectangle objectBounds) {
		try {
			this.objectImageBuffered = scalr.Scalr.resize(ImageIO.read(new File(fileName)), Scalr.Method.SPEED,Scalr.Mode.FIT_EXACT,(int)objectBounds.getWidth(), (int)objectBounds.getHeight(), Scalr.OP_ANTIALIAS);
		} catch (IllegalArgumentException | ImagingOpException | IOException e) {
			e.printStackTrace();
		}
		for (int i=0;i<this.getObjectBounds().getHeight();i++){
			this.getObjectImageMapping().add(new BitSet((int)this.getObjectBounds().getWidth()));
			for (int j=0;j<this.getObjectBounds().getWidth();j++){
					this.getObjectImageMapping().get(i).set(j,this.isTransparentAtPixel(j, i));
			}
		}
	}
	
	/**
	 * Gets the object image as buffered image.
	 *
	 * @author Sudono Tanjung
	 * @return the object image as buffered image
	 */
	public BufferedImage getObjectImageAsBufferedImage() {
		return this.objectImageBuffered;
	}
	
	/**
	 * Gets the object image as image.
	 *
	 * @author Sudono Tanjung
	 * @return the object image as image
	 */
	public Image getObjectImageAsImage(){
		return (Image)this.getObjectImageAsBufferedImage();
	}
	
	/**
	 * Gets the object image as input stream.
	 *
	 * @author Sudono Tanjung
	 * @return the object image as input stream
	 */
	public InputStream getObjectImageAsInputStream(){
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			ImageIO.write(this.getObjectImageAsBufferedImage(), "png", os);
		} catch (IOException e) {
			e.printStackTrace();
		}
		InputStream is = new ByteArrayInputStream(os.toByteArray());
		return is;
	}
	
	/**
	 * Gets the transparent mapping.
	 *
	 * @author Sudono Tanjung
	 * @return the transparent mapping
	 */
	protected ArrayList<BitSet> getTransparentMapping(){
		return this.objectImageMapping;
	}
	
	/**
	 * Checks if is transparent at pixel.
	 *
	 * @author Sudono Tanjung
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @return true, if is transparent at pixel
	 */
	protected boolean isTransparentAtPixel( int x, int y ) {
		  int pixel = this.getObjectImageAsBufferedImage().getRGB(x,y);
		  if( (pixel>>24) == 0x00 ) {
		      return false;
		  }
		return true;
	}
	
	/**
	 * Sets the object size.
	 *
	 * @author Sudono Tanjung
	 * @param width
	 *            the width
	 * @param height
	 *            the height
	 */
	protected void setObjectSize(int width,int height){
		this.getObjectBounds().setSize(width, height);
	}
	
	/**
	 * Sets the object bounds.
	 *
	 * @author Sudono Tanjung
	 * @param objectBounds
	 *            the new object bounds
	 */
	protected void setObjectBounds(Rectangle objectBounds) {
		this.objectBounds = objectBounds;
	}
	
	/**
	 * Gets the object bounds.
	 *
	 * @author Sudono Tanjung
	 * @return the object bounds
	 */
	protected Rectangle getObjectBounds() {
		return this.objectBounds;
	}
	
	/**
	 * Gets the x.
	 *
	 * @author Sudono Tanjung
	 * @return the x
	 */
	public int getX() {
		return (int) this.getObjectBounds().getX();
	}

	/**
	 * Gets the y.
	 *
	 * @author Sudono Tanjung
	 * @return the y
	 */
	public int getY() {
		return (int) this.getObjectBounds().getY();
	}

	/**
	 * Sets the x.
	 *
	 * @author Sudono Tanjung
	 * @param x
	 *            the new x
	 */
	protected void setX(int x) {
		this.getObjectBounds().setLocation(x, (int) this.getObjectBounds().getY());
	}

	/**
	 * Sets the y.
	 *
	 * @author Sudono Tanjung
	 * @param y
	 *            the new y
	 */
	protected void setY(int y) {
		this.getObjectBounds().setLocation((int) this.getObjectBounds().getX(), y);
	}

	/**
	 * Gets the object location.
	 *
	 * @author Sudono Tanjung
	 * @return the object location
	 */
	public Point getObjectLocation(){
		return this.getObjectBounds().getLocation();
	}
	
	/**
	 * Sets the object location.
	 *
	 * @author Sudono Tanjung
	 * @param p
	 *            the new object location
	 */
	public void setObjectLocation(Point p){
		this.getObjectBounds().setLocation(p);
	}
	
	/**
	 * Gets the scale x.
	 *
	 * @author Sudono Tanjung
	 * @return the scale x
	 */
	public double getScaleX() {
		return scaleX;
	}
	
	/**
	 * Gets the scale y.
	 *
	 * @author Sudono Tanjung
	 * @return the scale y
	 */
	public double getScaleY() {
		return scaleY;
	}
	
	/**
	 * Sets the scale x.
	 *
	 * @author Sudono Tanjung
	 * @param scaleX
	 *            the new scale x
	 */
	protected void setScaleX(double scaleX) {
		this.scaleX = scaleX;
	}
	
	/**
	 * Sets the scale y.
	 *
	 * @author Sudono Tanjung
	 * @param scaleY
	 *            the new scale y
	 */
	protected void setScaleY(double scaleY) {
		this.scaleY = scaleY;
	}
	
	/**
	 * Gets the object image mapping.
	 *
	 * @author Sudono Tanjung
	 * @return the object image mapping
	 */
	private ArrayList<BitSet> getObjectImageMapping() {
		return this.objectImageMapping;
	}
}
