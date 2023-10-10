import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.io.*;
import java.net.URL;

class Rules extends JFrame {
	JScrollPane scrollpane;
	JTextPane textpane;
	Document doc;
	SimpleAttributeSet sat;
	MyFile file;
	BufferedReader br;
	
	Rules() {
		try {
			this.setTitle("GAME RULES");
			this.setSize(750, 500);
			this.setLocationRelativeTo(null);
			
			textpane = new JTextPane();
			scrollpane = new JScrollPane(textpane);
			sat = new SimpleAttributeSet();
			sat.addAttribute(StyleConstants.Foreground, Color.blue);
			StyleConstants.setFontSize(sat, 18);
			doc = textpane.getStyledDocument();
			file = new MyFile();
			textpane.setBackground(Color.yellow);
			textpane.setEditable(false);
			
			file.createFileReader("Rules.txt");
			// br = new BufferedReader(file.fr);
			br = file.br;
			String s = null;
			do {
				s = br.readLine();
				doc.insertString(doc.getLength(), s, sat);
				doc.insertString(doc.getLength(), "\n", sat);
			} while(s != null);
			
			file.closeBufferedReader();
			this.setVisible(true);
			this.getContentPane().add(this.scrollpane);
		} catch(BadLocationException e) {
			System.out.println("Bad Location Exception ... !");
		} catch(IOException e) {
			System.out.println("Input Output Exception ... !");
		}
	}
}