package back3048;

import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N1 = Integer.parseInt(st.nextToken());
		int N2 = Integer.parseInt(st.nextToken());
		
		char[] tmpn1 = br.readLine().toCharArray();
		char[] n2 = br.readLine().toCharArray();
		char n1[] = new char[tmpn1.length];
		
		for ( int i = 0 ; i < tmpn1.length ; i++) {
			n1[tmpn1.length-i-1] = tmpn1[i];
		}
		
		node[] gogo = new node[n1.length+n2.length];
		
		for ( int i = 0 ; i < n1.length ; i++) {
			gogo[i] = new node(n1[i],'E');
		}
		for ( int i = 0 ; i < n2.length ; i++) {
			gogo[n1.length+ i] = new node(n2[i],'W');
		}
		
		int T = Integer.parseInt(br.readLine());
		
		while ( T > 0 ) {
			
			for ( int i = 0 ; i < gogo.length-1 ; i++) {
				
				if ( gogo[i].dir == 'E' && gogo[i+1].dir == 'W') {
					node tmp = new node(gogo[i].now,gogo[i].dir);
					gogo[i] = new node(gogo[i+1].now,gogo[i+1].dir);
					gogo[i+1] = new node(tmp.now,tmp.dir);
					i++;
					
				}
				
				if ( i >= gogo.length ) {
					break;
				}
			}
			
			
			T--;
		}
		
		for ( node x : gogo ) {
			System.out.print(x.now);
		}
		//System.out.print(gogo);
	}
	
	public static class node{
		char now;
		char dir;
		node ( char now, char dir){
			this.now = now;
			this.dir = dir;
		}
	}
}
