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

	CONSTANT constants = new CONSTANT();

		boolean isProgramRunnable = true;
		// Check arguments
		while (isProgramRunnable) {
			isProgramRunnable = false;
			if ( args[0].equals(constants.LITARALES_A)) {
				System.out.println(constants.LOADING_MESSEGE);
				try {
					String inputString = readFile(constants.INPUT_FILE_NAME);
					writeLinst(inputString);
				} catch (Exception e) {
				}
				System.out.println(constants.lOADED_MESSEGE);
	
			} else if (args[0].equals(constants.LITARALES_R)) {
				System.out.println(constants.LOADING_MESSEGE);
				try {	
					String inpuString = readFile(constants.INPUT_FILE_NAME);
					System.out.println(inpuString);
					String stringList[] = inpuString.split(",");
					Random randomValue = new Random();
					int randomIndex = randomValue.nextInt();
					System.out.println(randomIndex);
					System.out.println(stringList[randomIndex]);
				} catch (Exception e) {
				}
				System.out.println(constants.lOADED_MESSEGE);
			} else if (args[0].contains(constants.LITARALES_ADD)) {
				System.out.println(constants.LOADING_MESSEGE);
				try {
					BufferedWriter writer = new BufferedWriter(
											   new FileWriter(constants.INPUT_FILE_NAME, true)
											   );
					String t = args[0].substring(1);
					Date date = new Date();
					String dateFormateString = constants.DATE_FORMAT;
					DateFormat dateFormat = new SimpleDateFormat(dateFormateString);
					String formatedDate = dateFormat.format(date);
					writer.write(", " + t + constants.UPDATE_MESSEGE + formatedDate);
					writer.close();
				} catch (Exception e) {
				}
	
				System.out.println(constants.lOADED_MESSEGE);
			} else if (args[0].contains(constants.LITARALES_SEARCH)) {
				System.out.println(constants.LOADING_MESSEGE);
				try {
					String inpuString = readFile(constants.INPUT_FILE_NAME);
					String stringList[] = inpuString.split(",");
					boolean done = false;
					String t = args[0].substring(1);
					for (int idx = 0; idx < stringList.length && !done; idx++) {
						if (stringList[idx].equals(t)) {
							System.out.println(constants.FOUND_MESSEGE);
							done = true;
						}
					}
				} catch (Exception e) {
				}
				System.out.println(constants.lOADED_MESSEGE);
			} else if (args[0].contains(constants.LITARALES_COUNT)) {
				System.out.println(constants.LOADING_MESSEGE);
				try {
					String inpuString = readFile(constants.INPUT_FILE_NAME);
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
					System.out.println(count + constants.WORD_MESSEGE + charList.length);
				} 
				catch (Exception e) {
				}
				System.out.println(constants.lOADED_MESSEGE);
			}else{
				System.out.println(constants.WRONG_ARGUMENTS_MESSEGE);
				Scanner scanner = new Scanner(System.in);
				String getArgs = scanner.nextLine();
				args = getArgs.split("//s+");
				isProgramRunnable = true;
			}
		
			
		}
	
	}
}