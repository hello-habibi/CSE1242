import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {

	public static String readFile(String fileName){
		String inpuString;
		BufferedReader reader;
		try {
			reader = new BufferedReader(
										new InputStreamReader(
											new FileInputStream(fileName)
										)	
								);
			inpuString = reader.readLine();
			reader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
		return inpuString;
	}

	public static void writeLinst(String mainString){
		String stringList[] = mainString.split(",");
		for (String string : stringList) {
			System.out.println(string);
		}


	}


	public static void main(String[] args) {

		boolean isProgramRunnable = true;
		// Check arguments
		while (isProgramRunnable) {
			isProgramRunnable = false;
			if ( args[0].equals("a")) {
				System.out.println("Loading data ...");
				try {
					String inputString = readFile("student.text");
					writeLinst(inputString);
				} catch (Exception e) {
				}
				System.out.println("Data Loaded.");
	
			} else if (args[0].equals("r")) {
				System.out.println("Loading data ...");
				try {	
					String inpuString = readFile("students.txt");
					System.out.println(inpuString);
					String stringList[] = inpuString.split(",");
					Random randomValue = new Random();
					int randomIndex = randomValue.nextInt();
					System.out.println(randomIndex);
					System.out.println(stringList[randomIndex]);
				} catch (Exception e) {
				}
				System.out.println("Data Loaded.");
			} else if (args[0].contains("+")) {
				System.out.println("Loading data ...");
				try {
					BufferedWriter writer = new BufferedWriter(
											   new FileWriter("students.txt", true)
											   );
					String t = args[0].substring(1);
					Date date = new Date();
					String dateFormateString = "dd/mm/yyyy-hh:mm:ss a";
					DateFormat dateFormat = new SimpleDateFormat(dateFormateString);
					String formatedDate = dateFormat.format(date);
					writer.write(", " + t + "\nList last updated on " + formatedDate);
					writer.close();
				} catch (Exception e) {
				}
	
				System.out.println("Data Loaded.");
			} else if (args[0].contains("?")) {
				System.out.println("Loading data ...");
				try {
					String inpuString = readFile("studet.txt");
					String stringList[] = inpuString.split(",");
					boolean done = false;
					String t = args[0].substring(1);
					for (int idx = 0; idx < stringList.length && !done; idx++) {
						if (stringList[idx].equals(t)) {
							System.out.println("We found it!");
							done = true;
						}
					}
				} catch (Exception e) {
				}
				System.out.println("Data Loaded.");
			} else if (args[0].contains("c")) {
				System.out.println("Loading data ...");
				try {
					String inpuString = readFile("studet.txt");
					char charList[] = inpuString.toCharArray();
					boolean in_word = false;
					int count = 0;
					for (char ch : charList) {
						if (ch == ' ') {
							if (!in_word) {
								count++;
								in_word = true;
							} 
							else {
								in_word = false;
							}
						}
					}
					System.out.println(count + " word(s) found " + charList.length);
				} 
				catch (Exception e) {
				}
				System.out.println("Data Loaded.");
			}else{
				System.out.println("The argument you passed is Wrong . So give an valid argiment to the main class ");
				Scanner scanner = new Scanner(System.in);
				String getArgs = scanner.nextLine();
				args = getArgs.split("//s+");
				isProgramRunnable = true;
			}
		
			
		}
	
	}
}