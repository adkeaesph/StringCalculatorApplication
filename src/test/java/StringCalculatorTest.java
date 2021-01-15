import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {

	private String numbers;
	@Test
	public void testAdd1() {
		numbers = "1";
		assertEquals(1, StringCalculator.add(numbers));
	}

}
