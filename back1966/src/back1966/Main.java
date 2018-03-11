package back1966;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T > 0 ) {
			
			int N = in.nextInt();
			int M = in.nextInt();
			
			HashMap<Integer,Integer> hm = new HashMap<>();
			Deque<node> dq = new LinkedList<>();
			
			int arr[] = new int[N];
			for ( int i = 0 ; i < N ; i++) {
				int impo = in.nextInt();
				arr[i] = impo;
				dq.add(new node(impo,i));
				hm.put(i+1, impo);
			}
			Arrays.sort(arr);
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0 ; i < arr.length ; i++) {
				list.add(arr[i]);
			}
			Collections.reverse(list);
			for (int i = 0 ; i < arr.length ; i++) {
				arr[i] = list.get(i);
			}
			//System.out.println(dq.size());
			int cnt = 0;
			int ans = 0;
			int max = arr[0];
			while ( true ) {
			
				
				//System.out.println(dq.peekLast().idx);
				
				if ( dq.peekFirst().importance != max ) {
					node tmp = dq.removeFirst();
					dq.addLast(tmp);
				}else {
					ans++;
					node out = dq.removeFirst();
					if (  out.idx == M) {
						System.out.println(ans);
						break;
					}
					cnt++;
					max = arr[cnt];
				}
				
				if ( cnt > N) {
					break;
				}
			
			}
			
			T--;
		}
	}
	public static class node{
		int importance;
		int idx;
		node ( int importance, int idx){
			this.importance = importance;
			this.idx = idx;
		}
	}
}
