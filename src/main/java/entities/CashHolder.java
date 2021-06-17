package entities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CashHolder {

    private final static Logger LOG = LogManager.getLogger("Робот-бухгалтер");

    private final Map<String, List<Currency>> cash = new HashMap<>();

    public List<Currency> getCashInCurrency(String currency){
        return this.cash.get(currency) != null
                ? this.cash.get(currency) : new ArrayList<>();
    }

    public CashHolder putCashToCashHolder(Currency currency, Double sum){
        int count = (int) (sum - (sum % 1.00));
        String name = currency.getName();
        List<Currency> temp = new ArrayList<>();
        for(int i = 0; i < count+1; i++){
            Currency tempCurrency = currency.clone();
            if(i<count){
                tempCurrency.setNominal(1.00);
            }else{
                tempCurrency.setNominal(sum%1.00);
            }
            temp.add(tempCurrency);
        }
        this.cash.put(name, temp);
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
                LOG.info("Доступная сумма {} меньше запрашиваемой суммы {}. " +
                        "Будут возвращены все доступные средства", currentSumOfCurrencyInCashHolder, sumOfMoney);
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
                LOG.info("Запрашиваемая сумма возвращена. Баланс: {}", balance);
                return returnedCurrency;
            }

        } else {
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
