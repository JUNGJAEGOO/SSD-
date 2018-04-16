package back15651;

import java.util.*;

public class Main {
	static int N,M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		M = in.nextInt();
		
		func(0,new ArrayList<Integer>());
		
		System.out.print(sb);
	}
	
	public static void func(int len,ArrayList<Integer> list) {
		if ( len == M) {
			
			for ( int i = 0 ; i < list.size() ; i++ ) {
				sb.append(list.get(i)+" ");
			}sb.append("\n");
			
			return;
		}else {
			
			for ( int i = 1 ; i <= N ; i++) {
				
				list.add(i);
				func(len+1,list);
				list.remove(list.size()-1);
				
			}
			
			
		}
	}
}
