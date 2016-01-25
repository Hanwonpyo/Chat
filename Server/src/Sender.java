import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class Sender {

	private Vector user;
	private String sender_name;
	
	Sender(Vector user,String name) {
		this.user=user;
		this.sender_name=name;
	}
	
	public void show_message(String msg) {
		for (int i = 0; i < user.size(); i++) {
			Reciver temp = (Reciver) user.elementAt(i);
			try {
				temp.dos.writeUTF(getTime() + " " + sender_name +" :"+msg); //server->client
			}
			catch (IOException e) {
				//message X
			}
		}
	}

	static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	} // getTime	
}
