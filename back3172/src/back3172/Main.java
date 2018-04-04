package back3172;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		ArrayList<String> list = new ArrayList<>();
		ArrayList<node> revlist = new ArrayList<>();
		for ( int i = 0 ; i < N ; i++) {
			String input = in.nextLine();
			list.add(input);
		}
		
		Collections.sort(list);
		System.out.println(list);
		
		
		for  (int i = 0 ; i < N ; i++) {
			char tmp[] = list.get(i).toCharArray();
			String rev = "";
			StringBuilder sb = new StringBuilder();
			for ( int j = tmp.length-1 ; j >= 0 ; j--) {
				sb.append(tmp[j]);
			}
			rev = sb.toString();
			//System.out.println(rev+" "+i);
			revlist.add(new node(rev,i));
		}
		Collections.sort(revlist);
		int ans = 0;
		for ( int i = 0 ; i < revlist.size() ; i++) {
			System.out.println(revlist.get(i).now+" "+revlist.get(i).idx);
			if ( i-revlist.get(i).idx > 0 ) {
				ans += i-revlist.get(i).idx;
			}
		}
		System.out.println(ans);
	}
	
	public static class node implements Comparable<node>{
		int idx;
		String now;
		node (String now,int idx){
			this.now = now;
			this.idx = idx;
		}
		@Override
		public int compareTo(node o) {
			if ( this.now.compareTo(o.now) >= 0) {
				return 1;
			}
			return -1;
		}
	}
}
