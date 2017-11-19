package back1081;
import java.util.*;
import java.io.*;
public class Main {
	public static void main (String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input," ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int dp[] = new int[10];
		long sum = 0;

		boolean pass = false;
		while ( start%10 != 0) {
			dp[start%10]++;
			start+=1;
			
			if ( start == end) {
				dp[start%10]++;
				pass = true;
				break;
			}
		}
		if ( pass == false) {
		while ( end%10 != 0) {
			dp[end%10]++;
			end-=1;
	
			if ( end == start) {
				dp[end%10]++;
				break;
			}
		}
		}
		

		
		for ( int i = 1 ; i < 10 ; i++) {
			dp[i]+=(end-start+1) ;
		}
		for ( int i = 1 ; i < 10 ; i++) {
			System.out.print(dp[i]+" ");
		}System.out.println();
		
		for ( int i = 1 ; i < 10 ; i++) {
			sum = sum + dp[i]*i;
		}
		System.out.println(sum);
	}
}
