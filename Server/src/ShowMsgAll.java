import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class ShowMsgAll extends Service{
	
	private UserManager userManager;
	
	private OutputStream os;
	private DataOutputStream dos;
	
	public void run(Object jsonObjectData) {
		
		
		JSONObject jsonObject=(JSONObject)jsonObjectData;
		String msg = (String) jsonObject.get("msg");
		userManager=UserManager.getInstance();
		
		Iterator<Socket> it = userManager.list().keySet().iterator();
		Socket key;
		
		while(it.hasNext()){
			key = it.next();
			try{
				os = key.getOutputStream();
				dos = new DataOutputStream(os);
				
				dos.writeUTF(getTime()+ 
						userManager.list().get(key).getName()+ " " +msg);
				
			}catch(IOException e){
				e.printStackTrace();
			}
		}		
	}
	
	static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss] ");
		return f.format(new Date());
	} // getTime	
}