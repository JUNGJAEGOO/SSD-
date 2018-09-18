
import java.util.*;
import java.io.*;

public class source3 {
	static int N;
	static int dp[];
	static int arr[];
	public static void main(String args[]) throws NumberFormatException, IOException {
		//Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[3001];
		for ( int i = 0 ; i < 3001 ; i++) {
			
				dp[i] = -1;
			
		}
		
		System.out.print(func(N));
		
	}
	
	public static int func(int len) {
		
		if ( len == 0) {
			return 0;
		}
		
		int ret = dp[len];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		for ( int i = 0 ; i < N ; i++) {
			if ( len -(i+1) >= 0 ) {
				ret = Math.max(ret, arr[i] + func(len-(i+1)) );
			}
			
		}
		
		
		return dp[len] = ret;
		
	}
}
