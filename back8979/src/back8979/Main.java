package back8979;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int medal[][] = new int[N][4];
		for (int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int idx = Integer.parseInt(st.nextToken()) - 1;
			medal[idx][0] = Integer.parseInt(st.nextToken());
			medal[idx][1] = Integer.parseInt(st.nextToken());
			medal[idx][2] = Integer.parseInt(st.nextToken());
			medal[idx][3] = 0;
		}
		
		int rank = 1;
		
		while( true) {
			int max = -1;
			int maxidx = -1;
			ArrayList<Integer> goldidx = new ArrayList<>();
			ArrayList<Integer> silveridx = new  ArrayList<>();
			ArrayList<Integer> bronzeidx = new  ArrayList<>();
			
			for ( int i = 0 ; i < N ; i++) {
				if ( medal[i][3] == 0) {
					if( medal[i][0] > max) {
						max = medal[i][0];
						maxidx = i;
						goldidx = new ArrayList<>();
						goldidx.add(i);
					}else if ( medal[i][0] == max) {
						goldidx.add(i);
					}
					
				}
			}

			int silvermax = -1;
			int silvermaxidx = -1;
			
			if ( goldidx.size() == 1) {
				medal[maxidx][3] = rank;
				rank++;
			}else if ( goldidx.size() >= 2) {
				
				for ( int i = 0 ; i < goldidx.size() ; i++) {
					int tmpidx = goldidx.get(i);
					if ( medal[tmpidx][1] > silvermax) {
						silvermax = medal[tmpidx][1];
						silvermaxidx = tmpidx;
						silveridx = new ArrayList<>();
						silveridx.add(tmpidx);
					}else if ( medal[tmpidx][1] == silvermax) {
						silveridx.add(tmpidx);
					}
				}
				
			}
			
			int bronzemax = -1;
			int bronzemaxidx = -1;
			

			if ( silveridx.size() == 1) {
				medal[silvermaxidx][3] = rank;
				rank++;
			}else if ( silveridx.size() >= 2) {
				
				for ( int i = 0 ; i < silveridx.size() ; i++) {
					int tmpidx = silveridx.get(i);
					if ( medal[tmpidx][2] > bronzemax) {
						bronzemax = medal[tmpidx][2];
						bronzemaxidx = tmpidx;
						bronzeidx = new ArrayList<>();
						bronzeidx.add(tmpidx);
					}else if ( medal[tmpidx][2] == bronzemax) {
						bronzeidx.add(tmpidx);
					}
				}
				
			}
			
			
			if ( bronzeidx.size() == 1) {
				medal[bronzemaxidx][3] = rank;
				rank++;
			}else {
				for ( int i = 0 ; i < bronzeidx.size() ; i++) {
					medal[bronzeidx.get(i)][3] = rank;
				}
				rank += bronzeidx.size();
			}
			
			if ( rank > N) {
				break;
			}
			
			
		}
		
/*		for ( int i = 0 ; i < N ; i++) {
			System.out.println(medal[i][3]);
		}*/
		System.out.println(medal[K-1][3]);
		
	}
}
