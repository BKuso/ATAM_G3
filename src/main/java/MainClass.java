import entities.CashHolder;
import entities.Currency;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainClass {

    private final static Logger LOG = LogManager.getLogger(MainClass.class);

    public static void main(String[] args) {
        CashHolder holder = new CashHolder();
        holder.putCashToCashHolder(
                new Currency("Гривня"), 25.5);
        LOG.info(holder
                .getMoneyFromCashHolder(
                        "Гривня",
                        30.00)
                .size());

    }

}
