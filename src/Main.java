import Auth.Login;
import Auth.Register;
import DAO.DAOImplementations.MovieDAOImplementation;
import DAO.DAOImplementations.UserDAOImplementation;
import DAO.DAOInterfaces.MovieDAOInterface;
import DAO.DAOInterfaces.UserDAOInterface;
import Domain.User;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public MovieDAOInterface movieRepository = new MovieDAOImplementation();
    public UserDAOInterface userRepository = new UserDAOImplementation();
    private static User currentUser;

    public static void main(String[] args) {
        while (currentUser == null) {
            notAuthMenu();
        }
        authMenu();
    }

    public static void notAuthMenu() {
        Scanner input = new Scanner(System.in);
        logo();
        System.out.println("Welcome to MovieRating");
        System.out.println("1-Login 2-Register");
        int choice = input.nextInt();
        while (choice != 1 && choice != 2) {
            System.out.println("Choose a valid option");
            choice = input.nextInt();
        }
        switch (choice) {
            case 1:
                handleLogin();
                break;
            case 2:
                handleRegister();
                break;
        }

    }

    public static void authMenu() {
        System.out.println("Welcome Back " + currentUser.getName());
    }

    public static void logo() {
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "            ⣀⣄⡀⠀⢀⣀              \n" +
                "⠀⠀⠀⠀⠀⠀⠀⢠⣤⣤⣴⠿⢿⣿⣿⣿⣿⣆⣠⣤⣤⡀⢀⣀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⣴⡆⢸⣿⡟⢡⣴⡀⠻⠿⠿⣿⣿⣿⣿⣿⣇⣈⣉⡁⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⣠⣤⣄⡈⠛⣿⣿⣿⣇⣤⣶⡆⢸⣿⣿⣿⡟⢋⣙⣻⡟⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⢿⣿⣿⣿⣄⣼⣿⣿⣿⣿⣿⣷⣾⡟⢡⣤⣤⣾⣿⣿⣶⡶⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⢀⣉⣉⣙⡛⠛⠛⠛⠛⠛⠛⠛⠛⠀⠚⠛⠛⢛⣋⣉⣉⡀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠘⣿⣿⣿⣿⡀⢸⣿⣿⣿⡇⢸⣿⣿⣿⡇⢀⣿⣿⣿⣿⠃⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⢿⣿⣿⣿⡇⠸⠛⠋⣉⣁⣈⣉⠙⠛⠇⢸⣿⣿⣿⡿⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⢸⣿⣿⣿⠃⣰⣾⣿⣿⣿⣿⣿⣿⣷⣆⠘⣿⣿⣿⡇⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⣿⣿⣿⡀⢻⣿⣿⣿⣿⣿⣿⣿⣿⡟⢀⣿⣿⣿⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⢹⣿⣿⣷⠀⣈⡉⠛⠛⠛⠛⢉⣁⠀⣾⣿⣿⡏⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠘⣿⣿⣿⡄⢹⣿⣿⡇⢸⣿⣿⡏⢠⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⢻⣿⣿⡇⢸⣿⣿⡇⢸⣿⣿⡇⢸⣿⣿⡟⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠸⣿⣿⡇⢸⣿⣿⡇⢸⣿⣿⡇⢸⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀\n");

    }

    public static void handleRegister() {
        logo();
        Scanner input = new Scanner(System.in);
        Scanner inputInt = new Scanner(System.in);
        System.out.println("Enter Your name");
        String name = input.nextLine();
        System.out.println("Enter Your Your password");
        String password = input.nextLine();
        System.out.println("Enter Your Your Age");
        int age = input.nextInt();

        while (Register.createUser(name, password, age) == null) {
            handleRegister();
        }

    }

    public static void handleLogin() {
        logo();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Your Name");
        String name = input.nextLine();
        while (Login.isUserExist(name) == null) {
            System.out.println("Try Another Name");
            handleLogin();
        }
        String password;
        do {
            System.out.println("Enter Your Password");
            password = input.nextLine();
        }
        while (Login.isPasswordExist(Login.isUserExist(name), password));
         currentUser = Login.isUserExist(name);
         main(null);
    }


}