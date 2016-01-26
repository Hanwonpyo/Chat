
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class UserManager {
	
	private static UserManager userManager = new UserManager();
	
	private Map<Socket,User> userList;
	
	UserManager(){
		userList = new HashMap<Socket,User>();
	}
	public static UserManager getInstance(){
		return userManager;
	}
	
	public void add(Socket socket, User user) {
		this.userList.put(socket, user);
	}
	public void remove(Socket socket) {
		this.userList.remove(socket);
	}
	public Map<Socket,User> list()
	{
		return userList;
	}
}
