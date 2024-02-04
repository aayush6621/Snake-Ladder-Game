import java.awt.*;

class Player2 extends CommonPlayer {
	Player2(int width, MyEvent me, int mode) {
		if(mode == 1) this.title.setText("SYSTEM");
		else if(mode == 2) this.title.setText(this.title.getText() + "2");
		this.colourtf.setBackground(Color.green);
		this.colourtf.setForeground(Color.green);
		this.diceThrow.addActionListener(me);
		this.diceThrow.setVisible(false);
		this.snake.setVisible(false);
		this.ladder.setVisible(false);
		this.winner.setVisible(false);
		this.six.setVisible(false);
		this.outOfRange.setVisible(false);
		
		int i = 0;
		for(i = 0; i < 7; i++) {
			panel[i].setPreferredSize(new Dimension(width, 70));
			this.add(this.panel[i]);
		}
	}
}