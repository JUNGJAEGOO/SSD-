import java.util.*;

public class Main {
	
	static int arr[];
	static long tree[];
	
	public static long init(int idx,int start,int end) {
		if ( start == end) {
			return tree[idx] = arr[start];
		}else {
			return tree[idx] = init(idx*2,start,(start+end)/2) + init(idx*2+1,(start+end)/2+1,end);
		}
	}
	
	public static long sum(int node,int start,int end,int left,int right) {
		if ( left > end || start > right) {
			return 0;
		}
		if ( left <= start &&  end <= right) {
			return tree[node];
		}
		return sum(node*2,start,(start+end)/2,left,right)+sum(node*2+1,(start+end)/2+1,end,left,right);
	}
	
	public static void update(int node,int start,int end,int idx,long diff) {
		if ( start > idx || idx > end) {
			return;
		}
		tree[node] += diff;
		if ( start != end) {
			update(node*2,start,(start+end)/2,idx,diff);
			update(node*2+1,(start+end)/2+1,end,idx,diff);
		}
	}
	
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int M = in.nextInt();
		int K = in.nextInt();
		
		arr = new int[N];
		int H = (int)Math.ceil(Math.log(N)/Math.log(2));
		tree = new long[1<<(H+1)];
		
		for (int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		
		init(1,0,N-1);
		
		for ( int i = 0 ; i < M + K ; i++) {
			int com = in.nextInt();
			int x = in.nextInt();
			int y = in.nextInt();
			if ( com == 1) {
				x--;
				long diff = y - arr[x];
				arr[x] = y;
				//System.out.println(diff);
				update(1,0,N-1,x,diff);
				
			}else {
				System.out.println(sum(1,0,N-1,x-1,y-1));
			}
			
		}
		
	}
	
}


