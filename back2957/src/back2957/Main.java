package back2957;

import java.io.*;
import java.util.*;

public class Main {
	
	static int C = 0;
	static HashMap<Integer,Integer> hm = new HashMap<>();
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int x = Integer.parseInt(br.readLine());
		hm.put(x, 0);
		sb.append(0+"\n");
		
		for ( int i = 0 ; i < N-1 ; i++) {
			
			int X = Integer.parseInt(br.readLine());
			Iterator itr = hm.keySet().iterator();
			
			if ( hm.get((int)itr.next()) < X) {
				
			}else {
				
			}
			
			C += hm.get(X);
			sb.append(C+"\n");
			
		}
		
		
		System.out.print(sb);
	}
	

	

}
