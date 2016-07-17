package pencuriIkan;

import java.util.ArrayList;
import pencuriIkan.MovingObject;

public class MenaraPengawas {
	private static MenaraPengawas instance=null;
	private ArrayList<MovingObject> dataObjek=null;
	
	private MenaraPengawas(){
		this.setDataObjek(new ArrayList<MovingObject>());
	}

	public static MenaraPengawas getInstance(){
		if (instance==null)
			instance = new MenaraPengawas();
		return instance;
	}
	public void add(MovingObject e){
		this.getDataObjek().add(e);
	}
	public ArrayList<MovingObject> getObject(){
		ArrayList<MovingObject> temp=new ArrayList<MovingObject>(this.getDataObjek());
		return temp;
	}
	//setter and getter
	public ArrayList<MovingObject> getDataObjek() {
		return dataObjek;
	}

	public void setDataObjek(ArrayList<MovingObject> dataObjek) {
		this.dataObjek = dataObjek;
	}
}
