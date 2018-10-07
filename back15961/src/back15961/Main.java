package back15961;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N*2];
		
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for ( int i = N ; i < 2*N ; i++) {
			arr[i] = arr[i-N];
		}
		
		Queue<Integer> q = new LinkedList<>();
		Set<Integer> set = new HashSet<>();
		
		int sort[] = new int[3001];
		for ( int i = 0 ; i < k ; i++) {
			
			q.add(arr[i]);
			sort[arr[i]]++;
			set.add(arr[i]);
			
		}
		
		
		int ans = set.size();
		int size = ans;
		
		if ( !set.contains(c)) {
			ans++;;
		}
		//System.out.println(q+" "+ans);
		
		for ( int i = 1 ; i < 2*N ; i++) {
			
			int out = q.poll();
			sort[out]--;
			if ( sort[out] == 0 ) {
				size--;
			}

			//System.out.println(out+" "+sort[out]+" "+"hi "+sort[arr[i]]+" "+size);
			if ( sort[arr[i]] == 0 ) {
				size++;
			}
			sort[arr[i]]++;
			q.add(arr[i]);
			
			if ( sort[c] == 0 ) {
				ans = Math.max(ans, size+1);
				//System.out.println(q+" "+size+1);
			}else {
				ans = Math.max(ans, size);
				//System.out.println(q+" "+size);
			}
			
			
			
			
			
		}
		
		
		System.out.print(ans);
		
	}
}
