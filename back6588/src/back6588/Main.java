package back6588;

import java.io.*;

public class Main {
	static boolean prime[];
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		prime = new boolean[1000001];
		eratos();
		while ( true) {
			
			int n = Integer.parseInt(br.readLine());
			if ( n == 0) {
				break;
			}
			
			int mid = n/2;
			int i = 1;
			int j = n-1;
			while ( true) {
				
				i++;
				j--;
				
				if ( prime[i] == false && prime[j] == false) {
					if ( i == 2 ) {
						continue;
					}
					sb.append(n+" = "+i+" + "+j+"\n");
					break;
				}
				if ( j < 0 || i >= 100001) {
					sb.append("Goldbach's conjecture is wrong.\n");
				}
				
			}
			
		}
		System.out.print(sb);
	}
	
	public static void eratos() {
		prime[1] = true;
		for (int i = 2 ; i < 1000001 ; i++) {
			if ( prime[i] == false) {
				for (int j = i+i ; j < 1000001 ; j = j + i) {
					if ( j > 1000001 ) {
						break;
					}
					prime[j] = true;
				}
			}
		}
	}
}
