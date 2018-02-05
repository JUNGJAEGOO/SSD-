package back14679;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int young[][] = new int[1][3]; 
			young[0][0] = in.nextInt(); // 공격력
			young[0][1] = in.nextInt(); // 방어력
			young[0][2] = in.nextInt(); // 체력
	

		BigInteger mop[][] = new BigInteger[1][3];
			mop[0][0] = BigInteger.valueOf(in.nextInt()); // 공격력
			mop[0][1] = BigInteger.valueOf(in.nextInt()); // 방어력
			mop[0][2] = BigInteger.valueOf(in.nextInt()); // 체력

		int Ap = in.nextInt();
		BigInteger Aa = BigInteger.valueOf(in.nextInt());
		int Dp = in.nextInt();
		BigInteger Da = BigInteger.valueOf(in.nextInt());
		int Hp = in.nextInt();
		BigInteger Ha = BigInteger.valueOf(in.nextInt());

		
		for (int i = 0 ; i < N ; i++) {

			int tmpA = young[0][0];
			int tmpD = young[0][1];
			int tmpH = young[0][2];
			BigInteger mopA = mop[0][0];
			BigInteger mopD = mop[0][1];
			BigInteger mopH = mop[0][2];
			//System.out.println(tmpA+" "+tmpD+" "+tmpH);
			//System.out.println(mopA+" "+mopD+" "+mopH);

				if ( BigInteger.valueOf(tmpA).compareTo(mopD) > 0) {
					tmpA = tmpA - mopD.intValue();
				}else {
					tmpA = 1;
				}
				
				if ( BigInteger.valueOf(tmpD).compareTo(mopA) < 0) {
					mopA = mopA.subtract(BigInteger.valueOf(tmpD));
				}else {
					mopA = BigInteger.ONE;
				}
				
				int tmpcnt = mopH.intValue()/tmpA;
				if ( mopH.intValue()%tmpA != 0 ) {
					tmpcnt++;
				}
				
				int mopcnt = tmpH/mopA.intValue();
				if ( tmpH%mopA.intValue() != 0) {
					mopcnt++;
				}
				
				if ( tmpcnt <= mopcnt+1) {
					young[0][0] += mop[0][0].intValue()%1000000007;
					young[0][1] += mop[0][1].intValue()%1000000007;
					young[0][2] += mop[0][2].intValue()%1000000007;
				}else {
					System.out.println(-1);
					return;
					
				}

			mop[0][0] = mop[0][0].pow(Ap).add(Aa).mod(BigInteger.valueOf(100)).add(BigInteger.ONE);
			mop[0][1] = mop[0][1].pow(Dp).add(Da).mod(BigInteger.valueOf(3)).add(BigInteger.ONE);
			mop[0][2] = mop[0][2].pow(Hp).add(Ha).mod(BigInteger.valueOf(1000)).add(BigInteger.ONE);
		
		}
		

		System.out.println(young[0][0]+" "+young[0][1]+" "+young[0][2]);
		
	}
}
