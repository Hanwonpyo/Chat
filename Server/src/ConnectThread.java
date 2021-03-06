
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectThread extends Thread{
	
	private ServerSocket serverSocket;
	private Socket socket;
			
	ConnectThread(ServerSocket serverSocket)
	{
		this.serverSocket=serverSocket;
	}

	@Override
	public void run() {
		while (true) {
			try {
				socket = serverSocket.accept();
				   
	            ReciverThread reciverThread= new ReciverThread(socket);
	            reciverThread.start();
	            
	            User user = new User(socket);
	            UserManager.getInstance().add(socket,user);
		    	
		    }catch (IOException e) {
		    	e.printStackTrace();
		     }
		 }
	} 
}