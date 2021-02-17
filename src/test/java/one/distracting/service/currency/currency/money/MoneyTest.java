package one.distracting.service.currency.currency.money;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import one.distracting.service.currency.currency.Dollar;

public class MoneyTest {

    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);
        five.times(2);
        Assertions.assertEquals(10, five.amount);
    }

}
