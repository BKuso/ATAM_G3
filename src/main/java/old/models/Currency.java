package old.models;

public class Currency extends Parent{

    public Currency(String name) {
        super(name);
    }

    public String toString(){
        return String.format("Название валюты: %s",
                this.getName());
    }
}
