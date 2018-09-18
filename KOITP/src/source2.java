import java.util.*;
import java.io.*;

public class source2 {
	static long dp[];
	static int arr[];
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		
		//Scanner in = new Scanner(System.in);
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str," ");
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new long[N];
		dp[0] = arr[0];
		
		long max = dp[0];
		for ( int i = 1 ; i < N ; i++) {
			
			if ( arr[i] > dp[i-1] + arr[i] ) {
				dp[i] = arr[i];
			}else if ( arr[i] + dp[i-1] > arr[i]) {
				dp[i] = arr[i] + dp[i-1];
			}
			
			if ( dp[i] > max ) {
				max = dp[i];
			}
		}
		
		System.out.print(max);
		
	}
}
