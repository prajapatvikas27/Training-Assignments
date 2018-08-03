import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MergeTwoFiles {

	public static void main(String[] args) throws IOException {
		PrintWriter pw = new PrintWriter("TwoMergeFiles.txt");
		
		File file = new File("file1.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = br.readLine();
		while(line != null) {
			pw.println(line);
			line = br.readLine();
		}
	pw.flush();
		br = new BufferedReader(new FileReader("file2.txt"));
		line = br.readLine();
		while(br != null ) {
			pw.println(line);
			line = br.readLine();
		}
		System.out.println("done");
		pw.flush();
		pw.close();
		br.close();

	}

}
