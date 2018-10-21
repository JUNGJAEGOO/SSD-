package back14718;
import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<node> list = new ArrayList<>();
	static int min = 1000000000;
	static int N,K;
	
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N ; i++) {
			st = new StringTokenizer(in.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.add(new node(a,b,c));
		}
		
		Collections.sort(list);
		
		for ( int x = 0 ; x < N ; x++) {
			for ( int y = 0 ;y < N ; y++) {
				
				int cnt = 0;
				for ( int z = 0 ;z < N ; z++) {
					
					if ( list.get(z).str <= list.get(x).str && list.get(z).dex <= list.get(y).dex) {
						cnt++;
					}
					
					if ( cnt == K) {
						min = Math.min(min, list.get(x).str + list.get(y).dex + list.get(z).wise);
						break;
					}
					
				}
			}
		}
		
		System.out.print(min);
		
	}
	
	
	public static class node implements Comparable<node>{
		int str,dex,wise;
		
		node (int str,int dex,int wise){
			this.str = str;
			this.dex = dex;
			this.wise = wise;
		}

		@Override
		public int compareTo(node o) {
			if ( this.wise > o.wise) {
				return 1;
			}
			return -1;
		}
	}
}
