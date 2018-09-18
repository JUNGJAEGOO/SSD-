
import java.util.*;
import java.io.*;

public class source4 {
	
	static int t,N,K;
	static int dp[][][];
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(br.readLine());
		int x = 1;
		
		while ( T > 0 ) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			t = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			
			dp = new int[101][101][3];
			for ( int i = 0 ; i < 101 ; i++) {
				for ( int j = 0 ; j < 101 ; j++) {
					for ( int k = 0 ; k < 3 ; k++) {
						dp[i][j][k] = -1;
					}
					
				}
			}
			
			System.out.println(x+" "+(func(1,0,0)+func(1,0,1)) );
			x++;
			
			T--;
		}
	}
	
	public static int func(int pos,int sum,int before) {
		
		//System.out.println(pos+" "+k+" "+before);
		if ( pos == N && sum == K) {
			return 1;
		}
			
		if ( pos == N) {
			return 0;
		}
		
		
		
		int ret = dp[pos][sum][before];
		if ( ret != - 1) {
			return ret;
		}
		ret = 0;
		
		
		if ( before == 0) {
			
			ret += ( func(pos+1,sum,1));
			
			ret += func(pos+1,sum,0);
		}else {
			
			ret += ( func(pos+1,sum,0));
			
			ret += func(pos+1,sum+1,1);
		}
		
		
		return dp[pos][sum][before] = ret;
		
	}
}
