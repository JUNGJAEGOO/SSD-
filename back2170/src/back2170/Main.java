package back2170;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<node> list = new ArrayList<node>();
		ArrayList<node> result = new  ArrayList<node>();
		for ( int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new node(start,end));
		}
		
		if (  N  == 1 ) {
			System.out.println(list.get(0).end-list.get(0).start);
			return;
		}
		
		Collections.sort(list);
		result.add(new node(list.get(0).start,list.get(0).end));
		int now = 0;
		int cnt = 1;
		while ( true ) {
			long S = result.get(now).start;
			long E = result.get(now).end;
			long start = list.get(cnt).start;
			long end = list.get(cnt).end;
			if ( start > E) {
				result.add(new node(start,end));
				now++;
			}else if ( start <= E) {
				if ( end > E) {
				result.get(now).end = end;
				}
			}
			cnt++;
			if ( cnt >= list.size() ) {
				break;
			}
		}
		long hap = 0;
		for ( int i = 0 ; i < result.size() ; i++) {
			//System.out.println(result.get(i).start+"~"+result.get(i).end);
			hap += Math.abs(result.get(i).end - result.get(i).start);
		}
		System.out.println(hap);
	}
	
	public static class node implements Comparable<node>{
		long start;
		long end;
		node(long start,long end){
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(node o) {
			if ( this.start < o.start ) {
				return -1;
			}
			return 1;
		}
	}
}
