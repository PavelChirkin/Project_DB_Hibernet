import entity.Exam;
import entity.User;

//import service.UserService;
import repository.ExamAttemptRepository;
import repository.ExamRepository;
import service.ConsoleLoginService;
import service.ExamAttemptService;
import service.ExamService;

import java.util.Scanner;


public class Main {



    public static void main(String[] args) {

        Main main = new Main();


        main.menu();
    }
    private void menu()  {
        try (Scanner sc = new Scanner(System.in)) {

            ConsoleLoginService consoleLoginService = new ConsoleLoginService();
            User currentUser = new User();


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
                                teachersMenu(currentUser, sc);
                                isLoading = false;
                            } else {    //Student menu
                                studentMenu(currentUser, sc);
                                System.out.println("Student menu");
                                isLoading = false;
                            }
                        }else{
                            System.out.println("You input wrong username or password, try again");
                        }
                    }
                    case "3" -> isLoading = false;
                    default -> System.out.println("Please select menu item");

                }
            }
        }
    }
    public void teachersMenu(User user, Scanner sc) {
        ExamRepository examRepository = new ExamRepository();
        ExamService examService = new ExamService();
        boolean teacherWork = true;
        while (teacherWork) {
            System.out.println(" ___________________________________");
            System.out.println("|   1 - Create new exam             |");
            System.out.println("|   2 - Update exam questions       |");
            System.out.println("|   3 - Delete exam                 |");
            System.out.println("|   4 - Get statistics              |");
            System.out.println("|   5 - Exit                        |");
            System.out.println("|___________________________________|");

            String select1 = sc.nextLine();
            switch (select1) {
                case "1" -> {
                    examService.createNewExam(sc);
                }
                case "2" -> {}//examService.getStatistics();
                case "3" -> {}//examService.getStatistics();
                case "4" -> {}//examService.getStatistics();
                case "5" -> {
                    //isLoading = false;
                    teacherWork = false;
                }
                default -> System.out.println("Please select menu item");
            }
        }
    }
    public void studentMenu(User user, Scanner sc){
        ExamService examService = new ExamService();
        ExamAttemptService examAttemptService = new ExamAttemptService();
        boolean studentWork = true;
        while (studentWork) {
            System.out.println(" ___________________________________");
            System.out.println("|   1 - Take exam                   |");
            System.out.println("|   2 - Check exam results          |");
            System.out.println("|   3 - Exit                        |");
            System.out.println("|___________________________________|");

            String select1 = sc.nextLine();
            switch (select1) {
                case "1" -> {
                   Exam exam = examService.getExam(sc);
                    System.out.println(exam);
                    examAttemptService.makeExamAttempt(exam, sc);
                }
                case "2" -> {}//examService.getStatistics();
                case "3" -> {
                    //isLoading = false;
                    studentWork = false;
                }
                default -> System.out.println("Please select menu item");
            }
        }
    }
}

