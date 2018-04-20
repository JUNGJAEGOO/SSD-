package back11946;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		String info[] = in.nextLine().split(" ");
		int N = Integer.parseInt(info[0]);
		int M = Integer.parseInt(info[1]);
		int Q = Integer.parseInt(info[2]);
		
		int fail[][] = new int[N+1][M+1];
		int sumOftime[] = new int[N+1];
		int success[] = new int[N+1];
		boolean pass[][] = new boolean[N+1][M+1];
		
		for ( int i = 0 ; i< Q ; i++) {
			
			String tmp[] = in.nextLine().split(" ");
			int time = Integer.parseInt(tmp[0]);
			int team = Integer.parseInt(tmp[1]);
			int problem = Integer.parseInt(tmp[2]);
			String result = tmp[3];
			
			if ( result.equals("AC") ) {
				if ( pass[team][problem] == false ) {
					sumOftime[team] += (time + fail[team][problem]*20);
					success[team]++;
					pass[team][problem] = true;
				}
			}else {
				fail[team][problem]++;
			}
			
		}
		
		ArrayList<node> list = new ArrayList<>();
		
		for ( int i = 1 ; i<= N ; i++) {
			list.add(new node(i,success[i],sumOftime[i]));
		}
		
		Collections.sort(list);
		
		for ( int i = 0 ; i< N ; i++) {
			System.out.println(list.get(i).idx+" "+list.get(i).count+" "+list.get(i).sum);
		}
		
	}
	
	public static class node implements Comparable<node> {
		
		int idx;
		int count;
		int sum;
		
		node (int idx, int count,int sum){
			this.idx = idx;
			this.count = count;
			this.sum = sum;
		}
		
		public int compareTo(node o){
			if ( this.count < o.count) {
				return 1;
			}else if ( this.count == o.count) {
				if ( this.sum > o.sum) {
					return 1;
				}else if ( this.sum == o.sum){
					if ( this.idx > o.idx) {
						return 1;
					}else {
						return -1;
					}
				}else {
					return -1;
				}
			}
			return -1;
		}
	}
}
