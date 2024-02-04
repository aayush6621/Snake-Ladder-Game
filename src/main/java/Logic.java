import javax.swing.*;

class Logic {
	MainFrame mf;
	
	Logic(MainFrame mf) {
		this.mf = mf;
	}
	
	void hideBoth() {
		this.mf.player1.diceThrow.setVisible(false);
		this.mf.player2.diceThrow.setVisible(false);
	}
	
	void changeVisibility(int playerNum) {
		if(this.mf.mode != 1) {
			if(playerNum == 1) {
				this.mf.player1.diceThrow.setVisible(true);
				this.mf.player2.diceThrow.setVisible(false);
			}
			else if(playerNum == 2) {
				this.mf.player2.diceThrow.setVisible(true);
				this.mf.player1.diceThrow.setVisible(false);
			}
		}
		else {
			if(playerNum == 1) {
				this.mf.player1.diceThrow.setVisible(true);
				this.mf.player2.bar.setVisible(false);
			}
			else if(playerNum == 2) {
				this.mf.player1.diceThrow.setVisible(false);
				this.mf.player2.bar.setVisible(true);
				this.systemTurn();
			}
			if(this.mf.player2.six.isVisible()) this.hideSix(this.mf.player2);
		}
	}
	
	void systemTurn() {
		this.mf.be.repaint();
		if(this.mf.player1.snake.isVisible()) this.hideSnake(this.mf.player1);
		if(this.mf.player1.ladder.isVisible()) this.hideLadder(this.mf.player1);
		if(this.mf.player1.six.isVisible()) this.hideSix(this.mf.player1);
		if(this.mf.player1.outOfRange.isVisible()) this.hideOutOfRange(this.mf.player1);
		
		int count = 0;
		while(count <= 400) {
			try {
				this.mf.player2.bar.setValue(count);
				Thread.sleep(50);
			} catch(InterruptedException e) {
				System.out.println("Thread Interrupted ...");
			  }
			count += 10;
		}
		this.mf.p2.action = true;
	}
	
	void changeTextfields(int playerNum) {
		if(playerNum == 1) {
			this.mf.player1.currPostf.setText("" + this.mf.p1.currPos);
			this.mf.player1.diceValuetf.setText("" + this.mf.p1.g.diceValue);
		}
		else if(playerNum == 2) {
			this.mf.player2.currPostf.setText("" + this.mf.p2.currPos);
			this.mf.player2.diceValuetf.setText("" + this.mf.p2.g.diceValue);
		}
	}
	
	void snakeEncountered(int playerNum) {
		if(playerNum == 1) {
			this.mf.player1.snake.setVisible(true);
		}
		else if(playerNum == 2) {
			this.mf.player2.snake.setVisible(true);
		}
	}
	
	void ladderEncountered(int playerNum) {
		if(playerNum == 1) {
			this.mf.player1.ladder.setVisible(true);
		}
		else if(playerNum == 2) {
			this.mf.player2.ladder.setVisible(true);
		}
	}
	
	void sixEncountered(int playerNum) {
		if(playerNum == 1) {
			this.mf.player1.six.setVisible(true);
		}
		else if(playerNum == 2) {
			this.mf.player2.six.setVisible(true);
		}
	}
	
	void rangeExceeded(int playerNum) {
		if(playerNum == 1) {
			this.mf.player1.outOfRange.setVisible(true);
		}
		else if(playerNum == 2) {
			this.mf.player2.outOfRange.setVisible(true);
		}
	}
	
	void hideSnake(Player1 p) {
		p.snake.setVisible(false);
	}
	
	void hideSnake(Player2 p) {
		p.snake.setVisible(false);
	}
	
	void hideLadder(Player1 p) {
		p.ladder.setVisible(false);
	}
	
	void hideLadder(Player2 p) {
		p.ladder.setVisible(false);
	}
	
	void hideSix(Player1 p) {
		p.six.setVisible(false);
	}
	
	void hideSix(Player2 p) {
		p.six.setVisible(false);
	}
	
	void hideOutOfRange(Player1 p) {
		p.outOfRange.setVisible(false);
	}
	
	void hideOutOfRange(Player2 p) {
		p.outOfRange.setVisible(false);
	}
	
	void winner(int playerNum) {
		if(playerNum == 1) {
			this.mf.player1.winner.setVisible(true);
			this.hideSix(this.mf.player1);
		}
		else if(playerNum == 2) {
			this.mf.player2.winner.setVisible(true);
			this.hideSix(this.mf.player2);
		}
		this.mf.player2.bar.setVisible(false);
		this.showHistoryButton();
	}
	
