package one.distracting.service.currency.model.utility;

public class RatePair {

    private String currencyOne;
    private String currencyTwo;

    public RatePair(String currencyOne, String currencyTwo) {
        this.currencyOne = currencyOne;
        this.currencyTwo = currencyTwo;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        RatePair pair = (RatePair) object;
        return currencyOne.equals(pair.currencyOne) && currencyTwo.equals(pair.currencyTwo);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
