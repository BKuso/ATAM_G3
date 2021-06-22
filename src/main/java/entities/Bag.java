package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bag {

    private List<Item> items = new ArrayList<>();

    public List<Item> getItems() {
        return items;
    }

    public Bag setItems(List<Item> items) {
        this.items = items;
        return this;
    }

    public Bag putItem(Item item){
        this.items.add(item);
        return this;
    }

    public Item getItemByName(String name){
        return this.items.stream()
                .filter(item -> item.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<Item> getItemsByName(String name){
        return this.items.stream()
                .filter(item -> item.getName().equals(name))
                .collect(Collectors.toList());
    }


}
