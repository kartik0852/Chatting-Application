package chattingApplication;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.Box;
import javax.swing.JPanel;

public class ClientMain extends Client {
	
	public static void main(String[] args) {
		new Client();
		try {
			
			Socket s = new Socket("127.0.0.1", 6001);
			DataInputStream dis = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());
			
			while(true) {
				
				a1.setLayout(new BorderLayout());
				String msg = dis.readUTF();
				JPanel panel = formatLabel(msg);
				
				JPanel left = new JPanel(new BorderLayout());
				left.add(panel, BorderLayout.LINE_START);
				vertical.add(left);
				
				vertical.add(Box.createVerticalStrut(15));
				a1.add(vertical, BorderLayout.PAGE_START);
				
				f.validate();
			}
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
