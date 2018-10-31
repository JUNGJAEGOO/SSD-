package back1700;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		
		int soon[] = new int[K];
		int dist[][] = new int[102][102];
		int cnt[] = new int[101];
		
		for ( int i = 0 ; i < K ; i++) {
			int x = Integer.parseInt(st.nextToken());
			soon[i] = x;
		}
		
		for ( int i = 0 ; i < 102 ; i++) {
			for ( int j = 0 ; j < 102 ; j++) {
				dist[i][j] = 1000;
			}
		}
		
		for ( int i = 0 ; i < K ; i++) {
			
			dist[soon[i]][cnt[soon[i]]] = i;
			cnt[soon[i]]++;
			
		}
		
		boolean on[] = new boolean[101];
		int arr[] = new int[N];
		Arrays.fill(arr, -1);
		Arrays.fill(cnt, 0);
		Arrays.fill(on, false);
		int ans = 0;
		
		lop:
		for ( int i = 0 ; i < K ; i++) {
			
			/*for ( int j = 0 ; j < N ; j++) {
				if ( arr[j] != -1) {
					System.out.print(arr[j]+" ");
				}
			}System.out.println();*/
			
			
			if ( on[soon[i]] ) {
				cnt[soon[i]]++;
				continue;
			}
			
			int max = 0;
			int maxidx = 0;
			
			boolean flag = false;
			
			for ( int j = 0 ; j < N ; j++) {
				
				if ( arr[j] == -1) {
					arr[j] = soon[i];
					on[soon[i]] = true;
					cnt[soon[i]]++;
					flag = true;
					break;
				}
				
				int len = dist[arr[j]][cnt[arr[j]]] - i; //dist[soon[i]][cnt[soon[i]]] - i;
				//System.out.print(arr[j]+" "+cnt[arr[j]]+" ");
				if ( dist[arr[j]][cnt[arr[j]]] == 1000) {
					len = 1000;
				}
				//System.out.println(len);
				
				if ( max < len) {
					max = len;
					maxidx = j;
				}
				
			}
			
			//System.out.println(i+"! "+max+" "+soon[i]);
			
			if ( !flag ) {
				on[arr[maxidx]] = false;
				arr[maxidx] = soon[i];
				on[soon[i]] = true;
				cnt[soon[i]]++;
				ans++;
			}
			
		}
		
		System.out.print(ans);
	}
}
