package back2042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int tree[];
	static Long arr[];
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		tree = new int[N+1];
		arr = new Long[N+1];
		arr[1] = Long.parseLong(br.readLine());
		update(1,0);
		for ( int i = 2 ; i <= N ; i++ ) {
			arr[i] = Long.parseLong(br.readLine());
			update(arr[i],arr[i]);
		}
		
		for ( int i = 1 ; i <= N ; i++) {
			System.out.print(tree[i]+" ");
		}System.out.println();
		
		for ( int i = 0 ; i < M+K ; i++) {
			st= new StringTokenizer(br.readLine()," ");
			int command = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			if ( command == 1) {
				long diff = y - arr[x];
				arr[x] = y;
				update(x,diff);
			}else if ( command == 2) {
				//System.out.println(sum((int)y)-sum(x-1));
				System.out.println(sum((int)y)-sum(x-1)+" "+sum(x));
			}
		}
	}
	
	public static void update(int idx,long num) {
		while ( idx < tree.length ) {
			tree[idx] += num;
			idx += ( idx & -idx);
		}
	}
	
	public static long sum(int i) {
		long ans = 0;
		while ( i > 0 ) {
			ans += tree[i];
			i -= ( i & -i);
			//System.out.println(i);
		}
		return ans;
	}
	
}
