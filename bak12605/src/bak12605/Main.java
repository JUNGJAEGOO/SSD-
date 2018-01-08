package bak12605;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[])throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for ( int i = 1 ; i <= N ; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			System.out.print("Case #"+i+": ");
			
			ArrayList<String> list = new ArrayList<>();
			int x = 0;
			while( st.hasMoreTokens()) {
				 list.add(st.nextToken());
			}
			
			for ( int k = list.size()-1 ; k>=0 ; k--) {
				System.out.print(list.get(k)+" ");
			}System.out.println();
			
			
			
		}
	}
}