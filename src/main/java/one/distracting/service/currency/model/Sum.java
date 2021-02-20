package one.distracting.service.currency.model;

public class Sum implements Expression {

    private Expression augend;
    private Expression addend;

    public Sum(Expression augend, Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Expression getAugend() {
        return augend;
    }

    public Expression getAddend() {
        return addend;
    }

    public Money reduce(Bank bank, String to) {
        int amount = bank.reduce(getAugend(), to).getAmount()
                + bank.reduce(getAddend(), to).getAmount();
        return new Money(amount, to);
    }

    @Override
    public Expression plus(Expression money) {
        return null;
    }
}
