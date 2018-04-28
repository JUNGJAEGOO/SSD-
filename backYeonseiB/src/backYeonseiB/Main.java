package backYeonseiB;

import java.util.*;

public class Main {
	
	static int maximum;
	static char[] N;
	static ArrayList<node> list = new ArrayList<>();
	static int visit[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextLine().toCharArray();
		maximum = N.length;
		
		visit = new int[10];
		
		func(0,"","");
		
		for ( int i = 0 ; i < list.size() ; i++) {
			System.out.println(list.get(i).A+" "+list.get(i).B);
		}
		
		if (list.size() == 0) {
			System.out.print(-1);
		}else {
			
			int x = Integer.parseInt(list.get(0).A);
			int y = Integer.parseInt(list.get(0).B);
			System.out.print(x+" + "+y);
		}
	}
	
	public static void func(int len,String A,String B) {
		
		System.out.println(A+" "+B);
		
		if ( len == maximum) {
			//System.out.println(A+" "+B);
			if ( !A.equals("0") && !B.equals("0") ) {
				if ( !A.equals(B) ) {
				list.add(new node(A,B));
				}
			}
			return;
		}
		
		if ( N[len] == '0') {
			
			for ( int i = 0 ; i <= 9 ; i++) {
				
				if ( Integer.parseInt(String.valueOf(N[len])) - i != i && visit[i] == 0 && visit[9 - i] == 0){
					visit[i] ++;
					visit[ 9 - i + 1] ++;
					func(len+1,A+String.valueOf(i),B+String.valueOf( 9 - i + 1) );
					visit[i] --;
					visit[ 9 - i + 1] --;
				}
				
			}
		}else {
			for ( int i = 0 ; i <= Integer.parseInt(String.valueOf(N[len])) ; i++) {
				
				if ( Integer.parseInt(String.valueOf(N[len])) - i != i && visit[i] == 0 && visit[ Integer.parseInt(String.valueOf(N[len])) - i] == 0){
					visit[i] ++;
					visit[ Integer.parseInt(String.valueOf(N[len])) - i] ++;
					func(len+1,A+String.valueOf(i),B+String.valueOf(Integer.parseInt(String.valueOf(N[len])) - i) );
					visit[i] --;
					visit[ Integer.parseInt(String.valueOf(N[len])) - i] --;
				}
				
			}
		}
		
	}
	
	public static class node{
		String A;
		String B;
		node ( String A,String B){
			this.A = A;
			this.B = B;
		}
	}

}
