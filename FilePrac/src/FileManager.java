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
		contents.add("�׸��� �׸��� �װ� �ʹ��� �׸����� ���� �;");
		contents.add("���� �� �ذ� ���� �ʾƼ�");
		contents.add("�� �ٽ� ����� �;");
		contents.add("���� �ʹ���");
		contents.add("�� �װ� �׸���");
		contents.add("�� ��¥�� "+new Date());
		
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
