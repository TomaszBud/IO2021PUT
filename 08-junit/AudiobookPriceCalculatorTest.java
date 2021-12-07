package put.io.testing.audiobooks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AudiobookPriceCalculatorTest {
    private AudiobookPriceCalculator calc;

    @Test
    public void testSubs() {
        Customer customer = new Customer("name", Customer.LoyaltyLevel.SILVER, true);
        Audiobook audiobook = new Audiobook("name", 95);
        double res1 = calc.calculate(customer, audiobook);
        assertEquals(res1, 0.0);
    }
    @Test
    public void testLoyaltySilver() {
        Customer customer = new Customer("name", Customer.LoyaltyLevel.SILVER, false);
        Audiobook audiobook = new Audiobook("name", 95);
        double res1 = calc.calculate(customer, audiobook);
        assertEquals(res1, 0.9*audiobook.getStartingPrice());
    }
    @Test
    public void testLoyaltyGold() {
        Customer customer = new Customer("name", Customer.LoyaltyLevel.GOLD, false);
        Audiobook audiobook = new Audiobook("name", 95);
        double res1 = calc.calculate(customer, audiobook);
        assertEquals(res1, 0.8*audiobook.getStartingPrice());
    }
    @Test
    public void testNoSubs() {
        Customer customer = new Customer("name", Customer.LoyaltyLevel.STANDARD, false);
        Audiobook audiobook = new Audiobook("name", 95);
        double res1 = calc.calculate(customer, audiobook);
        assertEquals(res1, audiobook.getStartingPrice());
    }

    @BeforeEach
    public void setUp() {
        calc = new AudiobookPriceCalculator();
    }


}