import javax.swing.*;
import java.awt.*;

class NameFrame extends JFrame {
	JPanel panel1, panel2, panel3;
	JLabel pLabel1, pLabel2;
	JTextField pf1, pf2, pc1, pc2;
	JButton ok, cancel;
	MyEvent me;
	int mode;
	
	NameFrame(int mode, MyEvent me) {
		super("Enter name of players");
		this.setSize(500, 200);
		this.setLayout(new GridLayout(3, 1));
		this.setLocationRelativeTo(null);
		
		this.mode = mode;
		this.me = me;
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		pLabel1 = new JLabel();
		pLabel2 = new JLabel();
		pf1 = new JTextField();
		pf2 = new JTextField();
		pc1 = new JTextField();
		pc2 = new JTextField();
		ok = new JButton();
		cancel = new JButton();
		
		this.me.nf = this;
		
		panel1.setBackground(Color.yellow);
		panel2.setBackground(Color.yellow);
		panel3.setBackground(Color.yellow);
		
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
		
		pLabel1.setText("PLAYER - 1 NAME");
		pLabel1.setFont(new Font("SansSerif", Font.BOLD, 22));
		pLabel2.setText("PLAYER - 2 NAME");
		pLabel2.setFont(new Font("SansSerif", Font.BOLD, 22));
		
		pc1.setPreferredSize(new Dimension(30 ,30));
		pc1.setEditable(false);
		pc1.setBackground(Color.blue);
		pc2.setPreferredSize(new Dimension(30 ,30));
		pc2.setEditable(false);
		pc2.setBackground(Color.green);
		
		pf1.setPreferredSize(new Dimension(150, 30));
		pf1.setFont(new Font("SansSerif", Font.BOLD, 22));
		pf1.addKeyListener(this.me);
		pf2.setPreferredSize(new Dimension(150, 30));
		pf2.setFont(new Font("SansSerif", Font.BOLD, 22));
		pf2.addKeyListener(this.me);
		if(mode == 1) {
			pf2.setText("SYSTEM");
			pf2.setEditable(false);
		}
		
		cancel.setText("CANCEL");
		cancel.setFont(new Font("SansSerif", Font.BOLD, 22));
		cancel.setSize(cancel.getPreferredSize().width, cancel.getPreferredSize().height);
		cancel.setFocusable(false);
		cancel.addActionListener(this.me);
		
		ok.setText("START GAME");
		ok.setFont(new Font("SansSerif", Font.BOLD, 22));
		ok.setSize(ok.getPreferredSize().width, ok.getPreferredSize().height);
		ok.setFocusable(false);
		ok.addActionListener(this.me);
		
		panel1.add(pc1);
		panel1.add(pLabel1);
		panel1.add(pf1);
		panel2.add(pc2);
		panel2.add(pLabel2);
		panel2.add(pf2);
		panel3.add(cancel);
		panel3.add(ok);
		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.CENTER);
		this.add(panel3, BorderLayout.SOUTH);
		this.addWindowListener(this.me);
		this.setVisible(true);
	}
}