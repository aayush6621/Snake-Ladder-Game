import javax.swing.*;
import java.awt.*;

abstract class CommonPlayer extends JPanel {
	JLabel title, currPos, diceValue, colour, snake, ladder, winner, six, outOfRange;
	JButton diceThrow;
	JTextField currPostf, diceValuetf, colourtf;
	JPanel panel[];
	JProgressBar bar;
	
	CommonPlayer() {
		title = new JLabel();
		currPos = new JLabel();
		diceValue = new JLabel();
		colour = new JLabel();
		snake = new JLabel();
		ladder = new JLabel();
		winner = new JLabel();
		six = new JLabel();
		outOfRange = new JLabel();
		diceThrow = new JButton();
		currPostf = new JTextField();
		diceValuetf = new JTextField();
		colourtf = new JTextField();
		bar = new JProgressBar(0, 400);
		panel = new JPanel[7];
		for(int i = 0; i < 7; i++) {
			panel[i] = new JPanel();
			panel[i].setBackground(Color.yellow);
			panel[i].setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		}
		
		title.setText("PLAYER - ");
		title.setFont(new Font("SansSerif", Font.BOLD, 30));
		panel[0].add(title);
		
		currPos.setText("CURRENT POSITION");
		currPos.setFont(new Font("SansSerif", Font.BOLD, 18));
		panel[1].add(currPos);
		
		currPostf.setText("000");
		currPostf.setPreferredSize(new Dimension(40, 30));
		currPostf.setMinimumSize(new Dimension(50, 50));
		currPostf.setMaximumSize(new Dimension(50, 50));
		currPostf.setFont(new Font("SansSerif", Font.BOLD, 18));
		currPostf.setEditable(false);
		panel[1].add(currPostf);
		
		diceValue.setText("DICE VALUE");
		diceValue.setFont(new Font("SansSerif", Font.BOLD, 18));
		panel[2].add(diceValue);
		
		diceValuetf.setText("000");
		diceValuetf.setPreferredSize(new Dimension(40, 30));
		diceValuetf.setMinimumSize(new Dimension(50, 50));
		diceValuetf.setMaximumSize(new Dimension(50, 50));
		diceValuetf.setFont(new Font("SansSerif", Font.BOLD, 18));
		diceValuetf.setEditable(false);
		panel[2].add(diceValuetf);
		
		colour.setText("COLOUR CODE");
		colour.setFont(new Font("SansSerif", Font.BOLD, 18));
		panel[3].add(colour);
		
		colourtf.setText("00");
		colourtf.setSize(50, 50);
		colourtf.setMinimumSize(new Dimension(50, 50));
		colourtf.setMaximumSize(new Dimension(50, 50));
		colourtf.setFont(new Font("SansSerif", Font.BOLD, 18));
		colourtf.setEditable(false);
		panel[3].add(colourtf);
		
		diceThrow.setText("THROW DICE");
		diceThrow.setSize(200, 50);
		diceThrow.setFont(new Font("SansSerif", Font.BOLD, 22));
		diceThrow.setFocusable(false);
		panel[4].add(diceThrow);
		
		bar.setValue(0);
		bar.setSize(200, 50);
		bar.setStringPainted(true);
		bar.setString("Processing ...");
		bar.setVisible(false);
		bar.setForeground(Color.red);
		panel[4].add(bar);
		
		snake.setText("Snake Encountered !!!");
		snake.setFont(new Font("SansSerif", Font.BOLD, 22));
		panel[5].add(snake);
		
		ladder.setText("Ladder Encountered !!!");
		ladder.setFont(new Font("SansSerif", Font.BOLD, 22));
		panel[5].add(ladder);
		
		six.setText("SIX ... Your Turn Again !!!");
		six.setFont(new Font("SansSerif", Font.BOLD, 22));
		panel[5].add(six);
		
		outOfRange.setText("Better Luck Next Time !!!");
		outOfRange.setFont(new Font("SansSerif", Font.BOLD, 22));
		panel[5].add(outOfRange);
		
		winner.setText("WINNER !!!");
		winner.setFont(new Font("SansSerif", Font.BOLD, 30));
		panel[6].add(winner);
	}
}