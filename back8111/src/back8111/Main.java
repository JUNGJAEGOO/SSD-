package back8111;

import java.util.*;
import java.math.*;

public class Main {
	
	static HashMap<String,Boolean> hm;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		while ( T > 0 ) {
			
			int X = in.nextInt();
		/*	if ( X % 9 ==0) {
				
				int sum = 0;
				while ( true ) {
					
					if ( X%9 != 0) {
						break;
					}
					X = X / 9;
					sum ++;
				}
				
				String str = "";
				for (int i = 0 ; i < sum ; i++) {
					str += "11111111";
				}
				BFS(X,str);
				
				T--;
				continue;
			}*/
			
			
			hm = new HashMap<>();
			
			BFS(X,"1");
			
			
			T--;
		}
	}
	

	public static void BFS(int origin,String go) {
		Queue<String> q = new LinkedList<>();
		q.add(go);
		
		while ( !q.isEmpty() ) {
			
			String now = q.poll();
			BigInteger tmp = new BigInteger(now);
			//System.out.println(now);
			if ( tmp.mod(BigInteger.valueOf(origin)) == BigInteger.ZERO ) {
				System.out.println(now);
				return;
			}
			hm.put(now, true);
			
			if( hm.get(now+"1") == null) {
				q.add(now+"1");
			}

			if( hm.get(now+"0") == null) {
				q.add(now+"0");
			}
			
		}
		
		System.out.println("BRAK");
	}
}
