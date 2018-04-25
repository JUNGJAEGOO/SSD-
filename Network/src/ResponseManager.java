import java.io.*;
import java.net.*;
import java.util.*;

public class ResponseManager {
	Socket socket;
	
	ResponseManager(Socket client){
		this.socket = client;
	}
	public void writeResponse(Socket sock,RequestDTO dto) {
		
		try {
			PrintStream ps = new PrintStream((socket.getOutputStream()));
			//System.out.println(socket);
			
			if ( dto.getUri().equals("/today")) {
				Date date = new Date();
				ps.println(date);
			}else {
				
				ps.println("It is working");
			}
			
			ps.flush();
			ps.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	
	}
}
