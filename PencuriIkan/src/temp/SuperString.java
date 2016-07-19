package temp;

import java.net.URL;
import java.net.URLConnection;

// TODO: Auto-generated Javadoc
/**
 * The Class SuperString.
 *
 * @author Sudono Tanjung
 */
public class SuperString {
	
	/** The string. */
	private String string=null;
	
	/**
	 * Instantiates a new super string.
	 *
	 * @author Sudono Tanjung
	 * @param input
	 *            the input
	 */
	public SuperString(String input) {
		this.string=new String(input);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		if(netIsAvailable()){
			String translate=new Translator(Settings.clientId).translate(string, Settings.language);
			return translate;
		}
		else 
			return this.string;
	}
	
	/**
	 * Net is available.
	 *
	 * @author Sudono Tanjung
	 * @return true, if successful
	 */
	private boolean netIsAvailable() {                                                                                                                                                                                                 
	    try {                                                                                                                                                                                                                                                                                                                                                                                                                
	        new URL("http://www.google.com").openConnection().connect();                                                                                                                                                                                                                   
	        return true;                                                                                                                                                                                                                      
	    } catch (Exception e) {                                                                                                                                                                                                   
	        return false;                                                                                                                                                                                                    
	    }                                                                                                                                                                                                                             
	} 
}
