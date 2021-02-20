package one.distracting.service.currency.model;

public class Sum implements Expression {

    private Money augend;
    private Money addend;

    public Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money getAugend() {
        return augend;
    }

    public Money getAddend() {
        return addend;
    }

    public Money reduce(Bank bank, String to) {
        int amount = getAugend().getAmount() + getAddend().getAmount();
        return new Money(amount, to);
    }
}
