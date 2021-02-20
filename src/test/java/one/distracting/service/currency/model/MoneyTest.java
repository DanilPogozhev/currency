package one.distracting.service.currency.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MoneyTest {

    @Test
    void testMultiplication() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    void testCompareTwoDifferentCurrencies() {
        assertNotEquals(Money.dollar(5), Money.franc(5));
    }

    @Test
    void testCurrency() {
        assertEquals("USD", Money.dollar(1).getCurrency());
        assertEquals("CHF", Money.franc(1).getCurrency());
    }

    @Test
    void testSimpleAddition() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduce = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduce);
    }

    @Test
    void testPlusReturnsSum() {
        Money five = Money.dollar(5);
        Expression expression = five.plus(five);
        Sum sum = (Sum) expression;
        assertEquals(five, sum.getAugend());
        assertEquals(five, sum.getAddend());
    }

    @Test
    void testMixedCurrenciesAddition() {
        Expression franc = Money.franc(10);
        Expression dollar = Money.dollar(5);
        Expression sum = franc.plus(dollar);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money reduce = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduce);
    }
}
