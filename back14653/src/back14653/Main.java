package back14653;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String info[] = in.nextLine().split(" ");
		int N = Integer.parseInt(info[0]);
		int K = Integer.parseInt(info[1]);
		int Q = Integer.parseInt(info[2]);
		
		boolean visit[] = new boolean[N];
		
		for ( int i = 0 ; i < K ; i++) {
			
			String inf[] = in.nextLine().split(" ");
			int left = Integer.parseInt(inf[0]);
			char transmitter = inf[1].charAt(0);
			
			left--;
			visit[transmitter-'A'] = true;
			
			
			
			if ( i+1 == Q) {
				
				
				return;
			}
			
		}
	}
}
