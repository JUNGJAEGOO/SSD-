package back15702;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int problem[] = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for ( int i = 0 ; i < N ; i++) {
			problem[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<node> person = new ArrayList<>();
		for ( int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int num = Integer.parseInt(st.nextToken());
			person.add(new node(num,0));
			for ( int j = 0 ; j < N ; j++) {
				String o = st.nextToken();
				if ( o.equals("O")) {
					person.get(person.size()-1).sum += problem[j];
				}
			
			}
		}
		
		Collections.sort(person);
		
		System.out.print(person.get(0).idx+" "+person.get(0).sum);
		
	}
	public static class node implements Comparable<node>{
		int sum;
		int idx;
		node (int idx,int sum){
			this.idx = idx;
			this.sum = sum;
		}
		@Override
		public int compareTo(node o) {
			if ( this.sum < o.sum) {
				return 1;
			}else if ( this.sum == o.sum) {
				if ( this.idx > o.idx) {
					return 1;
				}else {
					return -1;
				}
			}
			return -1;
		}
	}
}
