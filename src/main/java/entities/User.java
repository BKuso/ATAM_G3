package entities;

import java.util.List;

public class User {

    private String name;
    private CashHolder cashHolder;
    private Bag bag;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setCashHolder(CashHolder cashHolder) {
        this.cashHolder = cashHolder;
        return this;
    }

    public Bag getBag() {
        return bag;
    }

    public User setBag(Bag bag) {
        this.bag = bag;
        return this;
    }

    public User putMoneyToCashHolder(Currency currency, Double sum){
        this.cashHolder.putCashToCashHolder(currency, sum);
        return this;
    }

    public User putMoneyToCashHolder(String name, List<Currency> money){
        this.cashHolder.putCashToCashHolder(name, money);
        return this;
    }

    public User putMoneyToCashHolder(List<Currency> money){
        this.cashHolder.putCashToCashHolder(money);
        return this;
    }

    public List<Currency> getMoney(String currencyName, double sumOfMoney){
        return this.cashHolder.getMoneyFromCashHolder(currencyName, sumOfMoney);
    }

    public String getMoneyStatus(){
        return this.cashHolder.toString();
    }



}
