import java.io.*;
import java.net.URL;
import java.util.Date;

class MyFile {
	boolean close;
	FileWriter fw;
	FileReader fr;
	BufferedReader br;
	URL file_url;
	File f;
	boolean isOpen = false;
	
	MyFile() throws IOException {
		file_url = getClass().getResource("Demo.txt");
		this.fw = null;
		this.fr = null;
	}
	
	void timeStamp(int mode, String s1, String s2) {
		try {
			this.fw.write("New Game : " + (new Date()).toString() + "\nGame Type : ");
			if(mode == 1) this.fw.write("Single Player\n");
			else if(mode == 2) this.fw.write("Two Player\n");
			this.fw.write("\nBlue Counter : " + s1);
			this.fw.write("\nGreen Counter : " + s2 + "\n");
		} catch(IOException e) {
			System.out.println("Input Output Exception ...");
		}
	}
	
	void createFileWriter() {
		this.isOpen = true;
		try {
			this.fw = new FileWriter("Demo.txt", true);
		} catch(IOException e) {
			System.out.println("Input Output Exception ...");
		}
	}
	
	void createFileReader() {
		try {
			this.fr = new FileReader("Demo.txt");
			// this.br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("Demo.txt")));
		} catch(Exception e) {
			System.out.println("Input Output Exception ...");
		}
	}
	
	void createFileReader(String name) {
		try {
			// this.fr = new FileReader(rules_url.getFile());
			this.br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(name)));
		} catch(Exception e) {
			System.out.println("Input Output Exception ...");
		}
	}
	
	void closeFileWriter() {
		this.isOpen = false;
		try {
			int i = 0;
			this.fw.write("\n\n");
			while(i < 100) {
				this.fw.write("-");
				i++;
			}
			this.fw.write("\n\n");
			this.fw.close();
			System.out.println("File Writer closed ...");
		} catch(IOException e) {
			System.out.println("Input Output Exception ...");
		}
	}
	
	void closeFileReader() {
		try {
			this.fr.close();
			System.out.println("File Reader closed ...");
		} catch(IOException e) {
			System.out.println("Input Output Exception ...");
		}
	}
	
	void closeBufferedReader() {
		try {
			this.br.close();
			System.out.println("Buffered Reader closed ...");
		} catch(Exception e) {
			System.out.println("Input Output Exception ...");
		}
	}
}