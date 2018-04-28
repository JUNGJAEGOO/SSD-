import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;

public class FileManager {
	public static void main(String args[]) {
		FileManager fm = new FileManager();
		String fileName = "About.txt";
		Path fromPath = fm.writeAndRead(fileName);
		fm.copyMoveDelete(fromPath, fileName);
	}
	
	public List<String> getContents(){
		List<String> contents = new ArrayList<>();
		contents.add("그리워 그리워 네가 너무나 그리워서 보고 싶어서");
		contents.add("정말 널 잊고 싶진 않아서");
		contents.add("널 다시 붙잡고 싶어서");
		contents.add("지금 너무나");
		contents.add("난 네가 그리워");
		contents.add("현 날짜는 "+new Date());
		
		return contents;
	}
	
	public void copyMoveDelete(Path fromPath,String fileName) {
		try {
			Path toPath = fromPath.toAbsolutePath().getParent();
			
			Path copyPath = toPath.resolve("copied");
			if ( !Files.exists(copyPath) ) {
				Files.createDirectories(copyPath);
			}
			
			Path copiedFilePath = copyPath.resolve(fileName);
			StandardCopyOption copyOption = StandardCopyOption.REPLACE_EXISTING;
			Files.copy(fromPath, copiedFilePath,copyOption);
			
			System.out.println("**** Copied File contents *****");
			readFile(copiedFilePath);
			
			Path movedFilePath = Files.move(copiedFilePath, copyPath.resolve("moved.txt"), copyOption);
			
			Files.delete(movedFilePath);
			Files.delete(copyPath);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void readFile(Path path) throws IOException {
		Charset charset = Charset.forName("EUC-KR");
		System.out.println(path.toAbsolutePath());
		List<String> fileContents = Files.readAllLines(path);
		for ( String list : fileContents) {
			System.out.println(list);
		}
		System.out.println();
	}
	
	public Path writeFile(Path path) throws IOException {
		Charset charset = Charset.forName("EUC-KR");
		
		List<String> contents = getContents();
		
		StandardOpenOption openOption = StandardOpenOption.CREATE;
		return Files.write(path, contents, openOption);
	}
	
	public Path writeAndRead (String fileName) {
		Path returnPath = null;
		try {
			Path path = Paths.get(fileName);
			returnPath = writeFile(path);
			System.out.println("**** Created File contents *****");
			readFile(returnPath);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return returnPath;
	}
}
