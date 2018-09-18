package back14238;
import java.util.*;
import java.io.*;
public class Main {
	static int arr[];
	static int N;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		char[] c = in.nextLine().toCharArray();
		arr = new int[3];
		for ( int i = 0 ; i < c.length ; i++) {
			if ( c[i] == 'A') {
				arr[0]++;
			}else if( c[i] == 'B') {
				arr[1]++;
			}else {
				arr[2]++;
			}
		}
		
		N = c.length;
		
		DFS("");
		System.out.print(-1);
	}
	
	public static void DFS(String str) {
		
		if ( str.length() == N) {
			
			System.out.print(str);
			System.exit(0);
		}
		
		if ( arr[0] > 0) {
			arr[0]--;
			DFS(str+'A');
			arr[0]++;
		}
		
		if ( str.length() == 0) {
			
			if ( arr[1] > 0) {
				arr[1]--;
				DFS(str+'B');
				arr[1]++;
			}			
			
			if ( arr[2] > 0) {
				arr[2]--;
				DFS(str+'C');
				arr[2]++;
			}
			
		}else if( str.length() == 1) {
			
			if ( str.charAt(str.length()-1) != 'B' ){
				if ( arr[1] > 0 ) {
					arr[1]--;
					DFS(str+'B');
					arr[1]++;
				}
			}
			
			if ( str.charAt(str.length()-1) != 'C' ){
				if ( arr[2] > 0 ) {
					arr[2]--;
					DFS(str+'C');
					arr[2]++;
				}
			}
			
			
		}else if ( str.length() >= 2) {
			
			if ( str.charAt(str.length()-1) != 'B' ){
				if ( arr[1] > 0 ) {
					arr[1]--;
					DFS(str+'B');
					arr[1]++;
				}
			}
			
			if ( str.charAt(str.length()-1) != 'C' && str.charAt(str.length()-2) != 'C'){
				if ( arr[2] > 0 ) {
					arr[2]--;
					DFS(str+'C');
					arr[2]++;
				}
			}
			
			
		}
		
	}
}
