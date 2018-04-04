package back1229;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		int diff = 5;
		while ( true ) {
			
			if ( list.get(list.size()-1) + diff > 1000000 )
			{
				break;
			}
			list.add(list.get(list.size()-1) + diff);
			diff += 4;
		}
		
		//System.out.println(list);
		int dp[] = new int[1000001];
		Arrays.fill(dp, 10000000);
		for ( int i = 0 ; i < list.size() ;  i++) {
			dp[list.get(i)] = 1;
			//System.out.print(list.get(i));
		}
		/*for ( int i = 1 ; i<= 20 ; i++) {
			System.out.print(dp[i]+" ");
		}System.out.println();
		*/
		for ( int i = 1 ; i <= 1000000 ; i++) {
			for ( int j = 0 ; j < list.size() ; j++) {
				if ( list.get(j) > i ) {
					break;
				}
				dp[i] = Math.min(dp[i], dp[i-1]+1);
				if ( i - dp[j] >= 0) {
					dp[i] = Math.min(dp[i],dp[i-list.get(j)]+1 );
				}
			}
		}
		
		/*for ( int i = 1 ; i<= 20 ; i++) {
			System.out.print(dp[i]+" ");
		}System.out.println();
		*/
		System.out.println(dp[N]);
	}
}
