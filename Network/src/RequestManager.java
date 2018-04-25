import java.io.*;
import java.net.*;

public class RequestManager {
	Socket socket;
	RequestManager(Socket client){
		this.socket = client;
	}
	public RequestDTO readRequest() {
		RequestDTO dto = null;
		
		try {
			InputStream is = new BufferedInputStream(socket.getInputStream());
			byte[] readBytes = new byte[2048];
			is.read(readBytes);
			String RequestData = new String(readBytes).trim();
			System.out.println(RequestData);
			
			String info[] = RequestData.split(" ");
			String uri = info[1];
			
			dto = new RequestDTO();
			dto.setUri(uri);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return dto;
	}
}
