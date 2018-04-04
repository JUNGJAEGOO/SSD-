package back1380;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int cas = 1;
		while ( true ) {
			int n = Integer.parseInt(in.nextLine());
			if ( n == 0) {
				return;
			}
			
			ArrayList<node> hm = new ArrayList<>();
			for ( int i = 0 ; i < n  ; i++) {
				String key = in.nextLine();
				hm.add(new node(key));
			}
			
			for ( int i = 0 ; i < 2*n - 1; i++) {
				String tmp[] = in.nextLine().split(" ");
				int num = Integer.parseInt(tmp[0]) - 1;
				String go = tmp[1];
				if( go.equals("A")) {
					hm.get(num).stateA = 1;
				}else if ( go.equals("B")) {
					hm.get(num).stateB = 1;
				}
			}
			
			for ( int i = 0 ; i <  n ; i ++) {
				if ( hm.get(i).stateA == 0 || hm.get(i).stateB == 0) {
					System.out.println(cas+" "+hm.get(i).name);
					break;
				}
			}
			
			
			cas++;
		}
	}
	
	public static class node{
		String name;
		int stateA;
		int stateB;
		node ( String name){
			this.name = name;
		}
	}
}
