package interfaces;

import models.Currency;

public interface CanMakePayment {

    void makeTransaction(Currency currency, int amount);
    void showCurrency();


    default void printSomething(String something){
        System.out.println(something);
    }

}
