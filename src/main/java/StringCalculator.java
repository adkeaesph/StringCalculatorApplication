
public class StringCalculator {
	
	public static int add(String numbers) {
		if(numbers.trim().isEmpty())
			return 0;
		
		String[] arrayOfNumbers = numbers.trim().split(",");
		int firstNumber = Integer.parseInt(arrayOfNumbers[0]);
		
		if(arrayOfNumbers.length == 1)
			return firstNumber;
		
		int secondNumber = Integer.parseInt(arrayOfNumbers[1]);
		return firstNumber + secondNumber;
	}
}
