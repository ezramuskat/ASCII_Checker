import java.io.*;
import java.util.Scanner;
public class Checker {
	public static void main(String[] args){
		//ensure a single file is entered
		if (args.length != 1) {
			System.out.println("Please enter a single file name");
			return;
		}

		try {
			File file = new File(args[0]);
			Scanner scanner = new Scanner(file);
			int invalidChars = 0;

	        while (scanner.hasNextLine()) {
	            String i = scanner.next();
	            if (!i.matches("\\A\\p{ASCII}*\\z")) {
	            	invalidChars++;
	            }
	        }
	        scanner.close();
	        System.out.println(invalidChars);

		} catch (FileNotFoundException e) {
			System.out.println("Sorry, that file could not be found");
		}

	}
}