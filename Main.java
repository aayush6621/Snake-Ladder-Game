import java.io.*;

class Main {
	public static void main(String args[]) {
		MyEvent me = new MyEvent();
		try {
			(new FileWriter("Demo.txt", true)).close();
		} catch(IOException e) {
			System.out.println("Input Output Exception ...");
		}
		new OpenFrame("SNAKE AND LADDER GAME", me);
	}
}