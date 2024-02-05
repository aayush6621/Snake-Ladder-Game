import javax.swing.*;
import java.awt.*;
import java.net.URL;

class OpenFrame extends JFrame {
	JButton sPlayer, mPlayer, exit, info, history;
	JLabel background;
	Dimension d;
	Image img;
	ImageIcon bg;
	MyEvent me;
	String name;
	URL image_url;
	
	OpenFrame(String name, MyEvent me) {
		super(name);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		this.name = name;
		this.me = me;
		this.me.of = this;
		sPlayer = new JButton();
		mPlayer = new JButton();
		exit = new JButton();
		info = new JButton();
		history = new JButton();
		d = Toolkit.getDefaultToolkit().getScreenSize();
		image_url = Main.class.getResource("background.png");
		// bg = new ImageIcon(image_url);
		bg = new ImageIcon("../resources/background.png");
		img = bg.getImage();
		img = img.getScaledInstance(d.width, d.height, java.awt.Image.SCALE_SMOOTH);
		bg = new ImageIcon(img);
		background = new JLabel(bg);
		
		background.setBounds(0, 0, d.width, d.height);
		
		sPlayer.setText("SINGLE PLAYER");
		sPlayer.setFont(new Font("SansSerif", Font.BOLD, 22));
		sPlayer.setBounds((d.width - sPlayer.getPreferredSize().width) / 2, (d.height / 2) - sPlayer.getPreferredSize().height - 50, sPlayer.getPreferredSize().width, sPlayer.getPreferredSize().height);
		sPlayer.setFocusable(false);
		sPlayer.addActionListener(this.me);
		
		mPlayer.setText("TWO PLAYER");
		mPlayer.setFont(new Font("SansSerif", Font.BOLD, 22));
		mPlayer.setBounds((d.width - sPlayer.getPreferredSize().width) / 2, (d.height / 2) + sPlayer.getPreferredSize().height + 50, sPlayer.getPreferredSize().width, sPlayer.getPreferredSize().height);
		mPlayer.setFocusable(false);
		mPlayer.addActionListener(this.me);
		
		exit.setText("EXIT");
		exit.setFont(new Font("SansSerif", Font.BOLD, 22));
		history.setText("HISTORY");
		history.setFont(new Font("SansSerif", Font.BOLD, 22));
		
		exit.setBounds(d.width - history.getPreferredSize().width, 0, history.getPreferredSize().width, history.getPreferredSize().height);
		exit.setFocusable(false);
		exit.addActionListener(this.me);
		
		history.setBounds(exit.getX(), exit.getHeight() + 50, exit.getWidth(), exit.getHeight());
		history.setFocusable(false);
		history.addActionListener(this.me);
		
		info.setText("HOW TO PLAY ?");
		info.setFont(new Font("SansSerif", Font.BOLD, 22));
		info.setBounds(0, 0, info.getPreferredSize().width, exit.getPreferredSize().height);
		info.setFocusable(false);
		info.addActionListener(this.me);
		
		this.add(sPlayer);
		this.add(mPlayer);
		this.add(exit);
		this.add(history);
		this.add(info);
		this.add(background);
		this.setIconImage(bg.getImage());
		this.setVisible(true);
	}
}