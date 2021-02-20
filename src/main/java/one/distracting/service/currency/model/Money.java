package one.distracting.service.currency.model;

public class Money implements Expression {

    private int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    public Expression times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    public Money reduce(Bank bank, String to) {
        int rate = bank.getRate(currency, to);

        return new Money(amount / rate, to);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        Money money = (Money) object;
        return amount == money.amount && getCurrency().equals(money.getCurrency());
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }

}
