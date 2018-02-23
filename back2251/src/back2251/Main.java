package back2251;

import java.util.*;

public class Main {
	static boolean va[],vb[],vc[];
	static int Avol,Bvol,Cvol;
	static ArrayList<Integer> ans = new ArrayList<>();
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		Avol = in.nextInt();
		Bvol = in.nextInt();
		Cvol = in.nextInt();
		va = new boolean[201];
		vb = new boolean[201];
		vc = new boolean[201];
		DFS(0,0,Cvol);
		
		Collections.sort(ans);
		for (int i = 0 ; i < ans.size() ; i++) {
			System.out.print(ans.get(i)+" ");
		}
	}
	
	public static void DFS(int a,int b,int c) {
		
		if ( va[a] && vb[b] && vc[c]) {
			return;
		}
		va[a] = true;
		vb[b] = true;
		vc[c] = true;
		
		if ( a == 0) {
			if( !ans.contains(c)) {
				ans.add(c);
			}
		}
		
		if ( a + b <= Bvol) {
			DFS(0,a+b,c);
		}else if ( a + b > Bvol) {
			int diff = a + b - Bvol ;
			DFS(diff,Bvol,c);
		}

		if ( a + c <= Cvol) {
			DFS(0,b,a+c);
		}else if ( a + c > Cvol) {
			int diff = a + b - Cvol ;
			DFS(diff,b,Cvol);
		}
		
		if ( b + a <= Avol) {
			DFS(b+a,0,c);
		}else if ( b + a > Avol) {
			int diff = b + a - Avol ;
			DFS(Avol,diff,c);
		}

		if ( b + c <= Cvol) {
			DFS(a,0,b+c);
		}else if ( b + c > Cvol) {
			int diff = b + c - Cvol ;
			DFS(a,diff,Cvol);
		}
	//
		if ( c + a <= Avol) {
			DFS(c+a,b,0);
		}else if ( c + a > Avol) {
			int diff = c + a - Avol ;
			DFS(Avol,b,diff);
		}

		if ( c + b <= Bvol) {
			DFS(a,c+b,0);
		}else if ( c + b > Bvol) {
			int diff = c + b - Bvol ;
			DFS(a,Bvol,diff);
		}
		
	}
}
