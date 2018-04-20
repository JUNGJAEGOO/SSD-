package back15652;

import java.util.*;

public class Main {
	static int N,M;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		
		ArrayList<Integer> v = new ArrayList<>();
		for ( int i = 1 ; i<= N ; i++) {
			v.add(i);
			func(i,v);
			v.remove(0);
		}
	}
	
	public static void func(int before,ArrayList<Integer> visit) {
		
		if( visit.size() == M) {
			for ( int i = 0 ; i < visit.size() ; i ++ ) {
				System.out.print(visit.get(i)+" ");
			}System.out.println();
			return;
		}
		
		
		for ( int i = before ; i <= N ; i++) {
			visit.add(i);
			func(i,visit);
			visit.remove(visit.size()-1);
		}
	}
}
