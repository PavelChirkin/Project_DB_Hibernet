package service;

import entity.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.*;

import repository.UserRepository;


public class ConsoleLoginService {

     UserRepository userRepository = new UserRepository();

    private List<User> users = userRepository.getUsers();

    public void registration(Scanner sc) {
        System.out.println("*** User Registration ***");

        System.out.println("Insert Your Name");
        String name = sc.nextLine();
        System.out.println("Insert Your Surname");
        String surname = sc.nextLine();

        String userName = getUniqueUserName(sc);
        String password = getCorrectPassword(sc);

        User user = new User(null, name, surname, 'S', userName, password);
        users.add(user);
        userRepository.createNewUser(user);
        System.out.println("User successfully registered");
    }

    public User login(Scanner sc) {
        System.out.println("*** User login ***");
        System.out.println("Insert username");
        String userName = sc.nextLine();
        System.out.println("Insert password");
        String password = sc.nextLine();

        String encodedPassword = null;
        User currentUser = null;


        for (User var : users)
        {
            if(var.getUserName().equals(userName) ) {
                encodedPassword = var.getPassword();
                    if(encodedPassword != null && encodedPassword.equals(DigestUtils.sha256Hex(password))){
                    System.out.println("User login successfully");
                    currentUser = var;
                    }
            }
        }
    return currentUser;
    }

    private String getCorrectPassword(Scanner sc) {
        String password;
        String repeatPassword;
        String text = "";
        do {
            System.out.println(text);
            System.out.println("Please insert password");
            password = sc.nextLine();
            System.out.println("Repeat you password");
            repeatPassword = sc.nextLine();
            text = "Passwords not equals";
        } while(!password.equals(repeatPassword));

        return DigestUtils.sha256Hex(password);
    }

    private String getUniqueUserName(Scanner sc) {
        String userName;
        boolean uniqueName = true;
        String text = "Please insert username";
        do {
            System.out.println(text);
            userName = sc.nextLine();
            //Check existing UserNames
            for (User var : users)
            {
                if(var.getUserName().equals(userName)) {
                    uniqueName = false;
                }
            }
            text = "This name exist please insert another one";
        }while(userName != null & uniqueName);

        return userName;
    }
}
