package old;

import old.interfaces.UserStatus;
import old.models.Currency;
import old.models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ApplicationTwo {

    private final static Logger LOG =
            LogManager.getLogger("Второй исполняемый класс");

    public static void main(String[] args) {
         User user = new User(
                 "user",
                 "password",
                 "Simple system user")
                 .setStatus(UserStatus.GOOD)
                 .setCurrency(new ArrayList<>(){
                     {
                         add(new Currency("UAH"));
                     }
                 });

//        List<Parent> users = new ArrayList<>();
//        users.add(admin);
//        users.add(user);
//        users.add(new Currency("UAH"));

        User admin = new User()
                .setUsername("admin")
                .setPassword("password")
                .setRole("System Administrator")
                .setStatus(UserStatus.BAD)
                .setCurrency(new ArrayList<>(){
                                 {
                                     add(new Currency("UAH"));
                                     add(new Currency("USD"));
                                     add(new Currency("EUR"));
                                 }
                             }
                );

        List<User> users = new ArrayList<>();
        users.add(admin);
        users.add(user);

//        users.stream().filter(user1 -> user1.getStatus() == UserStatus.GOOD)
//                .forEach(user1 -> System.out.println(user1.getUsername()));


        LOG.info(UserStatus.GOOD.getName());

//        List<CanMakePayment> paymentUsers = new ArrayList<>();
//        paymentUsers.add(admin);
//        paymentUsers.add(user);
//
//        paymentUsers.forEach(paymentUser ->
//        {
//            paymentUser.makeTransaction(new Currency("USD"), 20);
//            paymentUser.showCurrency();
//        });

      //  users.forEach(old.Printer::printData);

    }
}
