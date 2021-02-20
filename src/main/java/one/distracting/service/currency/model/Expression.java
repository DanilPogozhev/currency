package one.distracting.service.currency.model;

public interface Expression {

    Money reduce(Bank bank, String to);

}
