package pencuriIkan;

import java.awt.*;
import java.util.*;

public class Helicopter extends MovingObject implements FlyableObject
{
	public Helicopter(Point objectPoint)
		{
			super(objectPoint,"heli.png");
			//super itu untuk fungsi parentnya
			this.setObjectSize(200,200);
			this.setObjectLocation(objectPoint);
		}
	public Helicopter(int x, int y)
		{
			this(new Point(x,y));
		}
}
