package pencuriIkan;

import java.awt.Point;

public class Satelit extends MovingObject implements FlyableObject
{
	public Satelit(Point objectPoint)
		{
			super(objectPoint,"satellite.png");
			this.setObjectSize(200,200);
			this.setObjectLocation(objectPoint);
		}
	public Satelit(int x, int y)
		{
			this(new Point(x,y));
		}
}
