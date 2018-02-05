package back13306;


import java.util.*;

public class Main {
	static tree root = new tree(1);
	static tree tmp;
	static tree TREE[];
	static boolean visit[];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int Q = in.nextInt();
		TREE = new tree[N+1];
		for (int i = 1; i <= N ; i++) {
			TREE[i] = new tree(i);
		}
		
		for (int i = 2 ; i <= N ; i++) {
			int x = in.nextInt();
			TREE[x].child.add(TREE[i]);
			TREE[i].parent = TREE[x];
		}
		
		for (int i = 0 ; i < N-1+Q ; i++) {
			int com = in.nextInt();
			if ( com == 0) {
				int x = in.nextInt();
				TREE[TREE[x].parent.idx].child.remove(TREE[x]);
				TREE[x].parent = null;
				
				//System.out.println(TREE[x].parent);
				
			}else {
				int x = in.nextInt();
				int y = in.nextInt();
				visit = new boolean[N+1];
				boolean pass = BFS(x,y);
				if ( pass ) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
		}
	}
	
	static boolean BFS(int start,int end) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visit[start] = true;
		while ( !q.isEmpty()) {
			int now = q.poll();
			//System.out.println(now);
			if ( TREE[now].parent != null) {
			//System.out.println("¾Öºñ: "+TREE[now].parent.idx);
			}
			if ( now == end) {
				return true;
			}
			
			for (int i = 0 ; i < TREE[now].child.size() ; i++) {
				int next = TREE[now].child.get(i).idx;
				if ( visit[next] == false) {
					q.add(next);
				}
			}
			if ( TREE[now].parent != null) {
				if ( visit[TREE[now].parent.idx] == false ) {
					q.add(TREE[now].parent.idx);
					visit[TREE[now].parent.idx] = true;
				}
			}
			
		}
		
		
		return false;
	}
	
	static class tree{
		int idx;
		tree parent;
		ArrayList<tree> child = new ArrayList<>();
		
		tree(int idx){
			this.idx = idx;
		}
		
	}
	

}
