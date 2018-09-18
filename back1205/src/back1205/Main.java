package back1205;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int Song = in.nextInt();
		int P = in.nextInt();
		
		ArrayList<node> list = new ArrayList<>();
		
		for (int i = 0 ; i < N ; i++) {
			list.add(new node(in.nextInt(),false));
		}
		
		list.add(new node(Song,true));

		Collections.sort(list);
		/*for (int i = 0 ; i < list.size() ; i++) {
			System.out.print(list.get(i).num+":"+list.get(i).isSong+" ");
		}*/
		
		int now = 1;
		int diff = 1;
		int before = list.get(0).num;
		for ( int i = 0 ; i < P ; i++) {
			//System.out.println(i+" "+diff+" "+now);
			if ( i > 0 ) {
				if ( list.get(i).num == before ) {
					diff++;
				}else {
					before = list.get(i).num;
					now+=diff;
					diff = 1;
				}
			}
			if ( list.get(i).isSong) {
				System.out.print(now);
				return;
			}
		}
		
		System.out.print(-1);
	}
	
	public static class node implements Comparable<node> {
		//int idx;
		int num;
		boolean isSong;
		
		node ( int num,boolean isSong ){
			//this.idx = idx;
			this.num = num;
			this.isSong = isSong;
		}

		@Override
		public int compareTo(node o) {
			
			if ( this.num > o.num) {
				return -1;
			}else if ( this.num == o.num ){
				if ( isSong ) {
					return 1;
				}
				return -1;
			}else {
				return 1;
			}
			
		}
		
		
	}
}
