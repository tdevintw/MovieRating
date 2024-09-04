# MovieRating

MovieRating is a Java-based console application that allows users to rate and manage movies. This application provides features such as user registration, movie addition, filtering movies by genre and rating, and searching for movies by title. The system includes a simple in-memory database to store user and movie information, with basic CRUD operations for managing data.

## 🚀 About Me
I'm a passionate developer with a strong interest in building applications that enhance user experience and simplify everyday tasks. With experience in Java development, I focus on creating efficient, maintainable, and scalable software solutions.

## Features

- **User Registration and Login**: Users can create an account and log in to access the application.
- **Movie Management**: Users can add, update, delete, and view movies within the application.
- **Search Movies**: Users can search for movies by title.
- **Filter Movies**: Users can filter movies by genre or rating.
- **View All Movies**: A comprehensive list of all movies in the database can be displayed.

## Code Overview

The project incorporates several important design patterns and Java features:

- **Repository Pattern**: This pattern is used to encapsulate the logic for accessing the movie and user data, with classes such as `MovieRepository` and `UserRepository`.
- **Singleton Pattern**: The `Database` class is implemented as a Singleton to ensure a single instance of the in-memory database throughout the application.
- **Streams**: Java Streams are extensively used for filtering and searching operations, such as filtering movies by genre and rating or searching by title.

### Key Components:

- **Main.java**: Entry point of the application, manages user interactions and menu navigation.
- **User.java**: Represents a user in the system, including attributes like name, password, and age.
- **Movie.java**: Represents a movie entity with attributes such as title, rating, and genre.
- **Database.java**: Simulates an in-memory database storing users and movies. This class follows the Singleton pattern.
- **DAO Layer**: Interfaces and implementations for data access operations, including `MovieDAOInterface` and `UserDAOInterface`.
- **Repository Layer**: Facilitates operations on the database by interacting with the DAO layer, including `MovieRepository` and `UserRepository`.
- **Auth Package**: Contains classes for user authentication, including `Login` and `Register`.

## 🛠 Skills

<p>
    <img src="https://skillicons.dev/icons?i=git,idea,java" height="45" alt="Java, Git, IntelliJ IDEA" />
</p>
