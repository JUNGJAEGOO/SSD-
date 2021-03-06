package back9251;

/// LCS �˰�����!
import java.io.*;
public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] in1 = br.readLine().toCharArray();
		char[] in2 = br.readLine().toCharArray();
		int n = in1.length;
		int m = in2.length;
		
		
		//System.out.println(in1.length+","+in2.length);
		int dp[][] = new int[1001][1001];

		
		for ( int i = 1 ; i <= n ; i++) {
			for ( int j = 1 ; j <= m ; j++) {
				if ( in1[i-1] == in2[j-1] ) {
					dp[i][j] = dp[i-1][j-1]+1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		/*for ( int i = 0 ; i <= n ; i++) {
			for ( int j = 0 ; j<= m ; j++) {
				System.out.print(dp[i][j]+" ");
			}System.out.println();
		}*/
		
		int x = n;
		int y = m;
		char ans[] = new char[1001];
		int count = 0;
		while ( true ) {
			
			if ( x == 0 || y == 0 ) {
				break;
			}
			
			if ( dp[x-1][y-1] +1 == dp[x][y] && dp[x-1][y-1] == dp[x-1][y] && dp[x-1][y] == dp[x][y-1] ) {
				//System.out.println(in2[y-1]);
				ans[count] = in2[y-1];
				x = x -1;
				y = y -1;
				count++;
			}else if ( dp[x-1][y] == dp[x][y] && dp[x-1][y] > dp[x][y-1]) {
				x = x-1;
			}else {//if ( dp[x][y-1] == dp[x][y] && dp[x][y-1] > dp[x-1][y] ){
				y = y-1;
			}

			
		}
		
		System.out.println(dp[n][m]);
		StringBuilder sb= new StringBuilder();
		for (int i = 0;i<ans.length ;i++) {
			if ( ans[i] != 0) {
				sb.append(ans[i]);
			}
		}

		String tmp = sb.toString();
		char[] res = tmp.toCharArray();
		for (int i = sb.length()-1 ; i >= 0 ; i--)
		{
			System.out.print(res[i]);
		}


	}
}
