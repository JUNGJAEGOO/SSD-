
import java.io.*;
import java.net.*;

public class SimpleWebServerInitial {
	
	static int port = 9000;
	static ServerSocket server_socket;
	
	static InputStream is;
	static InputStreamReader isr;
	
	public static void run() {
		ServerSocket server = null;
		
		try {
			System.out.println("server is running");
			server = new ServerSocket(port);
			Socket client;
			while ( true ) {
				
				client = server.accept();
				
				RequestHandler rh = new RequestHandler(client);
				rh.start();
				
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if ( server != null) {
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main( String args[]) {
		
		try {
			
			run();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if ( server_socket != null) {
				try {
					server_socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}

}
