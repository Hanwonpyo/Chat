import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	
	private String id="";
	private String ip="";

	private Socket socket;

	private OutputStream os;
	private DataOutputStream dos;

	guiController gui_control;
	
	Client(String id,String ip,guiController control)
	{
		this.id=id;
		this.ip=ip;
		this.gui_control=control;
		try {
			socket = new Socket(ip,9000);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		try {
			os = socket.getOutputStream();
			dos = new DataOutputStream(os);
			
			send_message(id);
		} catch (Exception e) {
		}
		Reciver R=new Reciver(socket,gui_control);
		R.start();
	}
	
	public void send_message(String msg)
	{
		 try {
			if(msg.length()>=1)
				dos.writeUTF(msg);
		} catch (IOException e) {
		
		}
	}
}