import java.io.File;

public class DisplayFileDirectories {

	public static void main(String[] args) {
	
		File file = new File("E:\\workspace\\AssignmentWeekThree");
		int countFile = 0, countDir = 0;
		String[] contents = file.list();
		for(String content : contents) {
			
			File contentFile = new File(content);
			if(contentFile.isFile()) {
				countFile++;
				System.out.println(content);
			}
			
		}
		System.out.println("File Count: " + countFile);
		
		for(String content : contents) {
		
			File contentFile = new File(content);
			if(contentFile.isDirectory()) {
				countDir++;
				System.out.println(content);
			}
		}
		
		System.out.println("Directory Count : " + countDir);

	}

}
