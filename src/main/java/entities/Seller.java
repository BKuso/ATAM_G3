package entities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Seller extends User{

    private final Logger log = LogManager.getLogger("Продавец: " + this.getName());

    public Seller(String name, List<Item> items) {
        super(name);
        this.itemsForSale = items;
    }

    private final String currencyForSelling = "Гривня";

    private List<Item> itemsForSale;

    public List<Item> getItemsForSale() {
        return itemsForSale;
    }

    public Seller setItemsForSale(List<Item> itemsForSale) {
        this.itemsForSale = itemsForSale;
        return this;
    }

    public Item sellItem(String name, List<Currency> currencies){
        double amount = 0.0;

        for (Currency currency: currencies){
            if(currency.getName().equals(currencyForSelling)){
                amount+=currency.getNominal();
            }
        }
        return sellItem(name, amount);
    }


    public Item sellItem(String name, Double amount){
        for(Item item: this.itemsForSale){
            if(item.getName().equals(name)){
                log.info("Товар {} есть в наличии", name);
                if(item.getPrice()==amount){
                    log.info("Продано!");
                    return item;
                } else if (item.getPrice() < amount){
                    log.info("Слишком большая сумма. Для покупки товара заплатите на {} меньше", item.getPrice() - amount);
                    return null;
                } else {
                    log.info("Не хватает денег. Для покупки товара заплатите на {} больше", amount - item.getPrice());
                    return null;
                }
            }
        }
        log.info("У меня такого товара нет.");
        return null;
    }
}
