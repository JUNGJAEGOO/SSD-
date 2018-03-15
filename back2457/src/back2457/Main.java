package back2457;

import java.util.*;

public class Main {
	static int N;
	static node arr[] = new node[100001];
	static ArrayList<node> list = new ArrayList<>();

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();

		for ( int i = 0 ; i < N ; i++) {
			int startM = in.nextInt();
			int startD = in.nextInt();
			int endM = in.nextInt();
			int endD = in.nextInt();
			
			//list.add(new node(startM*100+startD,endM*100+endD));
			arr[i] = new node(startM*100+startD,endM*100+endD);
		}
		
		Arrays.sort(arr,0,N);
		//Collections.sort(list);
		
	/*	for ( int i = 0 ; i < N ; i++) {
			System.out.println(list.get(i).start+" "+list.get(i).end);
		}
		*/
		
		int end = 301;
		int num = 0;
		int idx = -1;
		int max = 0;
		boolean flag;
		
		while ( end <= 1130 && idx < N ) {
			
			idx++;
			
			flag = false;
			for ( int i = idx ; i < N ; i++) {
				
				if ( arr[i].start > end) {
					break;
				}
					
				if ( arr[i].end > max) {
					max = arr[i].end;
					flag = true;
					idx = i;
				}

			}
			
			//System.out.println(max);
			if ( flag ) {
				end = max;
				num++;
				
			}
			else {
				System.out.println(0);
				return;
			}
			
		}
		
		
		System.out.println(num);
		

	}
	
	
	public static class node implements Comparable<node>{
		int start;
		int end;
		
		node (int start,int end){
			this.start = start;
			this.end = end;
			
		}

		@Override
		public int compareTo(node o) {
			if ( this.start > o.start) {
				return 1;
			}else if ( this.start == o.start) {
				if ( this.end > o.end) {
					return 1;
				}else {
					return -1;
				}
			}
			return -1;
		}
	}
}
