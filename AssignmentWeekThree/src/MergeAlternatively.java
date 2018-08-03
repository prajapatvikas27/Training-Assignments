import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MergeAlternatively {

	public static void main(String[] args) throws IOException {
		
		PrintWriter pw = new PrintWriter("Alternatives.txt");
		BufferedReader br = new BufferedReader(new FileReader("file1.txt"));
		BufferedReader br2 = new BufferedReader(new FileReader("file2.txt"));
		String line1 = br.readLine();
		String line2 = br2.readLine();
		while((line1 != null) || (line2 != null)) {
			
			if(line1 != null) {
				pw.println(line1);	
			}
			if (line2 != null) {
				pw.println(line2);	
			}
			
			line1 = br.readLine();
			line2 = br2.readLine();
			
		}
		pw.flush();
		pw.close();
		br.close();

	}

}
