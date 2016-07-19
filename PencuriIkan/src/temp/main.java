package temp;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
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
import pencuriIkan.Island;
import pencuriIkan.JMovingObject;
import pencuriIkan.JStaticObject;
import pencuriIkan.MenaraPengawasGui;
import pencuriIkan.StealingShip;

public class main {
	
	public static void main(String[] args){
		JFrame gui=new JFrame();
		gui.setLayout(null);
		gui.setVisible(true);
		Settings.setGui(gui);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(300, 300);
		gui.setTitle("Pencuri Ikan");
		JStaticObject item=new JStaticObject(new Island(800,100));
		JMovingObject playerPanel=new JMovingObject(new StealingShip(0,0));
		playerPanel.runAsAIEnemy(item);
		JMovingObject playerPanel1=new JMovingObject(new StealingShip(800,800));
		gui.getContentPane().add(playerPanel1);
		playerPanel.addComponentListener(new ComponentListener(){

			@Override
			public void componentResized(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				gui.repaint();
			}

			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		gui.getContentPane().add(playerPanel);
		gui.getContentPane().add(item);
		MenaraPengawasGui mPG=new MenaraPengawasGui();
		mPG.setBounds(0,gui.getHeight()-mPG.getHeight(),gui.getWidth(),150);
		mPG.setBackground(Color.BLUE);
		gui.getContentPane().add(mPG);
		gui.addComponentListener(new ComponentListener(){

			@Override
			public void componentResized(ComponentEvent e) {
				// TODO Auto-generated method stub
				mPG.setBounds(0,gui.getHeight()-(mPG.getHeight()+40),gui.getWidth()-10,150);
				mPG.repaint();
			}

			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		gui.addKeyListener(new KeyListener(){
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode()==arg0.VK_A){
					playerPanel1.move(playerPanel1.getObject().MOVING_LEFT);
				}
				else if (arg0.getKeyCode()==arg0.VK_D){
					playerPanel1.move(playerPanel1.getObject().MOVING_RIGHT);
				}
				else if (arg0.getKeyCode()==arg0.VK_S){
					playerPanel1.move(playerPanel1.getObject().MOVING_DOWN);
				}
				else if (arg0.getKeyCode()==arg0.VK_W){
					playerPanel1.move(playerPanel1.getObject().MOVING_UP);
				}
				
				playerPanel1.repaint();
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		
		});
		
	}
}
