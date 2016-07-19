package pencuriIkan;

import java.awt.Point;


public class Drone extends MovingObject implements FlyableObject
{
	public Drone(Point objectPoint)
		{
			super(objectPoint,"drone2.png");
			this.setObjectSize(200,200);
			this.setObjectLocation(objectPoint);
		}
	public Drone(int x, int y)
		{
			this(new Point(x,y));
		}
}

