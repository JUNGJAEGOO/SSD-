package back14003;

import java.util.*;
import java.io.*;

public class Main {
	static int N;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<node> track = new ArrayList();
	
		
		int d[] = new int[N];
		d[0] = arr[0];
		
		track.add(new node(0,arr[0]));
		int idx = 0;
		for ( int i = 1 ; i < N ; i++) {
			
			if ( d[idx] < arr[i] ) {
				d[++idx] = arr[i];
				
				track.add(new node(idx,arr[i]));
			}else {
				
				int j = Arrays.binarySearch(d,0,idx, arr[i]);
				//System.out.println(j);
				if ( j < 0) {
					j = -j - 1;
				}
				
				/*for ( int x : d) {
					System.out.print(x+" ");
				}System.out.println();
				*/
				
				//System.out.println(arr[i]+" "+j);
				d[j] = arr[i];
				
				track.add(new node(j,arr[i]));
			}
			
		}
		
		Stack<Integer> ST = new Stack<>();
		int temp = idx;
		for ( int i = track.size()-1 ; i >= 0 ; i--) {
			
			if ( temp == track.get(i).idx ) {
				ST.push(track.get(i).num);
				--temp;
			}
			
			
		}
		
		System.out.println(idx+1);
		while ( !ST.isEmpty() ) {
			System.out.print(ST.pop()+" ");
		}
		
	}
	
	public static class node{
		int idx;
		int num;
		node (int idx,int num){
			this.idx = idx;
			this.num = num;
		}
	}
}
