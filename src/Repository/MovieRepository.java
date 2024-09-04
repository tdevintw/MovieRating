package Repository;

import DAO.DAOInterfaces.MovieDAOInterface;
import Domain.Genre;
import Domain.Movie;

import java.util.List;

public class MovieRepository {
    private final MovieDAOInterface movieDAO;

    public MovieRepository(MovieDAOInterface movieDAO) {
        this.movieDAO = movieDAO;
    }

    public void add(Movie movie) {
        movieDAO.add(movie);
    }


    public void delete(int id) {
        movieDAO.delete(id);
    }


    public void update(Movie movie) {
        movieDAO.update(movie);
    }


    public List<Movie> filterByRating(int ratingRange) {
        return movieDAO.filterByRating(ratingRange);
    }


    public List<Movie> filterByGenre(Genre genre) {
        return movieDAO.filterByGenre(genre);
    }


    public List<Movie> searchByTitle(String title) {
        return movieDAO.searchByTitle(title);
    }

}
