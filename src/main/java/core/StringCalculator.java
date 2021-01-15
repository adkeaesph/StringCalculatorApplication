package core;

import customexceptions.NegativeNumberException;

public class StringCalculator {

	public static int add(String numbers) throws NegativeNumberException{
		if(numbers.contains("-")) {
			String negativeNumber = "-";
			int i = numbers.indexOf('-');
			i++;
			while(i<numbers.length() && numbers.charAt(i) >= '0' && numbers.charAt(i) <= '9') {
				negativeNumber += numbers.charAt(i);
				i++;
			}
			throw new NegativeNumberException("negatives not allowed -> "+negativeNumber);
		}
		
		numbers = numbers.trim();
		if(numbers.isEmpty())
			return 0;

		char delimiter = ',';	// default delimiter
		if(numbers.indexOf("//") == 0) {
			delimiter = numbers.charAt(2);	//storing the provided delimiter
			numbers = numbers.substring(3);	//assigning the rest of the string to numbers variable devoid of the delimiter part
		}
		
		String[] singleLineOfNumbers = numbers.split("[\n]+");	//splitting the string into an array of single lines of numbers 
		int sum = 0;

		String[] arrayOfNumbers;
		for(int i=0;i<singleLineOfNumbers.length;i++) {	
			arrayOfNumbers = singleLineOfNumbers[i].split("["+delimiter+"]");	//splitting a single line into individual numbers
																				//which are separated by the specified delimiter
			for(int j=0;j<arrayOfNumbers.length;j++)
				if(!arrayOfNumbers[j].trim().isEmpty())
					sum += Integer.parseInt(arrayOfNumbers[j]);
		}
		return sum;
	}
}
