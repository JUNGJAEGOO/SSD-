import java.net.*;

public class RequestHandler extends Thread{
	Socket socket;
	
	RequestHandler (Socket socket){
		this.socket = socket;
	}
	public void run() {
		//System.out.println(socket);
		
		RequestManager req = new RequestManager(socket);
		RequestDTO dto = req.readRequest();
		System.out.println(dto.getUri());
		
		ResponseManager res = new ResponseManager(socket);
		res.writeResponse(socket, dto);
	}
}
