package back15728;

import java.util.*;

public class Main {
	
	static int A[];
	static int B[];
	
	public static void main(String	args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		
		A = new int[N];
		B = new int[N];
		
		for ( int i = 0 ; i < N ; i++) {
			A[i] = in.nextInt();
		}
		
		for ( int i = 0 ; i < N ; i++) {
			B[i] = in.nextInt();
		}
		
		ArrayList<node> list = new ArrayList<>();
		
		for ( int i = 0 ; i < N ; i++) {
			for( int j = 0 ; j < N ; j++) {
				list.add(new node(i,j));
			}
		}
		
		Collections.sort(list);
		
		for ( int i = 0 ; i < K ; i++) {
			
			int max = Integer.MIN_VALUE;
			int cnt = list.size()-1;
			int gong = -1;
			
			while ( true) {
				if ( list.get(cnt).ok == true ) {
					max = Math.max(max, list.get(cnt).sum);
					gong = list.get(cnt).Bidx;
					break;
				}else {
					cnt--;
				}
			}
			
			//System.out.println(gong);
			
			for ( int j = 0 ; j < list.size() ; j++ ) {
				if ( list.get(j).Bidx == gong ) {
					list.get(j).ok = false;
				}
			}
			
			
			
		}
/*		
		for ( int i = 0 ; i < list.size() ; i++) {
			System.out.print(list.get(i).sum+" "+list.get(i).ok+" ");
		}System.out.println();*/
		
		for ( int i = list.size()-1 ; i >= 0 ; i--) {
			if ( list.get(i).ok == true) {
				System.out.print(list.get(i).sum);
				return;
			}
		}
		
	}
	
	
	public static class node implements Comparable<node>{
		int Aidx;
		int Bidx;
		int sum;
		boolean ok;
		node( int Aidx,int Bidx) {
			this.Aidx = Aidx;
			this.Bidx = Bidx;
			this.sum = A[Aidx] * B[Bidx];
			this.ok = true;
			
		}
		@Override
		public int compareTo(node o) {
			if ( this.sum > o.sum) {
				return 1;
			}
			return -1;
		}
	}
}
