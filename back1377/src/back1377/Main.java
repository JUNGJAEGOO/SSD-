package back1377;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		ArrayList<node> list = new ArrayList<>();
		for ( int i = 0 ; i < N ; i++) {
			int num = in.nextInt();
			int idx = i;
			list.add(new node(num,idx));
		}
		Collections.sort(list);
		
		int arr[] = new int[N];
		
		for ( int i = 0 ; i < N ; i++) {
			int idx = list.get(i).idx;
			arr[i] = idx-i;
		}
		
		int max = 0;
		for ( int i = 0 ; i < N ; i++) {
			//System.out.print(arr[i]+" ");
			if ( arr[i] > max) {
				max = arr[i];
			}
		}
		
		System.out.println(max+1);
		
	}
	
	public static class node implements Comparable<node>{
		int num;
		int idx;
		node ( int num,int idx){
			this.num = num;
			this.idx  = idx;
		}
		@Override
		public int compareTo(node o) {
			if ( this.num > o.num ) {
				return 1;
			}
			return -1;
		}
	}
}
