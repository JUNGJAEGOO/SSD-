package back8980;

import java.util.*;

public class Main {
	static ArrayList<node> adj[];
	static int N,C;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		C = in.nextInt();
		int M = in.nextInt();
		adj = new ArrayList[2001];
		for (int i = 1 ; i<= 2000 ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0 ; i < M ; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			int box = in.nextInt();
			adj[from].add(new node(to,box));
		}
	
		for (int i = 1 ; i<= 2000 ; i++) {
			Collections.sort(adj[i]);
		}
		
		for (int i = 1 ; i<= 4 ; i++) {
			System.out.print(i+" : ");
			for (int j = 0 ; j < adj[i].size() ; j++) {
				System.out.print(adj[i].get(j).to+" ");
			}
			System.out.println();
		}
		
		int capa = 0;
		int ans = 0;
		ArrayList<node> bag = new ArrayList<>();
		
		for (int i = 1 ; i<= N ; i++) {
			
			for (int j = 0 ; j < bag.size() ; j++) {
				if ( bag.get(j).to == i) {
					System.out.println("내려놓기 "+bag.get(j).to+" "+bag.get(j).box);
					capa -= bag.get(j).box;
					ans += bag.get(j).box;
					bag.remove(j);
					j--;
				}
			}
			
			for (int j = 0 ; j < adj[i].size() ; j++) {
				capa += adj[i].get(j).box;
				System.out.println("추가 "+i+" "+adj[i].get(j).to+" "+adj[i].get(j).box);
				bag.add(new node(adj[i].get(j).to,adj[i].get(j).box));
			}
			
			if ( capa > C) {
				Collections.sort(bag);
				for (int j = 0 ; j < bag.size() ; j++) {
					System.out.println(bag.get(j).to+" "+bag.get(j).box);
				}
				
				for (int j = bag.size()-1 ; j >= 0 ; j--) {
					
					if ( capa - bag.get(j).box  > C ) {
						System.out.println("제거");
						capa -= bag.get(j).box;
						bag.remove(j);
					}else if ( capa - bag.get(j).box  == C ){
						capa -= bag.get(j).box;
						bag.remove(j);
						break;
					}
					else if ( capa - bag.get(j).box < C) {
						System.out.println(capa-C);
						bag.get(j).box -= capa-C;
						capa = C;
						break;
					}
					
				}
			}
			
		}
		
		System.out.println(ans);
		
	}
	
	
	
	public static class node implements Comparable<node>{

		int from;
		int to;
		int box;
		
		node (int to,int box){
			this.to = to;
			this.box = box;
		}

		@Override
		public int compareTo(node o) {
			if ( this.to > o.to) {
				return 1;
			}
			return -1;
		}

		
	}
}
