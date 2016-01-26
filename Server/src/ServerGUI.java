import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ServerGUI extends JFrame implements ActionListener{
	private JFrame frame=new JFrame("Server");
	private JPanel panel=new JPanel();
	private JTextArea area_empty=new JTextArea(); 
	private JButton button_start= new JButton("Start");
	
	JScrollPane sc = new JScrollPane();
	
	ServerGUI() {
			
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200,120);
		frame.setVisible(true);
		frame.add(area_empty,BorderLayout.CENTER);
		addButton();
		frame.setVisible(true);
	}
	
	private void addButton() {
		button_start.addActionListener(this);
		frame.add(button_start,BorderLayout.SOUTH);
	}	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button_start) {
			button_start.setText("Server is running");
			button_start.setEnabled(false);
		}
	}
}