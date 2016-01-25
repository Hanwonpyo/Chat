
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ClientGUI extends JFrame implements ActionListener, KeyListener{

	
	private String id;
	private String ip;
	
	private JPanel contentPane;
	private JButton button_send;
	private JTextField textField; 
	private JTextArea messageArea;
	private JTextArea listArea; 
	private JLabel label_list;
	
	private guiController control;
	
	public ClientGUI(String id, String ip,guiController control) 
	{
		this.id = id;
		this.ip = ip;
		this.control=control;
		
		//GUI
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 392);
		setPanel();
		addLabel();
		addTextField();
		addScroll();
		addButton();
		setVisible(true);
	}
	
	private void setPanel() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	private void addLabel()
	{
		label_list=new JLabel("User List");
		label_list.setBounds(287,5,100,10);
		contentPane.add(label_list);
	}
	private void addButton() {
		button_send = new JButton("Send");
		button_send.setBounds(161, 312, 111, 42);
		button_send.addActionListener(this);
		contentPane.add(button_send);
	}
	private void addTextField() {
		messageArea = new JTextArea();
		messageArea.setEnabled(false);
		messageArea.setDisabledTextColor(Color.BLACK);
		
		listArea = new JTextArea();
		listArea.setEnabled(false);
		listArea.setDisabledTextColor(Color.BLACK);
		listArea.setBounds(275,18,70,340);
		contentPane.add(listArea);
		
		textField = new JTextField();
		textField.setBounds(0, 312, 155, 42);
		textField.addKeyListener(this);
		contentPane.add(textField);
		textField.setColumns(10);
	}
	private void addScroll()
	{
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 272, 302);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(messageArea);
	}
	
	public JTextArea getArea()
	{
		return messageArea;
	}
	public void setController(guiController control)
	{
		this.control=control;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == button_send) 
		{
			control.send_message(textField.getText());
			textField.setText("");
			textField.requestFocus();
		}
	}

	@Override
	public void keyPressed(KeyEvent key) {
		// TODO Auto-generated method stub
		if(key.getKeyCode()==KeyEvent.VK_ENTER) {
			control.send_message(textField.getText());
			textField.setText("");
			textField.requestFocus();
		}
	}
	@Override
	public void keyReleased(KeyEvent key) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent key) {
		// TODO Auto-generated method stub
		
	}
}
