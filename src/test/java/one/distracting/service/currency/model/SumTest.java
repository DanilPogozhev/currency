package one.distracting.service.currency.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumTest {

    @Test
    public void testPlusDifferentCurrencies() {
        Expression tenFrancs = Money.franc(10);
        Expression fiveDollars = Money.dollar(5);

        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(tenFrancs, fiveDollars).plus(fiveDollars);
        Money result = bank.reduce(sum, "USD");

        assertEquals(Money.dollar(15), result);
    }

    @Test
    public void testTimesWithDifferentCurrencies() {
        Expression tenFrancs = Money.franc(10);
        Expression fiveDollars = Money.dollar(5);

        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(tenFrancs, fiveDollars).times(2);
        Money result = bank.reduce(sum, "USD");

        assertEquals(Money.dollar(20), result);
    }

}
