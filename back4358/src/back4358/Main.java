package back4358;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		TreeMap<String,Integer> tm = new TreeMap<>();
		
		double  sum = 0;
		while ( true ) {
			
			
			String x = in.nextLine();
			if ( x.equals("exit") ) {
				break;
			}
			
			sum++;
			
			if ( tm.get(x) == null ) {
				tm.put(x, 1);
			}else {
				tm.replace(x, tm.get(x)+1);
			}

		}
		
		
		Iterator itr = tm.keySet().iterator();
		
		while ( itr.hasNext() ) {
			
			String key = (String)itr.next();
			
			System.out.print(key+" ");
			System.out.format("%.4f\n",(tm.get(key)/sum)*100);
			
		}
		
		
	}
}
