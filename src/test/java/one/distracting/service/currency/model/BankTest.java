package one.distracting.service.currency.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankTest {

    @Test
    void testReduceSum() {
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money reduce = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), reduce);
    }

    @Test
    void testReduceMoney() {
        Bank bank = new Bank();
        Money reduce = bank.reduce(Money.dollar(5), "USD");
        assertEquals(Money.dollar(5), reduce);
    }

    @Test
    void testReduceDifferentCurrencies() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money reduce = bank.reduce(Money.franc(2), "USD");
        assertEquals(Money.dollar(1), reduce);
    }

    @Test
    void testIdenticalRate() {
        assertEquals(1, new Bank().getRate("USD", "USD"));
    }

}
