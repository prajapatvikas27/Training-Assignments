

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadingAndWriting {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		System.out.println("Give a name to your file");
		String filename = scan.next() + ".txt";
		File file = new File(filename);
		
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
			
			System.out.println("Enter content to be writtern inside the file");
			String content = scan.next();
			bufferedWriter.write(content);
			System.out.println("Done");
		
		} catch (IOException e) {
		
		
		}
		
		
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
			
			System.out.println(bufferedReader.readLine().toString());
			
			
		} catch (FileNotFoundException e) {
			
			System.out.println("File not Found: could not read the data");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
