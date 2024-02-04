import java.awt.*;

class Player1 extends CommonPlayer {
	Player1(int width, MyEvent me, int mode) {
		if(mode == 1) this.title.setText("PLAYER");
		else if(mode == 2) this.title.setText(this.title.getText() + "1");
		this.colourtf.setBackground(Color.blue);
		this.colourtf.setForeground(Color.blue);
		this.diceThrow.addActionListener(me);
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