import java.io.IOException;

class Game {
	int board[][] = {{6, 78}, {28, 70}, {99, 1}, {75, 97}, {88, 46}, {45, 14}};
	boolean playing = false;
	boolean gameStart = false;
	boolean gameEnd = false;
	int diceValue = 0;
	int newPos = 0;
	int turn = 0;
	Logic l;
	MyFile file;
	
	Game(int mode, String s1, String s2) {
		System.out.println("New Game ...");
		try {
			this.file = new MyFile();
			this.file.createFileWriter();
			this.file.timeStamp(mode, s1, s2);
		} catch(IOException e) {
			System.out.println("Input Output Exception ...");
		}
	}
	
	synchronized void diceThrow(Player p) {
		try {
			if(this.playing) {
				wait();
			}
			else {
				this.playing = true;
				if(this.turn == p.turn && !gameEnd) {
					while(!p.action) {
						System.out.print("");
						if(this.gameEnd) {
							if(p.turn == 1) this.l.interruptP2();
							else if(p.turn == 2) this.l.interruptP1();
							file.closeFileWriter();
							this.l.showHistoryButton();
							return;
						}
					}
					System.out.println("\n" + Thread.currentThread().getName() + " : Old Position = " + p.currPos);
					file.fw.write("\n" + Thread.currentThread().getName() + " : Old Position = " + p.currPos + "\n");
					
					this.diceValue = (int)(6 * Math.random()) + 1;
					if(this.diceValue == 6) {
						this.l.sixEncountered(p.turn);
					}
					System.out.println(Thread.currentThread().getName() + " : Dice Value = " + this.diceValue);
					file.fw.write(Thread.currentThread().getName() + " : Dice Value = " + this.diceValue + "\n");
					
					this.newPos = p.currPos + this.diceValue;
					System.out.println(Thread.currentThread().getName() + " : Position after dice throw = " + this.newPos);
					file.fw.write(Thread.currentThread().getName() + " : Position after dice throw = " + this.newPos + "\n");
					
					this.makeAmove(p.turn);
					if(this.newPos <= 100) {
						if(p.currPos > 0) this.l.removeOld(p.currPos, p.turn);
						p.currPos = this.newPos;
						this.l.newPosition(p.turn);
					}
					else {
						this.l.rangeExceeded(p.turn);
					}
					System.out.println(Thread.currentThread().getName() + " : New Position = " + p.currPos);
					file.fw.write(Thread.currentThread().getName() + " : New Position = " + p.currPos + "\n");
					
					this.l.changeTextfields(p.turn);
					p.action = false;
					if(this.diceValue != 6) {
						if(p.turn == 1) this.turn = 2;
						else if(p.turn == 2) this.turn = 1;
					}
					this.l.changeVisibility(this.turn);
				}
				this.playing = false;
			}
			notify();
		} catch(InterruptedException e) {
			System.out.println("Interrupted ... !");
		} catch(IOException e) {
			System.out.println("Input Output Exception ... !");
		}
	}
	
	synchronized void makeAmove(int turn) {
		try {
			for(int i = 0; i < 6; i++) {
				if(this.newPos == this.board[i][0]) {
					if(this.board[i][0] > this.board[i][1]) {
						System.out.println(Thread.currentThread().getName() + " : Snake Encountered ... !");
						file.fw.write(Thread.currentThread().getName() + " : Snake Encountered ... !" + "\n");
						
						this.l.snakeEncountered(turn);
					}
					else if(this.board[i][0] < this.board[i][1]) {
						System.out.println(Thread.currentThread().getName() + " : Ladder Encountered ... !");
						file.fw.write(Thread.currentThread().getName() + " : Ladder Encountered ... !" + "\n");
						
						this.l.ladderEncountered(turn);
					}
					this.newPos = this.board[i][1];
				}
			}
		} catch(IOException e) {
			System.out.println("Input Output Exception ...");
		}
	}
}