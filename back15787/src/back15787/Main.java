package back15787;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		
		boolean visit[] = new boolean[1<<20];
		int T[] = new int[N+1];
		
		for ( int i = 0 ; i < M ; i++) {
			int com = in.nextInt();
			if (com==1) {
				int train = in.nextInt();
				int person = in.nextInt()-1;
				
				T[train] = ( T[train] | (1<<person) );
				
			}else if ( com==2) {
				int train = in.nextInt();
				int person = in.nextInt()-1;
				//System.out.println(T[train]+"&"+(1<<person) );
				//System.out.println(T[train]&(1<<person));
				if ( ( T[train]&(1<<person) ) != 0 ) {
					//System.out.println("hi");
					T[train] = ( T[train] ^ (1<<person) );
				}
				
			}else if (com==3) {
				int train = in.nextInt();
				T[train] = T[train]<<1;
				T[train] %= 1<<20;
			}else {
				int train = in.nextInt();
				T[train] = T[train]>>1;
				T[train] %= 1<<20;
			}
		}
	
		//System.out.println(1<<0);
		
		/*for (int i = 1 ; i<= N ; i++) {
			System.out.println(T[i]);
		}*/
		
		int cnt = 0;
		for ( int i = 1 ; i <= N ; i++) {
			if( visit[T[i]] == false) {
				visit[T[i]] = true;
				cnt++;
			}else {
				
			}
		}
		
		System.out.print(cnt);
		
	}
}
