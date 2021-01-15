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

	@Test
	public void testAdd3() {
		numbers = "1,2";
		assertEquals(3, StringCalculator.add(numbers));
	}

	@Test
	public void testAdd4() {
		numbers = "1,2,3";
		assertEquals(6, StringCalculator.add(numbers));
	}

	@Test
	public void testAdd5() {
		numbers = "1,2,3,23,10";
		assertEquals(39, StringCalculator.add(numbers));
	}
}
