package temp;

import java.awt.Component;
import javax.swing.JPanel;

public class ObjectWall {
	public static boolean wallChecking(JPanel player){
		Component[] komponen=player.getParent().getComponents();
		for (Component temp:komponen){
			int guiWidthEndX=temp.getX()+temp.getWidth();
			int guiHeightEndY=temp.getY()+temp.getHeight();
			int playerWidthEndX=player.getX()+player.getWidth();
			int playerHeightEndY=player.getY()+player.getHeight();
			if (playerWidthEndX==temp.getX()){
				if((playerWidthEndX>=temp.getX() && playerWidthEndX<=temp.getX()) && (player.getY()>=temp.getY() && player.getY()<=guiHeightEndY)){
					komponen=null;
					temp=null;
					player=null;
					return true;
				}
				else if((playerWidthEndX>=temp.getX() && player.getY()<=temp.getX())&& (playerHeightEndY>=temp.getY() && playerHeightEndY<=guiHeightEndY)){
					komponen=null;
					temp=null;
					player=null;
					return true;
				}
			}
			else if (playerHeightEndY==temp.getY()){
				if((playerHeightEndY>=temp.getY() && playerHeightEndY<=temp.getY())&&(player.getX()>=temp.getX() && player.getX()<=guiWidthEndX))
				{
					komponen=null;
					temp=null;
					player=null;
					System.gc();
					return true;
				}
				else if((playerHeightEndY>=temp.getY() && playerHeightEndY<=temp.getY())&&(playerWidthEndX>=temp.getX() && playerWidthEndX<=guiWidthEndX))
				{
					komponen=null;
					temp=null;
					player=null;
					System.gc();
					return true;
				}
			}
			else if (player.getX()==guiWidthEndX){
				if((player.getX()>=guiWidthEndX && player.getX()<=guiWidthEndX) && (player.getY()>=temp.getY() && player.getY()<=guiHeightEndY))
				{
					komponen=null;
					temp=null;
					player=null;
					System.gc();
					return true;
				}
				else if((playerWidthEndX>=temp.getX() && player.getY()<=temp.getX())&& (playerHeightEndY>=temp.getY() && playerHeightEndY<=guiHeightEndY))
				{
					komponen=null;
					temp=null;
					player=null;
					System.gc();
					return true;
				}
			}
			else if(player.getY()==guiHeightEndY){
				if ((player.getX()>=temp.getX() && player.getX()<=guiWidthEndX) && (player.getY()>=guiHeightEndY && player.getY()<=guiWidthEndX))
				{
					komponen=null;
					temp=null;
					player=null;
					System.gc();
					return true;
				}
				else if ((playerWidthEndX>=temp.getX() && playerWidthEndX<=guiWidthEndX)&&(player.getY()>=guiHeightEndY && player.getY()<=guiWidthEndX))
				{
					komponen=null;
					temp=null;
					player=null;
					System.gc();
					return true;
				}
			}
			temp=null;
			System.gc();
		}
		komponen=null;
		player=null;
		System.gc();
		return false;
	}
}
