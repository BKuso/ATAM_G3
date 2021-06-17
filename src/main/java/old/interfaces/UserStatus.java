package old.interfaces;

public enum UserStatus {

    GOOD("Хороший"),
    VERY_GOOD("Очень хороший"),
    BAD("Плохой"),
    VERY_BAD("Очень плохой");

    UserStatus(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
