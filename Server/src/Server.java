
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Vector;


public class Server { //�������� �ϴ� �����Ų���� �� �����ϰ� �׾ȿ��� ������ thread ����Ұ�
	
	private ServerSocket serverSocket=null;
//	public static Vector user=new Vector();
	
	Server()
	{		
		try {
			serverSocket = new ServerSocket(9000);
		}catch (IOException e) {
			e.printStackTrace();
	     }
		
		Connect connect=new Connect(serverSocket); //������ ������ ���� 
		connect.start();
	}	
}