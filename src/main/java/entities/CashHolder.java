package entities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CashHolder extends BaseEntity{

    private final Map<String, List<Currency>> cash = new HashMap<>();

    public CashHolder(String loggerName) {
        super(loggerName);
        log.debug("{} создан", loggerName);
    }

    public List<Currency> getCashInCurrency(String currency){
        return this.cash.get(currency) != null
                ? this.cash.get(currency) : new ArrayList<>();
    }

    public CashHolder putCashToCashHolder(String currencyName, List<Currency> money){
        this.cash.put(currencyName, money);
        return this;
    }

    public CashHolder putCashToCashHolder(List<Currency> money){
        if(!money.isEmpty()){
            money.stream()
                    .map(Currency::getName)
                    .distinct()
                    .forEach(name -> {
                        List<Currency> temp = money.stream()
                                .filter(currency -> currency.getName().equals(name))
                                .collect(Collectors.toList());
                        this.cash.put(name, temp);
                    });
        }
        return this;
    }

    public CashHolder putCashToCashHolder(Currency currency, Double sum){
        int intSum = sum.intValue();
        double doubleSum = sum % 1.00;
        List<Double> range = new ArrayList<>();
        for(int i = 0; i< intSum; i++){
            range.add(1.00);
        }
        if (doubleSum != 0.0){
            range.add(doubleSum);
        }
        String name = currency.getName();
        List<Currency> temp = new ArrayList<>();
        for(Double nominal: range){
            Currency tempCurrency = currency.clone();
            tempCurrency.setNominal(nominal);
            temp.add(tempCurrency);
        }
        this.cash.put(name, temp);
        log.info("Валюта {} в количестве {} теперь доступна в кошельке", currency.getName(), sum);
        return this;
    }

    public List<Currency> getMoneyFromCashHolder(String currencyName, double sumOfMoney){
        List<Currency> result = this.cash.get(currencyName);
        if(result != null && !result.isEmpty()){
            double currentSumOfCurrencyInCashHolder = 0;
            for (Currency currency : result){
                currentSumOfCurrencyInCashHolder += currency.getNominal();
            }
            if(currentSumOfCurrencyInCashHolder < sumOfMoney){
                log.info("Доступная сумма {} валюты {} меньше запрашиваемой суммы {}. " +
                        "Будут возвращены все доступные средства",
                        currentSumOfCurrencyInCashHolder, currencyName, sumOfMoney);
                return result;
            } else {
                List<Currency> returnedCurrency = new ArrayList<>();
                double returnedSum = 0;
                for (Currency currency : result){
                    if(returnedSum < sumOfMoney){
                        returnedCurrency.add(currency);
                        returnedSum+=currency.getNominal();
                    } else {
                        break;
                    }
                }
                result.removeAll(returnedCurrency);
                double balance = 0;
                for (Currency rest: result) {
                    balance+=rest.getNominal();
                }
                log.info("Запрашиваемая сумма {} валюты {} возвращена. Баланс: {}",
                        sumOfMoney, currencyName, balance);
                return returnedCurrency;
            }

        } else {
            log.info("Запрашивемой валюты {} в кошельке нет. Будет возвращено 0.0 валюты", currencyName);
            return new ArrayList<>();
        }
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("{ \n\"Количество денег в кошельке\": \n");
        this.cash.forEach((k, v) -> builder.append("\"")
                .append(k)
                .append("\": ")
                .append(v.size())
                .append(",\n"));
        builder.append("}");
        return builder.toString();
    }


}
