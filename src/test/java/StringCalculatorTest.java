import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {

	private String numbers;
	
	@Test
	public void testAdd1() {
		numbers = "";
		assertEquals(0, StringCalculator.add(numbers));
	}

	@Test
	public void testAdd2() {
		numbers = "1";
		assertEquals(1, StringCalculator.add(numbers));
	}
}
