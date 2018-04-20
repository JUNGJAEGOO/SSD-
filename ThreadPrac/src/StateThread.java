
import java.util.*;

public class StateThread extends Thread {

	
	public StateThread() {
		
		
	}
	
	public void run() {
		try {
			StateThread th = new StateThread();
			th.printCurrentTime();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void printCurrentTime() {
		for ( int i = 0 ; i < 10 ; i++) {
			Date now = new Date();
			System.out.print(now.toString()+" ");
			double a = System.currentTimeMillis();
			System.out.println(a);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
