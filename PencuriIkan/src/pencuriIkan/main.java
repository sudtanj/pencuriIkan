package pencuriIkan;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import de.craften.ui.swingmaterial.MaterialButton;
import de.craften.ui.swingmaterial.MaterialColor;
import de.craften.ui.swingmaterial.MaterialPanel;
import de.craften.ui.swingmaterial.MaterialProgressSpinner;
import de.craften.ui.swingmaterial.MaterialTextField;
import javafx.scene.layout.FlowPane;
import temp.Settings;

public class main {
	
	public static void main(String[] args){
		JFrame gui=new JFrame();
		gui.setLayout(null);
		gui.setVisible(true);
		Settings.setGui(gui);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(300, 300);
		gui.setTitle("Pencuri Ikan");
		JStaticObject item=new JStaticObject(new Island(400,400));
		JMovingObject playerPanel=new JMovingObject(new StealingShip(0,0));
		playerPanel.runAsAIEnemy(item.getBounds());
		gui.getContentPane().add(playerPanel);
		gui.getContentPane().add(item);
		gui.addKeyListener(new KeyListener(){
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if (arg0.getKeyCode()==arg0.VK_A){
					playerPanel.move(playerPanel.getObject().MOVING_LEFT);
				}
				else if (arg0.getKeyCode()==arg0.VK_D){
					playerPanel.move(playerPanel.getObject().MOVING_RIGHT);
				}
				else if (arg0.getKeyCode()==arg0.VK_S){
					playerPanel.move(playerPanel.getObject().MOVING_DOWN);
				}
				else if (arg0.getKeyCode()==arg0.VK_W){
					playerPanel.move(playerPanel.getObject().MOVING_UP);
				}
				arg0.consume();
				playerPanel.repaint();
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				arg0.consume();
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				arg0.consume();
			}
		
		});
		gui.getContentPane().repaint();
	}
}
