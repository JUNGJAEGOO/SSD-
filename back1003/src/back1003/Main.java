package back1003;

import java.io.*;
public class Main {
	static int zero, one ;
	static int dp0[],dp1[];
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		dp0 = new int[41];
		dp1 = new int[41];
		dp0[0] = 1;
		dp1[0] = 0;
		dp0[1] = 0;
		dp1[1] = 1;
		dp0[2] = 1;
		dp1[2] = 1;
		dp0[3] = 1;
		dp1[3] = 2;
		
		for (int i = 4 ; i <= 40 ; i++) {
			dp0[i] = dp0[i-1] + dp0[i-2];
			dp1[i] = dp1[i-1] + dp1[i-2];
		}
		
		while ( T > 0) {
			
			int x  = Integer.parseInt(br.readLine());
			T--;
			System.out.println(dp0[x]+" "+dp1[x]);
		}
	}

}

