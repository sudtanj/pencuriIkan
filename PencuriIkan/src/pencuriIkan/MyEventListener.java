package pencuriIkan;

import java.util.EventListener;
import java.util.EventObject;

public interface MyEventListener extends EventListener {
	public void myEventOccurred(EventObject evt);
}
