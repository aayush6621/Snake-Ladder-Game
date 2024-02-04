import java.io.IOException;

class Player extends Thread {
	Game g;
	int currPos = 0;
	int turn = 0;
	boolean action = false;
	boolean winStatus = false;
	
	Player(String name, int turn, Game g) {
		super(name);
		this.g = g;
		this.turn = turn;
		this.start();
	}
	
	public void run() {
		while(!g.gameStart) {
			if(this.turn == 1) g.gameStart = true;
			g.turn = 1;
		}
		
		while(!g.gameEnd) {
			g.diceThrow(this);
			if(this.currPos == 100) {
				this.winStatus = true;
				try {
					this.g.file.fw.write("\n\nWINNER : " + Thread.currentThread().getName() + " ..... !!!\n\n");
				} catch(IOException e) {
					System.out.println("Input Output Exception ...");
				}
				this.g.gameEnd = true;
				if(this.g.file.isOpen) this.g.file.closeFileWriter();
				this.g.l.hideBoth();
				this.g.l.winner(this.turn);
			}
		}
		
		System.out.println(Thread.currentThread().getName() + " terminated ...");
	}
}