package back12033;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int CASE  = 1;
		while ( T > 0) {
			
			int N = in.nextInt();
			ArrayList<Integer> list = new ArrayList<>();
			for ( int i = 0 ; i < 2*N ; i++) {
				list.add(in.nextInt());
			}
			
			ArrayList<Integer> ans = new ArrayList<>();
			boolean visit[] = new boolean[2*N];
			
			for ( int i = 0 ; i < list.size() ; i++) {
				
				int now = (int) ( (double)list.get(i) * ( (double)3 / (double)4))  ;
				
				for (int j = 0 ; j < 2*N ; j++ ) {
					if ( list.get(j) == now && visit[j] == false) {
						visit[j] = true;
						visit[i] = true;
						ans.add(now);
						break;
					}
				}
				
				
			}
			
			Collections.sort(ans);
			System.out.print("Case #"+CASE+": ");
			for ( int i = 0 ; i < ans.size() ; i++) {
				System.out.print(ans.get(i)+" ");
			}System.out.println();
			
			
			CASE++;
			T--;
		}
	}
}
