package back10699;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Main {
	public static void main(String args[]) {
		Date date = new Date();
		System.out.println(date.toString());
		
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		System.out.println(sdf.format(date));
	}
}
