package put.io.testing.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @Test
    public void testAdd() throws Exception {
        int res1 = calculator.add(1, 2);
        int res2 = calculator.add(4, 5);
        assertEquals(res1, 3);
        assertEquals(res2, 9);
    }

    @Test
    public void testMultiply() throws Exception {
        int res1 = calculator.multiply(1, 2);
        int res2 = calculator.multiply(4, 5);
        assertEquals(res1, 2);
        assertEquals(res2, 20);
    }

    @Test
    public void testAddPositiveNumbers() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.addPositiveNumbers(-3, 2);
        });
    }

    @BeforeEach
    public void setUp() throws Exception {
        calculator = new Calculator();
    }
    // Zamiana na BeforeAll nie powinna sprawiać problemu, ponieważ metody
    // wykorzystywane w testach nie wpływają na atrybuty klasy

}