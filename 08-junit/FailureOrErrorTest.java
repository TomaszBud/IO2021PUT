package put.io.testing.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FailureOrErrorTest {

    private Calculator calculator;

    @Test
    public void test1() throws Exception {
        int res1 = calculator.add(55,223);
        assertEquals(res1, 1);
    } // Error

    @Test
    public void test2() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.addPositiveNumbers(-3, 2);
        });
    } // Failure

    @Test
    public void test3() throws Exception {
        try {
            int res1 = calculator.add(55,223);
            assertEquals(res1, 1);
        }
        catch (Exception exc){
            throw new IllegalArgumentException("Wrong sign", exc);

        }
    }

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
}
