package back11663;

import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<node> list;
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		list = new ArrayList<>();
		for ( int i = 0 ; i < arr.length ; i++) {
			list.add(new node(i+1,arr[i]));
		}
		int max = list.get(list.size()-1).num;
		int min = list.get(0).num;
		StringBuilder sb = new StringBuilder();
		for ( int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			if ( start < min && end < min ) {
				sb.append(0+"\n");
				continue;
			}
			if ( start > max && end > max) {
				sb.append(0+"\n");
				continue;
			}
			
			int up = upper(start);
			int down = lower(end);
			
			sb.append(down-up+1+"\n");
		}
		System.out.print(sb);
	}
	
	public static int upper(int start) {
		
		int left = 0;
		int right= list.size()-1;
		int ans = 0;
		while ( left <= right) {
			int mid = (left+right)/2;
			
			if ( list.get(mid).num < start) {
				left = mid + 1;
				
			}else {
				ans = mid;
				right = mid - 1;
			}
		}
		return ans;
	}
	
	public static int lower(int end) {
		int left = 0;
		int right= list.size()-1;
		int ans = 0;
		while ( left <= right) {
			int mid = (left+right)/2;
			
			if ( list.get(mid).num > end) {
				right = mid - 1;
			}else {
				left = mid + 1;
				ans = mid;
			}
		}
		return ans;
	}
	
	public static class node{
		int idx;
		int num;
		node ( int idx,int num){
			this.idx = idx;
			this.num = num;
		}
	}
}
