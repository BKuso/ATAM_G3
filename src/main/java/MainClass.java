import entities.CashHolder;
import entities.Currency;
import entities.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

    private final static Logger LOG = LogManager.getLogger(MainClass.class);

    public static void main(String[] args) {
        User seller = new User("Василий")
                .setCashHolder(new CashHolder()
                        .putCashToCashHolder(new Currency("Гривня"), 25.5)
                        .putCashToCashHolder(new Currency("Доллар"), 2.00)
                        .putCashToCashHolder(new Currency("Евро"), 2.00));

        User buyer = new User("Евгений").setCashHolder(new CashHolder());

        List<Currency> sumOfMoney = new ArrayList<>(){
            {
               addAll(seller.getMoney("Гривня", 15.00));
               addAll(seller.getMoney("Доллар", 1.00));
               addAll(seller.getMoney("Евро", 1.00));
            }
        };

        buyer.putMoneyToCashHolder(sumOfMoney);

        LOG.info(buyer.getMoneyStatus());

    }

}
