package back6549;

import java.util.Scanner;

public class Main {
	
	static long arr[];
	static long tree[];
	static int inf = 1000000000;
	
	static long init(int idx,int start,int end) {
		if ( start == end) {
			 return (tree[idx] = start);
		}else {
			long l = init(idx*2,start,(start+end)/2);
			long r = init(idx*2+1,(start+end)/2+1,end);
			if ( arr[(int) l] <= arr[(int) r]) {  // 트리에 인덱스를 저장하므로  l r 비교가 아닌 arr[l] arr[r] 비교
				return tree[idx] = l;
			}else {
				return tree[idx] = r;
			}
		}
	}
	
	static long MIN(int node,int start,int end,int left,int right) {
		
		if ( left > end || right < start) {
			return inf;
		}
		if ( left <= start && end <= right) {
			return tree[node];
		}
		
		long L = MIN(node*2,start,(start+end)/2,left,right);
		long R = MIN(node*2+1,(start+end)/2+1,end,left,right);
		
		if( L == inf ) {
			return R;
		}else if ( R == inf ) {
			return L;
		}else {
			if ( arr[(int) L] <= arr[(int) R]) {
				return L;
			}else {
				return R;
			}
		}

	}
	
	static long large(long start,long end) {
		
		int n = arr.length;
		long m = MIN(1,0,n-1,(int)start,(int)end);
		
		long area = (arr[(int)m])*(end-start+1);
		//System.out.println(start+"~"+end+" "+m+"   "+area);
		if ( start <= m-1) {
			long tmp = large(start,m-1);
			if ( tmp > area) {
				area = tmp;
			}
		}
		if ( m+1 <= end ) {
			long tmp = large(m+1,end);
			if ( tmp > area) {
				area = tmp;
			}
		}
		
		return area;
		
	}
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		while( true ) {
			int N = in.nextInt();
			if ( N == 0) {
				break;
			}
			int H = (int)Math.ceil(Math.log(N)/Math.log(2));
			tree = new long[1<<(H+1)];
			arr = new long[N];
			
			for ( int i = 0 ; i < N ; i++) {
				arr[i] = in.nextInt();
			}
			
			init(1,0,N-1);
			
			System.out.println(large(0,N-1));
			
		}
	}
}
