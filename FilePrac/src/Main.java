import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		Main obj = new Main();
		String pathName = "E:\\godofjava\\text";
		//obj.checkFileMethods(pathName);
		//System.out.println("making a directory "+pathName);
		//obj.mkDir(pathName);
		//obj.checkFileMethods(pathName);
		
		File hi = new File(pathName+"\\hi.txt");
		try {
			FileReader fr = new FileReader(hi);
			BufferedReader br = new BufferedReader(fr);
			StringBuilder sb = new StringBuilder();
			while ( true) {
				String str = br.readLine();
				if ( str == null ) {
					break;
				}
				sb.append(str+"\n");
			}
			
			System.out.print(sb);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void checkFileMethods(String pathName) {
		File file = new File(pathName);
		System.out.println(pathName+" is existing? = "+file.exists());
		System.out.println(pathName+" is dirctory? = "+file.isDirectory());
		System.out.println(pathName+" is file? = "+file.isFile());
		System.out.println(pathName+" is hidden? = "+file.isHidden());
		
	}
	
	public void mkDir(String pathName) {
		File file = new File(pathName);
		file.mkdir();
	}
}
