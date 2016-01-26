
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class User {
	
	private Socket socket;
	
	private String name;
	private int authority;
	
	public User(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket=socket;
	}
	
	public String getName() {
		return this.name;
	}
}