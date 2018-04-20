
public class RunThread {
	public static void main(String args[]) {
		RunThread sample = new RunThread();
		sample.timerthread();
		
	}
	
	public void timerthread() {
		StateThread thread = new StateThread();
		thread.start();
		try{
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
