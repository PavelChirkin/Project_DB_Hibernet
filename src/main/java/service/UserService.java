package service;

import entity.User;
import repository.UserRepository;


public class UserService {

    private final UserRepository userRepository;

    public UserService() {
        userRepository = new UserRepository();
    }
/*
    public void createUser() {
        User user = new User(null, "Andrius", "Baltrunas");
        userRepository.createNewUser(user);
    }   */

    public void getUsers() {
        userRepository.getUsers().forEach(System.out::println);
    }

    public void update() {
        User user = userRepository.getUser(1L);

        if(user == null) {
            System.out.println("User does not exist");
            return;
        }

        user.setName("Naujas vardas");
        user.setSurname("Nauja pavarde");

        userRepository.updateUser(user);
    }

    public void updateUserNameById() {
        userRepository.updateUserNameById(2L, "Petras");
    }

    public void delete(){
        User user = userRepository.getUser(2L);
        userRepository.delete(user);
    }

}
