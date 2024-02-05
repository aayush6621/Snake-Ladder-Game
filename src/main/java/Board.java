import javax.swing.*;
import java.awt.*;
import java.net.URL;

class Board extends JPanel {
	MainFrame mf;
	JPanel block[];
	JLabel label[];
	ImageIcon blue, green, combined;
	Image img;
	URL image_url;
	
	Board(MainFrame mf) {
		this.mf = mf;
		GridBagLayout gbag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		this.setLayout(gbag);
		
		image_url = Main.class.getResource(".blue.png");
		// blue = new ImageIcon(image_url);
		blue = new ImageIcon("../resources/blue.png");
		image_url = Main.class.getResource("green.png");
		// green = new ImageIcon(image_url);
		green = new ImageIcon("../resources/green.png");
		image_url = Main.class.getResource("combined.png");
		// combined = new ImageIcon(image_url);
		combined = new ImageIcon("../resources/combined.png");
		img = blue.getImage();
		img = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		blue = new ImageIcon(img);
		img = green.getImage();
		img = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		green = new ImageIcon(img);
		img = combined.getImage();
		img = img.getScaledInstance(40, 20, java.awt.Image.SCALE_SMOOTH);
		combined = new ImageIcon(img);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;
		block = new JPanel[100];
		label = new JLabel[100];
		Font font = new Font("SansSerif", Font.BOLD, 20);
		
		int i = 99;
		int x = 0;
		for(int j = 0; j < 10; j++) {
			if(j % 2 == 0) {
				x = 0;
				for(;x < 10;i--) {
					gbc.gridx = x;
					gbc.gridy = j;
					x++;
					block[i] = new JPanel();
					label[i] = new JLabel("" + (i + 1));
					label[i].setFont(font);
					block[i].setBackground(Color.pink);
					block[i].setBorder(BorderFactory.createLineBorder(new Color(240, 0, 120), 2));
					block[i].setLayout(new FlowLayout(FlowLayout.CENTER));
					block[i].add(label[i]);
					this.add(block[i], gbc);
				}
			}
			else {
				x = 9;
				for(;x >= 0;i--) {
					gbc.gridx = x;
					gbc.gridy = j;
					x--;
					block[i] = new JPanel();
					label[i] = new JLabel("" + (i + 1));
					label[i].setFont(font);
					block[i].setBackground(Color.pink);
					block[i].setBorder(BorderFactory.createLineBorder(new Color(240, 0, 120), 2));
					block[i].setLayout(new FlowLayout(FlowLayout.CENTER));
					block[i].add(label[i]);
					this.add(block[i], gbc);
				}
			}
		}
		
		for(i = 0; i < 100; i++) {
			block[i].setPreferredSize(new Dimension(block[i].getPreferredSize().width, block[i].getPreferredSize().height));
			block[i].setMinimumSize(new Dimension(block[i].getPreferredSize().width, block[i].getPreferredSize().height));
			block[i].setMaximumSize(new Dimension(block[i].getPreferredSize().width, block[i].getPreferredSize().height));
		}
		//...
	}
}