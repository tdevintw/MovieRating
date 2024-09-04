import Auth.Login;
import Auth.Register;
import DAO.DAOImplementations.MovieDAOImplementation;
import DAO.DAOImplementations.UserDAOImplementation;
import DAO.DAOInterfaces.MovieDAOInterface;
import DAO.DAOInterfaces.UserDAOInterface;
import Domain.Genre;
import Domain.Movie;
import Domain.User;
import Repository.MovieRepository;
import Repository.UserRepository;

import javax.swing.*;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public  static MovieDAOInterface movieDAO = new MovieDAOImplementation();
    public  static UserDAOInterface userDAO = new UserDAOImplementation();
    public static MovieRepository movieRepository = new MovieRepository(movieDAO);
    public static UserRepository userRepository = new UserRepository(userDAO);
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
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome Back " + currentUser.getName() + currentUser.getPassword() + currentUser.getAge());
        System.out.println(
                """
                        1-Update Personal Information
                        2-Delete Account
                        3-See All Users
                        4-Add A movie
                        5-Update A movie
                        6-Delete A movie
                        7-Filter By Genre
                        8-Filter By Rating
                        9-Filter By Title
                        10-Logout
                        """
        );
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                updatePersonalInformation();
                break;
            case 2:
                deleteAccount();
                break;
            case 3:
                seeAllUsers();
                break;
            case 4:
                addMovie();
                break;
            case 5:
                updateMovie();
                break;
            case 6:
                deleteMovie();
                break;
            case 7:
                filterByGenre();
                break;
            case 8:
                filterByRating();
                break;
            case 9:
                filterByTitle();
                break;
            case 10:
                currentUser = null;
                break;
            default:
                System.out.println("Choose a valid option");
                authMenu();
                break;

        }
        main(null);
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
        while (!Login.isPasswordExist(Login.isUserExist(name), password));
        currentUser = Login.isUserExist(name);
    }

    public static void updatePersonalInformation() {
        logo();
        Scanner input = new Scanner(System.in);
        Scanner inputInt = new Scanner(System.in);
        System.out.println(
                """
                        1-Name
                        2-Password
                        3-Age
                        """
        );
        int choice = inputInt.nextInt();
        switch (choice) {
            case 1:
                String newName;
                do {
                    System.out.println("Enter the new name");
                    newName = input.nextLine();
                } while (!Register.isNameTrue(newName));
                currentUser.setName(newName);
                userRepository.update(currentUser);
                break;
            case 2:
                String newPassword;
                do {
                    System.out.println("Enter the new password");
                    newPassword = input.nextLine();
                } while (!Register.isPasswordTrue(newPassword));
                currentUser.setName(newPassword);
                userRepository.update(currentUser);
            case 3:
                int newAge;
                do {
                    System.out.println("Enter the new age");
                    newAge = inputInt.nextInt();
                } while (!Register.isAgeTrue(newAge));
                currentUser.setAge(newAge);
                userRepository.update(currentUser);
            default:
                System.out.println("enter a valid option");
                updatePersonalInformation();
        }
        main(null);
    }

    public static void deleteAccount() {
        userRepository.delete(currentUser);
        currentUser = null;
        main(null);
    }

    public static void seeAllUsers() {
        userRepository.getAllUsers().stream().forEach(user -> System.out.println("Name : " + user.getName() + "Age : " + user.getAge()));
        main(null);
    }

    public static void addMovie() {
        Scanner input = new Scanner(System.in);
        Scanner inputFloat = new Scanner(System.in);

        System.out.println("Enter movie name");
        String movieName = input.nextLine();
        System.out.println("Enter movie rating_");
        float rating = inputFloat.nextFloat();
        System.out.print("Enter movie Genre : ");
        for (Genre genre : Genre.values()) {
            System.out.print(genre);
            System.out.println(" , ");
        }
        Genre genre = null;

        try {
            String userInput = input.nextLine().toUpperCase();
            genre = Genre.valueOf(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Genre");
            System.out.println("Try Again");
            addMovie();
        }

        Movie movie = new Movie(movieName, rating, genre);
        movieRepository.add(movie);
        main(null);
    }

    public static void updateMovie() {

    }

    public static void deleteMovie() {
        Scanner input = new Scanner(System.in);
        System.out.println("Movies are : ");
        movieRepository.getAllMovies();
        System.out.println("Enter movie id");
        int id = input.nextInt();
        movieRepository.delete(id);
        main(null);
    }

    public static void filterByGenre() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter movie Genre : ");
        for (Genre genre : Genre.values()) {
            System.out.print(genre);
            System.out.println(" , ");
        }
        Genre genre = null;

        try {
            String userInput = input.nextLine().toUpperCase();
            genre = Genre.valueOf(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Genre");
            System.out.println("Try Again");
        }
        movieRepository.filterByGenre(genre);
        main(null);
    }

    public static void filterByRating() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter movie Rating : ");
        System.out.println(
                """
                        1-Movie with 1 in Rating
                        2-Movie between 1 and 2 in Rating
                        3-Movie between 2 and 3 in Rating
                        4-Movie between 3 and 4 in Rating
                        5-Movie between 4 and 5 in Rating
                        """
        );

        int userInput = input.nextInt();

        movieRepository.filterByRating(userInput);
        main(null);
    }

    public static void filterByTitle() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter movie Title : ");
        String title = input.nextLine();
        movieRepository.searchByTitle(title);
        main(null);
    }


}