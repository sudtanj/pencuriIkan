import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import pencuriIkan.StealingShip;

public class MenaraPengawasGui extends JScrollPane {
	private JPanel menaraPengawas=null;
	private MenaraPengawas objekMenara=MenaraPengawas.getInstance();
	public MenaraPengawasGui(){
		super();
		this.setViewportView(this.menaraPengawas);
		this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.menaraPengawas=new JPanel();
		menaraPengawas.setPreferredSize(new Dimension(500,500));
	}
	private void initPanel(){
		
	}
}
