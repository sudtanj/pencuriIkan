package temp;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import de.craften.ui.swingmaterial.MaterialColor;
import de.craften.ui.swingmaterial.MaterialPanel;
import de.craften.ui.swingmaterial.MaterialTextField;

public class MaterialMessage extends MaterialTextField {
	private SuperString data;
	/**
	 * 
	 */
	private static final long serialVersionUID = -8525062546170684200L;
	
	public MaterialMessage(String message){
		super();
		this.setHorizontalAlignment(MaterialTextField.CENTER);
		this.setText(new SuperString(message));
		this.setBackground(MaterialColor.BLUEGREY_300);
		this.setOpaque(false);
	}
	public void setSize(int x,int y){
		super.setSize(x,y);
		this.setLocation((((JFrame)Frame.getFrames()[0]).getContentPane().getWidth()/2)-(this.getWidth()/2),(((JFrame)Frame.getFrames()[0]).getContentPane().getHeight()/2)-(this.getHeight()/2));
	}	    
	    public void setText(SuperString data){
	    	this.data=data;
	    }
	    public void repaint(){
	    	super.repaint();
	    }
	    }
