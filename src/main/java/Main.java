import entity.User;
import service.ConsoleLoginService;
import service.UserService;


import java.util.Scanner;
import service.UserService;


public class Main {



    public static void main(String[] args) {
        UserService userService = new UserService();

        userService.createUser();
        //userService.updateUserNameById();
        //userService.update();
        //userService.delete();
        //userService.getUsers();
        Main main = new Main();


        main.menu();
    }
    private void menu()  {
        try (Scanner sc = new Scanner(System.in)) {
            UserService userService = new UserService();
            ConsoleLoginService consoleLoginService = new ConsoleLoginService();
            User currentUser = new User();
            //ExamService examService = new ExamService();
            //TeacherMenu teacherMenu = new TeacherMenu();
            //ExamTest examTest;
            //examService.initArrayLists(dir2);
            boolean isLoading = true;
            while (isLoading) {
                System.out.println(" ___________________________________");
                System.out.println("|   1 - User registration           |");
                System.out.println("|   2 - User login                  |");
                System.out.println("|   3 - Exit                        |");
                System.out.println("|___________________________________|");

                String select = sc.nextLine();
                switch (select) {
                    case "1" -> consoleLoginService.registration(sc);
                    case "2" -> {
                        currentUser = consoleLoginService.login(sc);
                        if (currentUser!=null) {  //login success
                            if (currentUser.getUserType()=='T') {
                                //call teachers menu
                                boolean teacherWork = true;
                                while (teacherWork) {
                                    System.out.println(" ___________________________________");
                                    System.out.println("|   1 - Set exam questions          |");
                                    System.out.println("|   2 - Get statistics              |");
                                    System.out.println("|   3 - Exit                        |");
                                    System.out.println("|___________________________________|");

                                    String select1 = sc.nextLine();
                                    switch (select1) {
                                        case "1" -> {
                                            //examTest = teacherMenu.addNewExam(sc);
                                            //teacherMenu.writeExamFile(examTest, dir2);
                                        }
                                        case "2" -> {}//examService.getStatistics();
                                        case "3" -> {
                                            isLoading = false;
                                            teacherWork = false;
                                        }
                                        default -> System.out.println("Please select menu item");
                                    }
                                }
                            } else {    //Student meniu
                                //examTest = examService.choseExam(sc);
                                //examService.tryExam(sc, examTest, logRez[2], dir1, dir2);
                            }
                        }
                    }
                    case "3" -> isLoading = false;
                    default -> System.out.println("Please select menu item");

                }
            }
        }
    }
}

