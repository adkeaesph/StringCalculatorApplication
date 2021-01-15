package core;

import customexceptions.NegativeNumberException;

public class StringCalculator {
	
	public static String findNegativeNumbers(String numbers) {
		int i=0;
		String stringOfNegativeNumbers = "";
		while(i<numbers.length()) {
			if(numbers.charAt(i) == '-') {
				stringOfNegativeNumbers += "-";
				int j = ++i;
				while(j<numbers.length() && numbers.charAt(j) >= '0' && numbers.charAt(j) <= '9') {
					stringOfNegativeNumbers += numbers.charAt(j);
					j++;
					i++;
				}
				stringOfNegativeNumbers += " ";
			} else
				i++;
		}
		return stringOfNegativeNumbers.trim();
	}

	public static int add(String numbers) throws NegativeNumberException{
		if(numbers.contains("-")) {
			throw new NegativeNumberException("negatives not allowed -> "+findNegativeNumbers(numbers));
		}
		
		numbers = numbers.trim();
		if(numbers.isEmpty())
			return 0;

		String delimiter = ",";	// default delimiter
		if(numbers.indexOf("//") == 0) {
			if(numbers.charAt(2)!='[' || numbers.indexOf("]") == -1) {
				delimiter = ""+numbers.charAt(2);	//storing the provided delimiter of single character
				numbers = numbers.substring(3);		//assigning the rest of the string to numbers variable devoid of the delimiter part
			} else {
				int m=3;
				delimiter = "";
				while (numbers.charAt(m)!=']') {	//parsing through multi-character delimiter
					delimiter += numbers.charAt(m);
					m++;
				}
				numbers = numbers.substring(m+1);	//assigning the rest of the string to numbers variable devoid of the delimiter part
			}
		}
		
		String[] singleLineOfNumbers = numbers.split("[\n]+");	//splitting the string into an array of single lines of numbers 
		int sum = 0;

		String[] arrayOfNumbers;
		for(int i=0;i<singleLineOfNumbers.length;i++) {	
			arrayOfNumbers = singleLineOfNumbers[i].split("["+delimiter+"]");	//splitting a single line into individual numbers
																				//which are separated by the specified delimiter
			for(int j=0;j<arrayOfNumbers.length;j++)
				if(!arrayOfNumbers[j].trim().isEmpty() && Integer.parseInt(arrayOfNumbers[j]) <= 1000)
					sum += Integer.parseInt(arrayOfNumbers[j]);
		}
		return sum;
	}
}
