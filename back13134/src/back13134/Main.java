package back13134;

import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	
	public static void main(String args[]) throws IOException {
		//Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader ( new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[][]= new int[N][9];
		
		
		ArrayList<Integer> tmp = new ArrayList<>();
		make(0,tmp);
		
		for ( int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for ( int j = 0 ; j < 9 ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		int min = Integer.MAX_VALUE;
		for ( int i = 0 ; i < adj.size() ; i++) {
			
			int sum = 0;
			
			
			for ( int j = 0 ; j < N ; j++) {
				boolean pass = true;
				for ( int k = 0 ; k < 9 ; k++) {
					if ( adj.get(i).get(k) == arr[j][k] ) {
						pass = false;
						break;
					}
				}
				
				if (pass) {
					sum++;
				}
			}
			
			if ( sum > max) {
				max = sum;
			}
			if ( sum < min) {
				min = sum;
			}
			
		}
		
		System.out.print(min+" "+max);
	}
	
	public static void make(int len,ArrayList<Integer> list) {
		
		
		if ( len == 9 ) {
			//System.out.println(list);
			ArrayList<Integer> tmp = new ArrayList<>();
			for ( int i = 0 ; i < 9 ; i++) {
				tmp.add(list.get(i));
			}
			adj.add(tmp);
			
			return;
		}
		
		for ( int i = 1  ; i <= 3 ; i++) {
			list.add(i);
			make(len+1,list);
			list.remove(list.size()-1);
			
		}
	}
	
	
}
