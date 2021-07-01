import entities.Bank;
import entities.Currency;

import java.util.ArrayList;
import java.util.List;

public class Debug {

    public static void main(String[] args) {

        Bank bank = new Bank("НБУ");

        List<Currency> currencies = new ArrayList<>();
        currencies.add(new Currency("USD").setNominal(2.00));
        currencies.add(new Currency("USD").setNominal(2.00));
        currencies.add(new Currency("USD").setNominal(2.5));
        currencies.add(new Currency("EUR").setNominal(2.00));
        currencies.add(new Currency("EUR").setNominal(2.00));
        currencies.add(new Currency("EUR").setNominal(2.00));
        currencies.add(new Currency("EUR").setNominal(0.3));


        System.out.println("Количество: " + bank.changeFromUah("USD", bank.changeToUah(currencies)).size());
    }

}
