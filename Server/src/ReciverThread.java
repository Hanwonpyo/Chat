import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReciverThread extends Thread{

		private Socket socket;
		
		private InputStream is;
		private DataInputStream dis;
		
		ReciverThread(Socket socket)
		{
			this.socket =socket;
		
			try {
				
				is = socket.getInputStream();
				dis = new DataInputStream(is);

			} catch (Exception e) {
			
			}
		}
		
		public void run() {
			while (true) {
				
					try {
						String msg = dis.readUTF();
						Controller.getInstance().execute((String)reqJSONData.get("reqCode"),reqJSONData.get("reqData"));
						
					} catch (IOException e) {
						try {
							UserManager.getInstance().remove(socket);
							
							dis.close();
							socket.close();
							
							break;
						} catch (Exception ex) {
						
						}
					}
			}
		}
}