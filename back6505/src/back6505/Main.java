package back6505;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while ( true ) {
			
			StringTokenizer st = new StringTokenizer (br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if ( N == 0 && M == 0) {
				break;
			}
			
			st = new StringTokenizer (br.readLine()," ");
			int arr[] = new int[N];
			ArrayList<node> soonser = new ArrayList<>();
			
			for (int i = 0 ; i < N ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				soonser.add(new node(i,arr[i]));
			}
			
			Collections.sort(soonser);
			/*for (int i =  0 ; i < N ; i++) {
				System.out.println(soonser.get(i).x + " " + soonser.get(i).y);
			}*/
			char[] origin = br.readLine().toCharArray();
			char[] real = new char[origin.length];
			for ( int i = 0 ; i < real.length ; i++) {
				real[i] = origin[i];
			}
			
			//M = M%N;
			
			int period = 0;
			
			while ( true) {
				
					char[] copyOforigin = new char[origin.length];
					for ( int j = 0 ; j < origin.length ; j++) {
						copyOforigin[j] = origin[j];
					}
					
					for (int j = 0 ; j < origin.length ; j++) {
						copyOforigin[j] = origin[soonser.get(j).x];
					}
					
					for ( int j = 0 ; j < origin.length ; j++) {
						origin[j] = copyOforigin[j];
					}
	
					period++;
					
					boolean pass = true;
					for ( int j = 0 ; j < origin.length ; j++) {
						if ( real[j] != origin[j]) {
							pass = false;
							break;
						}
					}
					
					if ( pass ) {
						break;
					}
				
			}
			//System.out.println(period);
			
			for ( int s = 0 ; s < M%period ; s++) {
				char[] copyOforigin = new char[origin.length];
				for ( int j = 0 ; j < origin.length ; j++) {
					copyOforigin[j] = origin[j];
				}
				
				for (int j = 0 ; j < origin.length ; j++) {
					copyOforigin[j] = origin[soonser.get(j).x];
				}
				
				for ( int j = 0 ; j < origin.length ; j++) {
					origin[j] = copyOforigin[j];
				}
			}
			
			for (int i = 0 ; i < origin.length ; i++) {
				System.out.print(origin[i]);
			}System.out.println();
			
		}
	}
	
	public static class node implements Comparable<node>{
		int x,y;
		
		node (int x,int y){
			this.x = x;
			this.y = y;
		}
		
		public int compareTo (node o){
			
			if ( this.y > o.y) {
				return 1;
			}
			return -1;
		}
		
	}
}
