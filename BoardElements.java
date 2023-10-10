import javax.swing.*;
import java.awt.*;

class BoardElements extends JPanel {
	Board board;
	
	BoardElements(Board board) {
		this.board = board;
	}
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(5));
		for(int i = 0; i < 6; i++) {
			int a = this.board.mf.p1.g.board[i][0];
			int b = this.board.mf.p1.g.board[i][1];
			if(a < b) {
				g2d.setColor(Color.green);
			}
			else {
				g2d.setColor(Color.red);
			}
			int x1 = this.board.block[a - 1].getX() + 30;
			int x2 = this.board.block[b - 1].getX() + 30;
			int y1 = this.board.block[a - 1].getY() + 30;
			int y2 = this.board.block[b - 1].getY() + 30;
			g2d.drawLine(x1, y1, x2, y2);
		}
	}
}