
public class guiController { //
	
	Client client;
	ClientGUI clientGUI;
	
	
	public void set_logic(Client client)
	{
		this.client=client;
	}
	public void set_gui(ClientGUI clientGUI)
	{
		this.clientGUI=clientGUI;
	}
	public void append_message(String msg)
	{
		clientGUI.getArea().append(msg + "\n");
	}
	public void send_message(String msg)
	{
		client.send_message(msg);
	}
}
