package back5427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import javafx.scene.Node;

public class Main {
	static char mat[][];
	static int fireX,fireY;
	static int startX,startY;
	static int w,h;
	static int inf = 190000000;
	static Queue<data> list;
    static boolean visit[][];

	
	public static void main(String args[]) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while ( T > 0) {
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		mat = new char[h+2][w+2];
		visit = new boolean[h+2][w+2];
            
		for ( int i = 1 ; i <= h ; i++) {
			char[] tmp = br.readLine().toCharArray();
			for ( int j = 1 ; j <= w ; j++) {
				mat[i][j] = tmp[j-1];
				if ( mat[i][j] == '@') {
					startX = i;
					startY = j;
				}
			}
		}

		
		BFS();

		T--;
		}
	}
	
	public static void BFS() throws InterruptedException {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(startX,startY,0));
		
		list = new LinkedList<data>();
		int before = 0;
		for (int i = 1 ; i<= h; i++) {
			for ( int j = 1 ; j <= w ; j++) {
                if ( visit[i][j] == false){
                	if ( mat[i][j] == '*') {
                		list.add(new data(i,j));
                		visit[i][j] = true;
					}
                }
			}
		}
		
		flame();
		int res = -1;
		
		while ( !q.isEmpty()) {
			Node now = q.poll();
			int x = now.x;
			int y = now.y;
			int cost = now.cost; 
			
			
			if ( x == h || y == w || x == 1 || y == 1) {
				res = cost;
				System.out.println(cost+1);
				break;
			}
			
			if ( before != cost) {
				before = cost;
					flame();
				
			}
			
			//System.out.println(x+","+y+" : "+cost);
			
			
			if ( mat[x+1][y] == '.' ) {
				q.add(new Node(x+1,y,cost+1));
				mat[x+1][y] = '@';
			}
			if ( mat[x-1][y] == '.' ) {
				q.add(new Node(x-1,y,cost+1));
				mat[x-1][y] = '@';
			}
			if ( mat[x][y+1] == '.' ) {
				q.add(new Node(x,y+1,cost+1));
				mat[x][y+1] = '@';
			}
			if ( mat[x][y-1] == '.' ) {
				q.add(new Node(x,y-1,cost+1));
				mat[x][y-1] = '@';
			}
			
			
			/*for ( int i = 1 ; i <= h ; i++) {
				for ( int j = 1 ; j<= w ; j++) {
					System.out.print(mat[i][j]);
				}System.out.println();
			}System.out.println("---------");*/
		}
		
		if ( res == -1) {
			System.out.println("IMPOSSIBLE");
		}
	}
	
	public static class data{
		int x,y;
		data(int x,int y){
			this.x =x;
			this.y =y;
		}
	}
	
	public static class Node implements Comparable<Node>{
		int x,y;
		int cost;
		Node(int x,int y,int cost){
			this.x =x;
			this.y =y;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			if ( this.cost > o.cost) {
				return 1;
			}else {
				return -1;
			}
		}
	}
	
	public static void flame() {
		
		int n = list.size();
		
		for ( int i = 0 ; i < n ; i++) {
			data tmp = list.poll();
			int X = tmp.x;
			int Y = tmp.y;
			if ( Y >= 1 && Y <= w){
                if ( X+1 <= h && X+1 >= 1){
			    if ( mat[X+1][Y] == '@' || mat[X+1][Y] == '.' ) {
					mat[X+1][Y] = '*';
					list.add(new data(X+1,Y));
			    }
                }
                if ( X-1 >= 1 && X-1 <= h ){
			    if ( mat[X-1][Y] == '@' || mat[X-1][Y] == '.') {
					mat[X-1][Y] = '*';
					list.add(new data(X-1,Y));
			    }
               }
            }
            
            if ( X >= 1 && X <= h){
                if ( Y+1 <= w && Y+1 >= 1 ){
			    if ( mat[X][Y+1] == '@' || mat[X][Y+1] == '.' ) {
					mat[X][Y+1] = '*';
					list.add(new data(X,Y+1));
			    }
                }
                if ( Y-1 <= w && Y-1 >= 1){
			    if ( mat[X][Y-1] == '@' || mat[X][Y-1] == '.' ) {
					mat[X][Y-1] = '*';
					list.add(new data(X,Y-1));
			    }
                }
			}
		}
	}
}
