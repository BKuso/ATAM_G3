import entities.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

    private final static Logger LOG = LogManager.getLogger("Программа");

    public static void main(String[] args) {

            List<Item> itemsForSale = new ArrayList<>();

            itemsForSale.add(new Item("Гречка, 1кг", 23.00));

            Seller seller = new Seller("Александр", itemsForSale);

            User buyer = new User("Мария");

            buyer.putMoneyToCashHolder(new Currency("Гривня"), 50.0);

            buyer.putItemInBag(
                    seller.sellItem("Гречка, 1кг",
                            buyer.getMoney("Гривня", 23.00)));

            buyer.getBag().showBagEntry();
    }

}
