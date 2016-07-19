package pencuriIkan;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import pencuriIkan.StealingShip;

public class MenaraPengawasGui extends JScrollPane {
	private static JPanel menaraPengawas=new JPanel();
	private MenaraPengawas objekMenara=MenaraPengawas.getInstance();
	public MenaraPengawasGui(){
		super();
		this.menaraPengawas.setPreferredSize(new Dimension(500,500));
		this.setVisible(true);
		this.setViewportView(this.menaraPengawas);
		this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.menaraPengawas.setVisible(true);
		this.menaraPengawas.setBounds(0,0,300,100);
		this.setPreferredSize(new Dimension(200,200));
		this.setOpaque(false);
		this.menaraPengawas.setBackground(Color.WHITE);
		initPanel();
	}
	private void initPanel(){
		for(MovingObject temp:objekMenara.getObject()){
			JPanel temporary=new JPanel();
			JLabel text=new JLabel(temp.getObjectBounds().toString());
			temporary.setBounds(0, 0, 200, 200);
			temporary.setVisible(true);
			temporary.setLayout(null);
			text.setBounds(0,0,500,100);
			this.menaraPengawas.add(text);
		}
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.menaraPengawas.removeAll();
		initPanel();
	}
}
