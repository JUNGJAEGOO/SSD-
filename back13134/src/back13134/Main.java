package back13134;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String args[]) throws IOException {
		//Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader ( new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt[] = new int[19683];
		
		for ( int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int tmp = 0;
			for ( int j = 0 ; j < 9 ; j++) {
				tmp = tmp*3 + Integer.parseInt(st.nextToken()) - 1;
			}
			cnt[tmp]++;
		}
		
		int max = 0;
		int min = (int)1e9;
		for ( int i = 0 ; i < cnt.length ; i++) {
			
			int sum = 0;
			for ( int j = 0 ; j < 1<<9 ;j++) {
				
				int tmp = 0;
				int ti = i;
				int tj = j;
				for ( int k = 0 ; k < 9 ; k++ ,ti /=3 , tj /=2) {
					tmp = tmp*3 + ( ti%3 + tj%2) % 3;
					
				}
				sum += cnt[tmp];
				
			}
			max = Math.max(max, sum);
			min = Math.min(min, sum);
		}
		System.out.print(min+" "+max);
	}
	
}
