package back2108;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in= new Scanner(System.in);
		int N = in.nextInt();
		HashMap<Integer,Integer> hm= new HashMap<>();
		int arr[] = new int[N];
		long sum = 0;
		for ( int i = 0 ;i < N ; i++) {
			int now = in.nextInt();
			sum += now;
			arr[i] = now;
			if ( hm.get(now) == null) {
				hm.put(now,1);
			}else {
				int cnt = hm.get(now);
				hm.replace(now, cnt+1);
				//System.out.println(now+"번째"+cnt+"를 "+(cnt+1)+"로");
			}
		}
		HashMap<Integer,Integer> fre = new HashMap<>();
		Iterator itr = hm.keySet().iterator();
		int savekey = 0;
		
		while ( itr.hasNext() ) {
			int key = (int)itr.next();
			//System.out.println("키"+key);
			if ( fre.size() == 0 ) {
				//System.out.println(key+"초기화");
				fre.put(key,hm.get(key));
				savekey = key;
			}else {
				if ( hm.get(key) > fre.get(savekey) ) {
					//System.out.println(key+"재 초기화");
					fre = new HashMap<>();
					fre.put(key, hm.get(key));
					savekey = key;
				}
				else if ( hm.get(key) == fre.get(savekey) ) {
					//System.out.println(key+"추가");
					fre.put(key, hm.get(key));
					savekey = key;
				}
			}
		}
		//System.out.println(fre.size());
		Arrays.sort(arr);
		double avg = (double)sum / (double)N;
		//System.out.println(avg);
		int middle = arr[arr.length/2];
		int frequency = 0;
		if ( fre.size() == 1) {
			frequency = savekey;
		}else {
			ArrayList<Integer> frekeys = new ArrayList<>();
			Iterator itr2 = fre.keySet().iterator();
			while ( itr2.hasNext() ) {
				int KEY = (int)itr2.next();
				frekeys.add(KEY);
			}
			Collections.sort(frekeys);
			frequency = frekeys.get(1);
		}
		int range = arr[arr.length-1] - arr[0];
		
		System.out.format("%.0f\n",avg);
		System.out.println(middle);
		System.out.println(frequency);
		System.out.println(range);
	}
}
