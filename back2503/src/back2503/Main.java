package back2503;

import java.util.*;

public class Main {
	static ArrayList<node> candidate = new ArrayList<>();
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int T = N;
		
		for (int i = 1 ; i <= 9 ; i++) {
			for ( int j = 1 ; j <= 9 ; j++) {
				for ( int k = 1 ; k <= 9 ; k++) {
					candidate.add(new node(i*100+j+10+k,true));
				}
			}
		}
		
		while( T > 0) {
			int q = in.nextInt();
			int bak = q/100;
			int sib = (q%100)/10;
			int il = q%10;
			
			int s = in.nextInt();
			int b = in.nextInt();
			
			
				if ( s == 3) {
					for (int i = 0 ; i < candidate.size() ; i++) {
						if ( candidate.get(i).num == bak*100+sib+10+il ) {
							
						}else if ( candidate.get(i).num == sib*100+bak+10+il ){
							
						}else if ( candidate.get(i).num == il*100+bak+10+sib ) {
							
						}else if ( candidate.get(i).num == sib*100+il+10+bak ) {
							
						}else if ( candidate.get(i).num == il*100+sib+10+bak ) {
							
						}else if ( candidate.get(i).num == bak*100+il+10+sib ) {
							
						}else if ( candidate.get(i).num == bak*100+sib+10+il ) {
							
						}else {
							candidate.get(i).ok = false;
						}
					}
				}else if ( s == 2 ) {
					
				}else if ( s == 1) {
					
				}
			
			
			T--;
		}
	}
	public static class node{
		int num;
		boolean ok;
		node (int num,boolean ok){
			this.num = num;
			this.ok = ok;
		}
	}
	
	public static void search(int a) {
		
		
		
	}
}
