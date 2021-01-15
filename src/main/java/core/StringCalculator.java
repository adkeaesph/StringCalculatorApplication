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
			numbers = numbers.substring(2);
			if(numbers.charAt(0)!='[' || numbers.indexOf("]") == -1) {
				delimiter = ""+numbers.charAt(0);	//storing the provided delimiter of single character
				numbers = numbers.substring(1);		//assigning the rest of the string to numbers variable devoid of the delimiter part
			} else {
				delimiter = "";
				int endIndex = numbers.indexOf("\n");
				int m;
				for(m=0; m<endIndex; m++) {
					if(numbers.charAt(m) == ']')
						delimiter += "]|";
					else
						delimiter += numbers.charAt(m);
				}
				delimiter = delimiter.substring(0, delimiter.length()-1);  //storing the regex of multiple delimiters
				numbers = numbers.substring(m);	//assigning the rest of the string to numbers variable devoid of the delimiter part
			}
		}
		
		String[] singleLineOfNumbers = numbers.split("[\n]+");	//splitting the string into an array of single lines of numbers 
		int sum = 0;

		String[] arrayOfNumbers;
		for(int i=0;i<singleLineOfNumbers.length;i++) {	
			arrayOfNumbers = singleLineOfNumbers[i].split(delimiter);	//splitting a single line into individual numbers
																				//which are separated by the specified delimiter
			for(int j=0;j<arrayOfNumbers.length;j++)
				if(!arrayOfNumbers[j].trim().isEmpty() && Integer.parseInt(arrayOfNumbers[j]) <= 1000)
					sum += Integer.parseInt(arrayOfNumbers[j]);
		}
		return sum;
	}
}
