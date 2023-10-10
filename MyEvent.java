import java.awt.event.*;

class MyEvent implements WindowListener, ActionListener, KeyListener {
	MainFrame mf = null;
	OpenFrame of = null;
	NameFrame nf = null;
	Logic l;
	
	MyEvent() {
		this.l = new Logic(null);
	}
	
	void setMainFrameLogic() {
		this.l.mf = this.mf;
		this.mf.p1.g.l = this.l;
	}
	
	public void windowClosing(WindowEvent e) {
		if(e.getSource() == this.nf) {
			this.nf.dispose();
		}
		else if(e.getSource() == this.mf) {
			this.mf.p1.g.gameEnd = true;
			System.exit(0);
		}
	}
	public void windowClosed(WindowEvent e) {}
	public void windowOpened(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
	
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if(Character.isLowerCase(c)) e.setKeyChar(Character.toUpperCase(c));
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == of.sPlayer) {
			new NameFrame(1, this);
		}
		else if(e.getSource() == of.mPlayer) {
			new NameFrame(2, this);
		}
		else if(e.getSource() == of.exit) {
			System.exit(0);
		}
		else if(e.getSource() == of.info) {
			new Rules();
		}
		else if(e.getSource() == of.history) {
			l.showHistory();
		}
		else if(e.getSource() == nf.ok) {
			String s1 = this.nf.pf1.getText();
			String s2 = this.nf.pf2.getText();
			if(this.nf.pf1.getText().isBlank()) s1 = "PLAYER - 1";
			if(this.nf.pf2.getText().isBlank()) s2 = "PLAYER - 2";
			
			if(this.nf.mode == 1) {
				Game g = new Game(1, s1, s2);
				new MainFrame(this.of.name, new Player(s1, 1, g), new Player(s2, 2, g), this.of.me, 1);
				this.of.dispose();
				this.nf.dispose();
			}
			else if(this.nf.mode == 2) {
				Game g = new Game(2, s1, s2);
				new MainFrame(this.of.name, new Player(s1, 1, g), new Player(s2, 2, g), this.of.me, 2);
				this.of.dispose();
				this.nf.dispose();
			}
		}
		else if(e.getSource() == nf.cancel) {
			this.nf.dispose();
		}
		else if(e.getSource() == mf.player1.diceThrow) {
			this.mf.p1.action = true;
			this.mf.be.repaint();
			if(this.mf.player2.snake.isVisible()) l.hideSnake(this.mf.player2);
			if(this.mf.player2.ladder.isVisible()) l.hideLadder(this.mf.player2);
			if(this.mf.player1.six.isVisible()) l.hideSix(this.mf.player1);
			if(this.mf.player2.six.isVisible()) l.hideSix(this.mf.player2);
			if(this.mf.player2.outOfRange.isVisible()) l.hideOutOfRange(this.mf.player2);
		}
		else if(e.getSource() == mf.player2.diceThrow) {
			mf.p2.action = true;
			this.mf.be.repaint();
			if(this.mf.player1.snake.isVisible()) l.hideSnake(this.mf.player1);
			if(this.mf.player1.ladder.isVisible()) l.hideLadder(this.mf.player1);
			if(this.mf.player1.six.isVisible()) l.hideSix(this.mf.player1);
			if(this.mf.player2.six.isVisible()) l.hideSix(this.mf.player2);
			if(this.mf.player1.outOfRange.isVisible()) l.hideOutOfRange(this.mf.player1);
		}
		else if(e.getSource() == mf.home) {
			this.mf.dispose();
			this.mf.p1.g.gameEnd = true;
			this.mf = null;
			new OpenFrame(this.of.name, this);
		}
		else if(e.getSource() == mf.newGame) {
			l.newGame();
		}
		else if(e.getSource() == mf.history) {
			l.showHistory();
		}
	}
}