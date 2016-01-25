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

public class Reciver extends Thread{
	
		private InputStream is;
		private OutputStream os;
		private DataInputStream dis;
		public DataOutputStream dos;

		private Socket socket;
		private Vector user;

		private String name;

		Reciver(Socket socket, Vector user,String name)
		{
			// 매개변수로 넘어온 자료 저장
			this.socket =socket;
			this.user=user;
			this.name=name;
		
			try {
				is = socket.getInputStream();
				dis = new DataInputStream(is);
				os = socket.getOutputStream();
				dos = new DataOutputStream(os);

			} catch (Exception e) {
			
			}
		}
		public void run() {
			while (true) {
				try {
					String msg = dis.readUTF(); //client->server
					Sender sender=new Sender(user,name); // server->client
					sender.show_message(msg);
				//	show_message(msg); //server->client
				} 
				catch (IOException e) 
				{
					try {
						dos.close();
						dis.close();
						socket.close();
						user.removeElement(this);
						break;
					} catch (Exception ex) {
					
					}
				}
			}
		}
}