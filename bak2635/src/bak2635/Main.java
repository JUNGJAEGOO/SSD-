package bak2635;

import java.util.*;

public class Main {
	static ArrayList<Integer> ans = new ArrayList<>();
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		for  (int i = 1 ; i <= N ; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(N);
			list.add(i);
			make(N,i,list);
		}
		
		System.out.println(ans.size());
		for ( int i = 0 ; i < ans.size() ; i++) {
			System.out.print(ans.get(i)+" ");
		}
	}
	public static void make(int beforebefore,int before,ArrayList<Integer> list) {
		
		if ( beforebefore - before < 0) {
			
			if ( list.size() > ans.size() ) {
				ans = new ArrayList<>();
				for ( int i = 0 ; i < list.size() ; i++) {
					ans.add(list.get(i));
				}
			}
			
			return;
		}
		else {
			
			list.add(beforebefore-before);
			make(before,beforebefore-before,list);
			
		}
		
	}
}
