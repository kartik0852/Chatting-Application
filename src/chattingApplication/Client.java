package chattingApplication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Client implements ActionListener{

	JTextField text1;
	static JPanel a1;
	static Box vertical = Box.createVerticalBox();
	static DataOutputStream dout;
	static JFrame f = new JFrame();
	
	public Client() {
		
		f.setLayout(null); 
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(7,94,84));
		p1.setBounds(0, 0, 500, 70);
		p1.setLayout(null);
		f.add(p1); 
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/left arrow.png"));
		Image i2 = i1.getImage().getScaledInstance(25,  25, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel back = new JLabel(i3);
		back.setBounds(5, 20, 25, 25);
		p1.add(back);
		
		
		back.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ae) {
				System.exit(0);
			}
		});
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/man2.png"));
		Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel profile = new JLabel(i6);
		profile.setBounds(40, 10, 50, 50);
		p1.add(profile);
		
		ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
		Image i8 = i7.getImage().getScaledInstance(35,  35, Image.SCALE_DEFAULT);
		ImageIcon i9 = new ImageIcon(i8);
		JLabel video = new JLabel(i9);
		video.setBounds(350, 10, 50, 50);
		p1.add(video);
		
		ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone-call.png"));
		Image i11 = i10.getImage().getScaledInstance(30,  30, Image.SCALE_DEFAULT);
		ImageIcon i12 = new ImageIcon(i11);
		JLabel phone = new JLabel(i12);
		phone.setBounds(400, 10, 50, 50);
		p1.add(phone);
		
		ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3dot.png"));
		Image i14 = i13.getImage().getScaledInstance(40,  40, Image.SCALE_DEFAULT);
		ImageIcon i15 = new ImageIcon(i14);
		JLabel morevert = new JLabel(i15);
		morevert.setBounds(440, 10, 50, 50);
		p1.add(morevert);
		
		JLabel name = new JLabel("Server");
		name.setBounds(110, 15, 100, 18);
		name.setForeground(Color.WHITE);
		name.setFont(new Font("SANS_SERIF", Font.BOLD, 18));
		p1.add(name);
		
		JLabel status = new JLabel("Online");
		status.setBounds(110, 40, 100, 18);
		status.setForeground(Color.WHITE);
		status.setFont(new Font("SANS_SERIF", Font.PLAIN, 14));
		p1.add(status);
		
		
		a1 = new JPanel();
		a1.setBounds(0, 70, 500,600);
		a1.setForeground(Color.LIGHT_GRAY);
//		a1.setLayout(null);
		
//		ImageIcon aIcon = new ImageIcon(ClassLoader.getSystemResource("icons/peakpx.png"));
//		Image image = aIcon.getImage().getScaledInstance(500, 600, Image.SCALE_DEFAULT);
//		ImageIcon aIcon2 = new ImageIcon(image);
//		JLabel backk = new JLabel(aIcon2);
//		backk.setBounds(0, 70, 500, 600);
//		a1.add(backk);
		f.add(a1);
		
		text1 = new JTextField();
		text1.setBounds(10, 580, 330, 40);
		text1.setFont(new Font("SAN_SERIF",Font.PLAIN, 16));
		f.add(text1);
		
		JButton button = new JButton("Send");
		button.setBounds(350,580,130, 40);
		button.setBackground(new Color(7,94,84));
		button.setFont(new Font("SAN_SERIF",Font.BOLD, 16));
		button.setForeground(Color.WHITE);
		button.addActionListener(this);
		f.add(button);
		
		f.setSize(500,670);
		f.setLocation(10,10);
//		setUndecorated(true);
		f.getContentPane().setBackground(Color.WHITE);
		f.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
		String out = text1.getText();
			
		JPanel p2 = formatLabel(out);
		
		a1.setLayout(new BorderLayout());
		
		JPanel right = new JPanel(new BorderLayout());
		right.add(p2, BorderLayout.LINE_END);
		vertical.add(right);
		vertical.add(Box.createVerticalStrut(15));
		
		a1.add(vertical, BorderLayout.PAGE_START);
		
		dout.writeUTF(out);
		
		text1.setText("");
		
//		repaint();
		f.invalidate();
		f.validate();
		
		
//		System.out.println(out);
		}
		catch (Exception ee) {
			// TODO: handle exception
			ee.printStackTrace();
		}
	}
	
	public static JPanel formatLabel(String out) {
		JPanel panel = new JPanel();
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel output = new JLabel("<html><p style=\"width:180px\">"+ out +"</p></html>");
		output.setFont(new Font("Tahoma", Font.PLAIN, 16));
		output.setBackground(new Color(37, 211,102));
		output.setOpaque(true);
		output.setBorder(new EmptyBorder(15, 15, 15, 15));
		
		panel.add(output);
		
		Calendar calendar = Calendar.getInstance(); 
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		
		JLabel time = new JLabel();
		time.setText(sdf.format(calendar.getTime()));
		
		panel.add(time);
		
		return panel;
	}
	
}
















