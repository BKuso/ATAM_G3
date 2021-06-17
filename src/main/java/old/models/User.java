package old.models;

import old.interfaces.CanMakePayment;
import old.interfaces.Friendly;
import old.interfaces.UserStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.List;

@Friendly("")
public class User extends Parent implements CanMakePayment {

    private final static Logger LOG = LogManager.getLogger("Класса пользователя");

    private String username;
    private String password;
    private String role;
    private UserStatus status;
    private List<Currency> currency;
    private Date creationDate = new Date();

    public User(){
        super("Empty user");
        LOG.debug("Создан новый пользователь!");
    }

    public User(String username,
                String password,
                String role) {
        super(username);
        this.username = username;
        this.password = password;
        this.role = role;
        LOG.debug("Создан пользователь "+ username);
    }

    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setRole(String role) {
        this.role = role;
        return this;
    }

    public List<Currency> getCurrency() {
        return currency;
    }

    public User setCurrency(List<Currency> currency) {
        this.currency = currency;
        return this;
    }

    public UserStatus getStatus() {
        return status;
    }

    public User setStatus(UserStatus status) {
        this.status = status;
        return this;
    }

    @Override
    public void makeTransaction(Currency currency, int amount) {
        System.out.println("Текущий пользователь: " + this.username);
        this.currency.stream()
                .filter(currency1 -> currency1.getName().equals(currency.getName()))
                .forEach(currency1 ->
                        System.out.printf("Произведена транзакция. Валюта %s, Сумма: %s%n", currency.getName(), amount));
    }

    @Override
    public void showCurrency() {
        System.out.println("Доступные для текущего пользователя валюты:");
        this.currency.forEach(currency1 -> System.out.println(currency1.getName()));
    }
}
