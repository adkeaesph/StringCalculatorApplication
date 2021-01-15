
public class StringCalculator {
	
	public static int add(String numbers) {
		if(numbers.trim().isEmpty())
			return 0;
		return Integer.parseInt(numbers.trim());
	}
}
