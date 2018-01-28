package back1017;

import java.util.*;

public class Main {
	static int A[];
	static int B[];
	static boolean visit[];
	static ArrayList<Integer> adj[];
	static ArrayList<Integer> a= new ArrayList<>(),b = new ArrayList<>();
	static boolean prime[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		visit = new boolean[25];
		adj = new ArrayList[25];
		A = new int[25];
		B = new int[25];
		prime = new boolean [5000];
		isPrime();
		boolean firstodd = false;
		for ( int i = 0 ; i < N ; i++) {
			int x = in.nextInt();
			if ( i == 0 && x%2 == 1) {
				firstodd = true;
			}
			if ( x%2 == 1) {
				a.add(x);
			}else {
				b.add(x);
			}
			adj[i] = new ArrayList<>();
		}
		
		//System.out.println(a);
		//System.out.println(b);
		
		if ( a.size() != b.size() ) {
			System.out.println(-1);
			return;
		}
		
		
		if ( firstodd == false ) {
			//System.out.println("hi");
			swap(a,b);
		}
		
		//System.out.println(a);
		//System.out.println(b);
		
		for ( int i = 0 ; i < a.size() ; i++) {
			for ( int j = 0 ; j < b.size() ; j++) {
				//System.out.println(a.get(i)+" " +b.get(j));
					if ( prime[a.get(i)+b.get(j)] == false ) {
						adj[i].add(j);
					}
				
			}
		}
		
//		for ( int i = 0 ; i < N/2 ; i++) {
//			System.out.println(adj[i]);
//		}
		
		ArrayList<Integer> res = new ArrayList<>();
		int ans = 0;
		for (int j = 0 ; j < adj[0].size() ; j++) {
			Arrays.fill(A, -1);
			Arrays.fill(B, -1);
			
			A[0] = adj[0].get(j);
			B[adj[0].get(j)] = 0;
			
			ans = 1;
			//System.out.println(arr[adj[0].get(j)]);
			for (int i = 1 ; i < a.size() ; i++) {
				Arrays.fill(visit, false);
				visit[0] = true;
				if ( DFS(i) ) { ans++; }
				//System.out.println("--------");
			}
			//System.out.println(ans);
			if ( ans == a.size()) {
				res.add(b.get(j));
			}
		}
		
		Collections.sort(res);
		if ( res.size() == 0) {
			System.out.println(-1);
			return;
		}
		for (int i = 0 ; i < res.size() ; i++) {
			System.out.print(res.get(i)+" ");
		}System.out.println();
	}
	
	
	public static boolean DFS(int start) {
		if ( visit[start] == true) {
			return false;
		}
		visit[start] = true;
		
		for (int i = 0 ; i < adj[start].size() ; i++) {
			int to = adj[start].get(i);
			//System.out.println(arr[start]+arr[to]);
			
				if ( B[to] == -1 || DFS(B[to])  ) {
					A[start] = to;
					B[to] = start;
					//System.out.println(start+" -> "+to);
					return true;
				}
			
		}
		
		
		return false;
		
	}
	
	public static void isPrime() {
		
		prime[1] = true;
		for (int i = 2 ; i< 5000 ; i++) {
			if ( prime[i] == false) {
				//System.out.println(i);
				for (int j = i+i ; j < 5000 ; j = j+i) {
					if ( j >= 5000) {
						break;
					}
					prime[j] = true;
				}
			}
		}
	}
	
	public static void swap(ArrayList<Integer> AA,ArrayList<Integer> BB) {
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		for (int i = 0 ; i < AA.size() ; i++) {
			tmp.add(AA.get(i));
		}
		a = new ArrayList<>();
		for  (int i = 0 ; i < BB.size() ; i++) {
			a.add(BB.get(i));
		}
		
		b = new ArrayList<>();
		for  (int i = 0 ; i < tmp.size() ; i++) {
			b.add(tmp.get(i));
		}
	}
}
