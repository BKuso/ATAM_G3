import models.Parent;
import models.User;

public class Printer {

    public static void printUserData(User user){
        System.out.println("Username: " + user.getUsername());
        System.out.println("Password: " + user.getPassword());
        System.out.println("Role: " + user.getRole());
        System.out.println("Created: " + user.getCreationDate());
    }

    public static void printData(Parent parent){
        System.out.println("Name: "+ parent.getName());
    }

}
