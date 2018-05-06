package back1544;

import java.util.*;

public class Main {
	
	static boolean visit[];
	static int adj[][];
	static int N;
	
	public static void main(String args[]) {
		
		Scanner in = new  Scanner(System.in);
		N = Integer.parseInt(in.nextLine());
		
		String arr[] = new String[N];
		
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextLine();
		}
		
		adj = new int[N+1][N+1];
		
		int sum = 0;
		for ( int i = 0 ; i < N ; i++) {
			
			
			for ( int j = 0 ; j < N ; j++) {
				if ( j == i ) {
					continue;
				}
				
				for  (int k = 0 ; k < arr[j].length() ; k++) {
					
					//System.out.println(shift(k,arr[j].toCharArray()));
					if ( shift(k,arr[j].toCharArray()).equals(arr[i]) ) {
						
						adj[i][j] = 1;
						adj[j][i] = 1;
						break;
					}
					
				}
				
				/*if ( !pass ) {
					System.out.println(arr[i]+" "+arr[j]+" 다르다");
					sum++;
				}*/
			}
			
			
			
			
		}
		
		/*for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j ++) {
				System.out.print(adj[i][j]+" ");
			}System.out.println();
		}*/
		
		visit = new boolean[N+1];
		
		for ( int i = 0 ; i < N ; i++) {
			if ( visit[i] == false) {
				BFS(i);
				sum++;
			}
		}
		
		System.out.print(sum);
		
	}
	
	public static void BFS(int start) {
		Queue<Integer> q = new LinkedList<>();
		visit[start] = true;
		q.add(start);
		//System.out.println(start+" 시작");
		while ( !q.isEmpty() ) {
			
			int now = q.poll();
			//System.out.println(now);
			
			for ( int i = 0 ; i < N ; i++) {
		
				if ( adj[now][i] == 1) {
			
					if ( visit[i] == false) {
						visit[i] = true;
						q.add(i);
					}
				}
			}
			
		}
	}
	
	public static String shift(int len,char[] word) {
		
		char origin[] = new char[word.length];
		for ( int i = 0 ; i < origin.length ; i++) {
			origin[i] = word[i];
		}

		char res[] = new char[word.length];
		
		for ( int i = 0 ; i < res.length ; i++) {
			if ( i - len < 0) {
				res[i] = origin[(i-len)+word.length];
			}else {
				res[i] = origin[(i-len)];
			}
			
		}
		
		return String.valueOf(res);
	}

}
