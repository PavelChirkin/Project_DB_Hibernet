package service;

import entity.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.*;

import repository.UserRepository;


public class ConsoleLoginService {

    UserRepository userRepository = new UserRepository();
    private List<User> users = new ArrayList<>();


    public void registration(Scanner sc) {
        users = userRepository.getUsers();
        System.out.println("*** User Registration ***");

        System.out.println("Insert Your Name");
        String name = sc.nextLine();
        System.out.println("Insert Your Surname");
        String surname = sc.nextLine();

        String userName = getUniqueUserName(sc);
        String password = getCorrectPassword(sc);
        char userType;
        if(userName.equals("pasha")) {
            userType = 'T';
        }else {
            userType = 'S';
        }
        User user = new User(null, name, surname, userType, userName, password);
        //if (users != null && !users.isEmpty()){
            users.add(user);
        //}else{
            //List<User> users = ArrayList<User>();
            //users.add(user);
        //}

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
        boolean notUniqueName;
        do {
            notUniqueName = false;
            System.out.println("Please insert username");
            userName = sc.nextLine();
            //Check existing UserNames

            if (users != null && !users.isEmpty()) {
                for (User var : users) {
                    if (var.getUserName().equals(userName)) {
                        notUniqueName = true;
                        System.out.println("This name exist please insert another one");
                    }
                }
            }
        }while(notUniqueName & userName.length() > 0);

        return userName;
    }
}
