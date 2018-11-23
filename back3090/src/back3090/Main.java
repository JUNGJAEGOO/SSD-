package back3090;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int tmp[];
	static int arr[];
	static int N,T;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		
		tmp = new int[N];
		arr = new int[N];
		
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right=  (int)1e9 + 1;
		
		while ( left <= right ) {
			
			int mid = (left+right) >> 1;
		
			if ( isPossible(mid) ) {
				right = mid -1;
			}else {
				left = mid + 1;
			}
			
		}
		
		isPossible(left);
		
		for ( int i = 0 ; i < N ; i++) {
			System.out.print(tmp[i]+" ");
		}
		
	}
	
	public static boolean isPossible(int diff) {
		
		long ret = 0;
		
		for ( int i = 0 ; i < N ; i++) {
			tmp[i] = arr[i];
		}
		
		for ( int i = 0 ; i < N-1 ; i++) {
			if ( tmp[i] + diff < tmp[i+1]) {
				ret += tmp[i+1] - tmp[i] - diff;
				tmp[i+1] = tmp[i] + diff;
			}
		}
		
		for ( int i = N-1 ; i > 0 ; i--) {
			if ( tmp[i-1] > tmp[i] + diff) {
				ret += tmp[i-1] - tmp[i] - diff;
				tmp[i-1] = tmp[i] + diff;
			}
		}
		
		
		return ret <= T ? true : false;
	}
}
