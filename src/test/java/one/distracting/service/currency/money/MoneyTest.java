package one.distracting.service.currency.money;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import one.distracting.service.currency.Dollar;

public class MoneyTest {

    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);
        Dollar product = five.times(2);
        Assertions.assertEquals(10, product.amount);
        product = five.times(3);
        Assertions.assertEquals(15, product.amount);
    }

}
