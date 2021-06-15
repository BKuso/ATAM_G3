package models;

public abstract class Parent {

    private String name;

    public Parent(String name){
        this.name = name;
        //System.out.println("Создан экземпляр с именем=: " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