	/*void newPosition(int playerNum) {
		if(playerNum == 1) {
			this.mf.board.label[this.mf.p1.currPos - 1].setIcon(this.mf.board.blue);
			this.mf.board.label[this.mf.p1.currPos - 1].setHorizontalTextPosition(JLabel.CENTER);
			this.mf.board.label[this.mf.p1.currPos - 1].setVerticalTextPosition(JLabel.TOP);
		}
		else if(playerNum == 2) {
			this.mf.board.label[this.mf.p2.currPos - 1].setIcon(this.mf.board.green);
			this.mf.board.label[this.mf.p2.currPos - 1].setHorizontalTextPosition(JLabel.CENTER);
			this.mf.board.label[this.mf.p2.currPos - 1].setVerticalTextPosition(JLabel.TOP);
		}
	}*/
	
	void newPosition(int playerNum) {
		if(this.mf.p1.currPos == this.mf.p2.currPos) {
			this.mf.board.label[this.mf.p1.currPos - 1].setIcon(this.mf.board.combined);
			this.mf.board.label[this.mf.p1.currPos - 1].setHorizontalTextPosition(JLabel.CENTER);
			this.mf.board.label[this.mf.p1.currPos - 1].setVerticalTextPosition(JLabel.TOP);
		}
		else if(playerNum == 1) {
			this.mf.board.label[this.mf.p1.currPos - 1].setIcon(this.mf.board.blue);
			this.mf.board.label[this.mf.p1.currPos - 1].setHorizontalTextPosition(JLabel.CENTER);
			this.mf.board.label[this.mf.p1.currPos - 1].setVerticalTextPosition(JLabel.TOP);
		}
		else if(playerNum == 2) {
			this.mf.board.label[this.mf.p2.currPos - 1].setIcon(this.mf.board.green);
			this.mf.board.label[this.mf.p2.currPos - 1].setHorizontalTextPosition(JLabel.CENTER);
			this.mf.board.label[this.mf.p2.currPos - 1].setVerticalTextPosition(JLabel.TOP);
		}
	}
	
	void removeOld(int i, int playerNum) {
		this.mf.board.label[i - 1].setIcon(null);
		if(playerNum == this.mf.p1.turn) {
			if(this.mf.p2.currPos == i) {
				this.mf.board.label[this.mf.p2.currPos - 1].setIcon(this.mf.board.green);
				this.mf.board.label[this.mf.p2.currPos - 1].setHorizontalTextPosition(JLabel.CENTER);
				this.mf.board.label[this.mf.p2.currPos - 1].setVerticalTextPosition(JLabel.TOP);
			}
		}
		else if(playerNum == this.mf.p2.turn) {
			if(this.mf.p1.currPos == i) {
				this.mf.board.label[this.mf.p1.currPos - 1].setIcon(this.mf.board.blue);
				this.mf.board.label[this.mf.p1.currPos - 1].setHorizontalTextPosition(JLabel.CENTER);
				this.mf.board.label[this.mf.p1.currPos - 1].setVerticalTextPosition(JLabel.TOP);
			}
		}
	}
	
	void interruptP1() {
		this.mf.p1.interrupt();
	}
	
	void interruptP2() {
		this.mf.p2.interrupt();
	}
	
	void newGame() {
		this.mf.p1.g.gameEnd = true;
		
		// Player op1 = this.mf.p1;
		// Player op2 = this.mf.p2;
		//System.out.println("P1 : " + op1.isAlive());
		//System.out.println("P2 : " + op2.isAlive());
		
		Game g = new Game(this.mf.mode, this.mf.p1Name, this.mf.p2Name);
		// Player p1 = new Player("Player - 1", 1, g);
		// Player p2 = new Player("Player - 2", 2, g);
		this.mf.dispose();
		if(this.mf.mode == 1) new MainFrame("Snake Ladder Game", new Player(this.mf.p1Name, 1, g), new Player(this.mf.p2Name, 2, g), this.mf.me, this.mf.mode);
		else if(this.mf.mode == 2) new MainFrame("Snake Ladder Game", new Player(this.mf.p1Name, 1, g), new Player(this.mf.p2Name, 2, g), this.mf.me, this.mf.mode);
	}
	
	void showHistory() {
		new Info();
	}
	
	void showHistoryButton() {
		this.mf.history.setVisible(true);
	}
}