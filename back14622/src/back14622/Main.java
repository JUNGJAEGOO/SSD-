package back14622;

import java.io.*;
import java.util.*;

public class Main {
	static int prime[];
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		prime = new int[5000001];
		eratos();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		ArrayList<Integer> daewoong = new ArrayList<>();
		ArrayList<Integer> kyuseong = new ArrayList<>();;
		int sosoo[] = new int[5000001];
		long Dscore = 0;
		long Kscore = 0;
		int Dlen = 0;
		int Klen = 0;
	
		for ( int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int D = Integer.parseInt(st.nextToken()); // 대웅
			int K = Integer.parseInt(st.nextToken()); // 규성
			
			if ( prime[D] == 1) {  // 대웅 부터 검사
				if ( Klen < 3 ) {
					Kscore+=1000;
				}else {
					Collections.sort(kyuseong);
					Kscore = Kscore + kyuseong.get(Klen-3);
				}
			}else {
				if ( sosoo[D] >= 1) {
					Dscore -= 1000;
				}else {
					sosoo[D] = 1;
					daewoong.add(D);
					Dlen++;
				}
			}
			
			if ( prime[K] == 1) {  // 대웅 부터 검사
				if ( Dlen < 3 ) {
					Dscore+=1000;
				}else {
					Collections.sort(daewoong);
					Dscore = Dscore + daewoong.get(Dlen-3);
				}
			}else {
				if ( sosoo[K] >= 1) {
					Kscore -= 1000;
				}else {
					sosoo[K] = 1;
					kyuseong.add(K);
					Klen++;
				}
			}
		}
		
		System.out.println(Dscore+" "+Kscore);
		
		if ( Dscore > Kscore) {
			System.out.println("소수의 신 갓대웅");
		}else if ( Kscore > Dscore) {
			System.out.println("소수 마스터 갓규성");
		}else if ( Kscore == Dscore){
			System.out.println("우열을 가릴 수 없음");
		}
	}
	
	public static void eratos() {
		prime[0] = 1;
		prime[1] = 1;
		
		for ( int i = 2 ; i < 5000001 ; i++) {
			if ( prime[i] == 0 ) {
				for ( int j = i+i ; j < 5000001 ; j = j+i) {
					prime[j] = 1;
				}
			}
		}
	}
}
