import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class DirectoryMerger {

	public static void main(String[] args) throws IOException {
		
		File directory = new File("E:\\Training Assignments\\AssignmentWeekThree");
		String[] files = directory.list();
		PrintWriter pw = new PrintWriter("E:\\AllMerge.txt");
		for (String file : files) {
			File file1 = new File(file);
			if(file1.isFile()) {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = br.readLine();
				while (line != null) {
					pw.println(line);
					line = br.readLine();
				}
				br.close();
			}
			System.out.println("done");
			
		}
		System.out.println("Finish");

		pw.flush();
		pw.close();
	}

}
