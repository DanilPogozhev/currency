package one.distracting.service.currency.model;

import one.distracting.service.currency.model.utility.RatePair;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private static Map<RatePair, Integer> ratesTable = new HashMap<>();

    public void addRate(String currencyOne, String currencyTwo, int rate) {
        RatePair pair = new RatePair(currencyOne, currencyTwo);

        ratesTable.put(pair, rate);
    }

    public Integer getRate(String currencyFrom, String currencyTo) {
        if (currencyFrom.equals(currencyTo)) {
            return 1;
        }

        RatePair pair = new RatePair(currencyFrom, currencyTo);
        return ratesTable.get(pair);
    }

    public Money reduce(Expression source, String to) {
        return source.reduce(this, to);
    }
}
