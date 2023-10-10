import javax.swing.*;
import java.awt.*;
import java.net.URL;

class MainFrame extends JFrame {
	Board board;
	BoardElements be;
	Player1 player1;
	Player2 player2;
	Player p1, p2;
	JPanel main, block[];
	JButton newGame, history, home;
	JLayeredPane layeredpane;
	Dimension d;
	MyEvent me;
	ImageIcon hIcon, nIcon;
	Image img;
	URL image_url;
	int mode;
	String p1Name, p2Name;
	
	MainFrame(String name, Player p1, Player p2, MyEvent me, int mode) {
		super(name);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.getContentPane().setBackground(Color.yellow);
		this.setLayout(null);
		
		this.mode = mode;
		this.p1 = p1;
		this.p2 = p2;
		this.me = me;
		this.me.mf = this;
		this.me.setMainFrameLogic();
		this.p1Name = p1.getName();
		this.p2Name = p2.getName();
		
		d = Toolkit.getDefaultToolkit().getScreenSize();
		main = new JPanel();
		history = new JButton();
		newGame = new JButton();
		home = new JButton();
		board = new Board(this);
		block = new JPanel[100];
		be = new BoardElements(this.board);
		layeredpane = getLayeredPane();
		image_url = Main.class.getResource("home.png");
		hIcon = new ImageIcon(image_url);
		img = hIcon.getImage();
		img = img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		hIcon = new ImageIcon(img);
		image_url = Main.class.getResource("reset.jpeg");
		nIcon = new ImageIcon(image_url);
		img = nIcon.getImage();
		img = img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		nIcon = new ImageIcon(img);
		
		main.setBounds(0, 0, d.width, d.height - 65);
		main.setBackground(Color.blue);
		main.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		main.setOpaque(false);
		
		board.setPreferredSize(new Dimension(main.getHeight(), main.getHeight()));
		board.setBackground(new Color(240, 0, 120));
		board.setBorder(BorderFactory.createLineBorder(new Color(240, 0, 120), 2));
		
		player1 = new Player1((main.getWidth() - main.getHeight()) / 2, this.me, this.mode);
		player1.setPreferredSize(new Dimension((main.getWidth() - main.getHeight()) / 2, main.getHeight()));
		player1.setBackground(Color.yellow);
		player1.title.setToolTipText("NAME : " + this.p1Name);
		player1.setOpaque(false);
		
		player2 = new Player2((main.getWidth() - main.getHeight()) / 2, this.me, this.mode);
		player2.setPreferredSize(new Dimension((main.getWidth() - main.getHeight()) / 2, main.getHeight()));
		player2.setBackground(Color.yellow);
		player2.title.setToolTipText("NAME : " + this.p2Name);
		player2.setOpaque(false);
		
		be.setBounds(player1.getPreferredSize().width, 0, board.getPreferredSize().width, board.getPreferredSize().width);
		be.setVisible(true);
		be.setOpaque(false);
		
		main.add(player1);
		main.add(board);
		main.add(player2);
		
		layeredpane.add(be, 1);
		layeredpane.add(main, 2);
		
		home.setFont(new Font("SansSerif", Font.BOLD, 22));
		home.setBounds((player1.getPreferredSize().width - (50 + 50 + 20)) / 2, (main.getPreferredSize().height - 100), 50, 50);
		home.setFocusable(false);
		home.setIcon(hIcon);
		home.setToolTipText("GO TO HOME");
		home.addActionListener(this.me);
		
		newGame.setFont(new Font("SansSerif", Font.BOLD, 22));
		newGame.setBounds(home.getX() + home.getWidth() + 20, home.getY(), home.getWidth(), home.getHeight());
		newGame.setFocusable(false);
		newGame.setIcon(nIcon);
		newGame.setToolTipText("START NEW GAME");
		newGame.addActionListener(this.me);
		
		history.setText("HISTORY");
		history.setFont(new Font("SansSerif", Font.BOLD, 22));
		history.setBounds(player1.getPreferredSize().width + board.getPreferredSize().width + (player2.getPreferredSize().width - 200) / 2, (main.getPreferredSize().height - 100), 200, 40);
		history.setFocusable(false);
		history.setToolTipText("SHOW GAME HISTORY");
		history.setVisible(false);
		history.addActionListener(this.me);
		
		this.add(newGame);
		this.add(home);
		this.add(history);
		this.addWindowListener(this.me);
		this.setIconImage(this.me.of.bg.getImage());
		this.setVisible(true);
	}
}