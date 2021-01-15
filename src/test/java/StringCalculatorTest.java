import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import core.StringCalculator;
import customexceptions.NegativeNumberException;

class StringCalculatorTest {

	private String numbers;

	@Test
	public void testAdd1() throws NegativeNumberException {
		numbers = "";
		assertEquals(0, StringCalculator.add(numbers));
	}

	@Test
	public void testAdd2() throws NegativeNumberException {
		numbers = "1";
		assertEquals(1, StringCalculator.add(numbers));
	}

	@Test
	public void testAdd3() throws NegativeNumberException {
		numbers = "1,2";
		assertEquals(3, StringCalculator.add(numbers));
	}

	@Test
	public void testAdd4() throws NegativeNumberException {
		numbers = "1,2,3";
		assertEquals(6, StringCalculator.add(numbers));
	}

	@Test
	public void testAdd5() throws NegativeNumberException {
		numbers = "1,2,3,23,10";
		assertEquals(39, StringCalculator.add(numbers));
	}
	
	@Test
	public void testAdd6() throws NegativeNumberException {
		numbers = "1\n2,4";
		assertEquals(7, StringCalculator.add(numbers));
	}
	
	@Test
	public void testAdd7() throws NegativeNumberException {
		numbers = "1\n3,4,5\n6,2\n4";
		assertEquals(25, StringCalculator.add(numbers));
	}
	
	@Test
	public void testAdd8() throws NegativeNumberException {
		numbers = "1\n3,4,5\n6,2\n4\n5\n\n2";
		assertEquals(32, StringCalculator.add(numbers));
	}
	
	@Test
	public void testAdd9() throws NegativeNumberException {
		numbers = "//;\n1";
		assertEquals(1, StringCalculator.add(numbers));
	}
	
	@Test
	public void testAdd10() throws NegativeNumberException {
		numbers = "//;\n1;2";
		assertEquals(3, StringCalculator.add(numbers));
	}
	
	@Test
	public void testAdd11() throws NegativeNumberException {
		numbers = "//;\n1\n3;4;5\n6;2\n4\n5\n\n2";
		assertEquals(32, StringCalculator.add(numbers));
	}
	
	@Test
	public void testAdd12() {
		numbers = "2,-1";
		Exception exception = assertThrows(NegativeNumberException.class, () -> {
	        StringCalculator.add(numbers);
	    });

	    assertEquals("negatives not allowed -> -1", exception.getMessage());
	}
	
	@Test
	public void testAdd13() {
		numbers = "//;2\n-123;24";
		Exception exception = assertThrows(NegativeNumberException.class, () -> {
	        StringCalculator.add(numbers);
	    });

	    assertEquals("negatives not allowed -> -123", exception.getMessage());
	}
	
	@Test
	public void testAdd14() {
		numbers = "//;2\n-123;24\n-42;9";
		Exception exception = assertThrows(NegativeNumberException.class, () -> {
	        StringCalculator.add(numbers);
	    });

	    assertEquals("negatives not allowed -> -123 -42", exception.getMessage());
	}
	
	@Test
	public void testAdd15() {
		numbers = "//;2\n-123;24\n-42;-9";
		Exception exception = assertThrows(NegativeNumberException.class, () -> {
	        StringCalculator.add(numbers);
	    });

	    assertEquals("negatives not allowed -> -123 -42 -9", exception.getMessage());
	}
	
	@Test
	public void testAdd16() throws NegativeNumberException {
		numbers = "1\n3,4400,5\n60000,2\n4\n50\n\n2";
		assertEquals(67, StringCalculator.add(numbers));
	}
}
