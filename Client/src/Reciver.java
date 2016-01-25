import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Reciver extends Thread{
	
	private InputStream is;
	private DataInputStream dis;
	Socket socket;
	guiController guiControl;
	
	Reciver(Socket socket,guiController guiControl)
	{
		this.socket=socket;
		this.guiControl=guiControl;
		try {
			is = socket.getInputStream();
			dis = new DataInputStream(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
		public void run() {
			while (true) {
				try {
					String msg = dis.readUTF();
					System.out.println(msg);
					guiControl.append_message(msg);
					
				} catch (IOException e) {
					try {
						is.close();
						dis.close();
						socket.close();
						break;
					} catch (IOException ex) {
					  }
				}
			}
	}
}
