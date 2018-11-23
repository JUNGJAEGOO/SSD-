package back16283;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		int res = -1;
		for ( int i = 1 ; i < n ; i++) {
			
			int lamb = n - i;
			
			if ( i*a + lamb*b == w) {
				res = i;
				cnt++;
			}
			
			if ( cnt > 1) {
				System.out.print(-1);
				return;
			}
		}
		
		if ( res == - 1) {
			System.out.print(-1);
			return;
		}
		System.out.print(res+" "+(n-res));
	}
}
