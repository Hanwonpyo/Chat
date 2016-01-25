
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Connect extends Thread{ //������ �������� ������ ��ٸ��� thread


	private ServerSocket serverSocket;
	private Socket socket;
	private Vector user= new Vector(); 
	
	private InputStream is;
	private OutputStream os;
	private DataInputStream dis;
	private DataOutputStream dos;
		
	Connect(ServerSocket serverSocket)
	{
		this.serverSocket=serverSocket;
	}

	
	@Override
	public void run() {
		while (true) {
			try {
				Socket socket = serverSocket.accept();
				is=socket.getInputStream();
				dis= new DataInputStream(is);
				os = socket.getOutputStream();
				dos = new DataOutputStream(os);
				
				String name=dis.readUTF(); //���� ���� Ȯ�� ( "han is connect")
				show_connection(name);
				
		    	Reciver R=new Reciver(socket, user, name);
		    	user.addElement(R); //vector �� ����� ����� �߰�
		    	R.start(); // user message i/o thread
		    	
		    	
		    	//socket.close();
		    }catch (IOException e) {
		    	e.printStackTrace();
		     }
		 }
	}
	
	public void show_connection(String name)
	{
		for (int i = 0; i < user.size(); i++) {
			Reciver temp = (Reciver) user.elementAt(i);
			try {
				temp.dos.writeUTF(name + " is connect"); //server->client
			} 
			catch (IOException e) {
				//message X
			}
		}			
	}
	
}