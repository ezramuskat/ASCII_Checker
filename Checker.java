import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
public class Checker {
	public static void main(String[] args){
		String inputErr = "Please enter a single file name, optionally followed by \"-v\" if you would like verbose output";
		boolean verbose = false;
		//ensure a single file is entered
		if (!(args.length == 1 || args.length == 2)) {
			System.out.println(inputErr);
			return;
		}

		if (args.length == 2) {
			if (args[0].equals("-v")) {
				verbose = true;
			} else {
				System.out.println(inputErr);
				return;
			}
		}

		try {
			int fileArg = 0;
			if (verbose) {
				fileArg = 1;
			}
			File file = new File(args[fileArg]);
			Scanner scanner = new Scanner(file);
			ArrayList<String> nonASCII = new ArrayList<String>();
			ArrayList<Integer> positions = new ArrayList<Integer>();
			int counter = 0;


	        while (scanner.hasNextLine()) {
	        	counter++;
	            String i = scanner.next();
	            if (!i.matches("\\A\\p{ASCII}*\\z")) {
	            	nonASCII.add(i);
	            	positions.add(counter);
	            }
	        }
	        scanner.close();
	        System.out.println("This file has " + nonASCII.size() + " non-ASCII characters");
	        
	        if (verbose) {
	        	if (nonASCII.size() > 0) {
		        	System.out.print("The following words at the following positions contain non-ASCII characters: ");
		        	for (int i = 0; i < nonASCII.size() - 1; i++) {
		        		System.out.print(nonASCII.get(i) + " at " + positions.get(i));
		        		System.out.print(", ");
		        	}
		        	System.out.println(nonASCII.get(nonASCII.size() - 1) + " at " + positions.get(nonASCII.size() - 1));
		        }
	        }
	        

		} catch (FileNotFoundException e) {
			System.out.println("Sorry, that file could not be found");
		}

	}
}