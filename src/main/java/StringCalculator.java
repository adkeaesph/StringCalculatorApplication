
public class StringCalculator {

	public static int add(String numbers) {
		if(numbers.trim().isEmpty())
			return 0;

		String[] arrayOfNumbers = numbers.trim().split(",");
		int sum = Integer.parseInt(arrayOfNumbers[0]);

		if(arrayOfNumbers.length == 1)
			return sum;

		for(int i=1;i<arrayOfNumbers.length;i++)
			sum += Integer.parseInt(arrayOfNumbers[i]);
		return sum;
	}
}
