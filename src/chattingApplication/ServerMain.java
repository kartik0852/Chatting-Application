package chattingApplication;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JPanel;

public class ServerMain extends Server {
	
	public static void main(String[] args) {
		Server server = new Server();
		
		try {
			
			ServerSocket skt = new ServerSocket(6001);
			while(true) {
				Socket s = skt.accept();
				DataInputStream dis = new DataInputStream(s.getInputStream());
				dout = new DataOutputStream(s.getOutputStream());
				
				while(true) {
					String msg = dis.readUTF();
					JPanel panel = formatLabel(msg);
					
					JPanel left = new JPanel(new BorderLayout());
					left.add(panel, BorderLayout.LINE_START);
					vertical.add(left);
					f.validate();
					
				}
			}
			
		} catch (Exception e) {
			// TODO: handl exception
			e.printStackTrace();
		}
	}
}
