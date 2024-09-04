package DAO.DAOImplementations;

import DAO.DAOInterfaces.MovieDAOInterface;
import Database.Database;
import Domain.Genre;
import Domain.Movie;

import java.util.List;
import java.util.Map;


public class MovieDAOImplementation implements MovieDAOInterface {

    @Override
    public void add(Movie movie) {
        Database database = Database.getDatabase();
        try {
            database.setMovie(movie);
        } catch (Exception e) {
            System.err.println("The movie can't be added to the Database");
        }
    }

    @Override
    public void update(Movie movie) {
        Database.getDatabase().getMovies().replace(movie.getId(), movie);
    }

    @Override
    public void delete(int id) {
        Database.getDatabase().getMovies().remove(id);
    }

    @Override
    public Map<Integer, Movie> getAllMovies() {
       return  Database.getDatabase().getMovies();
    }


    @Override
    public List<Movie> filterByGenre(Genre genre) {
        return Database.getDatabase().getMovies().values().stream().filter(movie -> movie.getGenre().equals(genre)).toList();
    }

    @Override
    public List<Movie> filterByRating(int ratingRange) {
        return switch (ratingRange) {
            case 1 ->
                    Database.getDatabase().getMovies().values().stream().filter(movie -> movie.getRating() == 1).toList();
            case 2 ->
                    Database.getDatabase().getMovies().values().stream().filter(movie -> 1 < movie.getRating() && movie.getRating() <= 2).toList();
            case 3 ->
                    Database.getDatabase().getMovies().values().stream().filter(movie -> 2 < movie.getRating() && movie.getRating() <= 3).toList();
            case 4 ->
                    Database.getDatabase().getMovies().values().stream().filter(movie -> 3 < movie.getRating() && movie.getRating() <= 4).toList();
            case 5 ->
                    Database.getDatabase().getMovies().values().stream().filter(movie -> 4 < movie.getRating() && movie.getRating() <= 5).toList();
            default -> null;
        };
    }


    @Override
    public List<Movie> searchByTitle(String title) {
        return Database.getDatabase().getMovies().values().stream().filter(movie -> movie.getTitle().contains(title)).toList();
    }
}


