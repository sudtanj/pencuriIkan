package temp;

import java.util.ArrayList;

import javax.swing.JFrame;

public class Settings {
	public static String clientId="AIzaSyBxrYAiBJDFundW_hQhuB5YeOP3mj_K_-E";
	public static String language="Indonesian";
	private static JFrame gui=null;
	private static ArrayList<SuperString> string=new ArrayList<SuperString>();
	
	public static void setGui(JFrame gui){
		Settings.gui=gui;
	}
	public static String getCurrentLang(){
		return language;
	}
	public static JFrame getGui(){
		return gui;
	}
	public static void setLanguage(String lang){
		Settings.language=lang;
	}
	public static void addString(SuperString data){
		string.add(data);
	}
	public static Object[] getString(){
		return string.toArray();
	}
}
