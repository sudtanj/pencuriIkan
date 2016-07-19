package pencuriIkan;

import java.awt.Point;

public class Pesawat extends MovingObject implements FlyableObject
{
	public Pesawat(Point objectPoint)
		{
			super(objectPoint,"airplane.png");
			this.setObjectSize(200,200);
			this.setObjectLocation(objectPoint);
		}
	public Pesawat(int x, int y)
		{
			this(new Point(x,y));
		}
}
