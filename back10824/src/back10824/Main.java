package back10824;

import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String nums[] = in.nextLine().split(" ");
		String a = nums[0]+nums[1];
		String b = nums[2]+nums[3];
		BigInteger A = new BigInteger(a);
		BigInteger B = new BigInteger(b);
		System.out.println(A.add(B));
	}
}
