package back15666;

import java.util.*;

public class Main {
	static ArrayList<Integer> list;
	static int N,M;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		list = new ArrayList<>();
		for ( int i = 0 ; i < N ; i++) {
			int x = in.nextInt();
			if ( !list.contains(x)) {
				list.add(x);
			}
		}
		Collections.sort(list);
		
		func(0,0,new ArrayList<Integer>());
		
	}
	
	public static void func(int len,int last,ArrayList<Integer> visit) {
		
		if ( len == M) {
			
			for ( int i = 0 ; i < visit.size() ; i++) {
				System.out.print(visit.get(i)+" ");
			}System.out.println();
			return;
		}
		
		for ( int i = last ; i < list.size() ; i++) {

				visit.add(list.get(i));
				func(len+1,i,visit);
				visit.remove(visit.size()-1);
			
		}
	}
}
