package Database;

import Domain.Movie;
import Domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    private static Database database;
    private List<User> users;
    private Map<Integer, Movie> movies;

    private Database() {

    }


    public static Database getDatabase() {
        if (database == null) {
            database = new Database();
            database.users = new ArrayList<>();
            database.movies = new HashMap<>();
        }
        return database;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void setUser(User user) {
        users.add(user);
    }

    public Map<Integer, Movie> getMovies() {
        return movies;
    }

    public void setMovie(Movie movie) {
        movies.put(movie.getId(), movie);
    }
}
