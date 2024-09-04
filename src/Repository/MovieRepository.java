package Repository;

import DAO.DAOInterfaces.MovieDAOInterface;
import Domain.Genre;
import Domain.Movie;

import java.util.List;
import java.util.Map;

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

    public void getAllMovies() {
        if (movieDAO.getAllMovies().isEmpty()) {
            System.out.println("There is no movies");
        } else {
            for (Movie movie : movieDAO.getAllMovies().values()) {
                System.out.println(" Movie id : " + movie.getId() + "Movie name : " + movie.getTitle() + "Movie rating: " + movie.getRating() + "Movie Genre: " + movie.getGenre());
            }
        }


    }

    public void update(Movie movie) {
        movieDAO.update(movie);
    }


    public void filterByRating(int ratingRange) {
        if (movieDAO.filterByRating(ratingRange).isEmpty()) {
            System.out.println("There is no movies");

        } else {
            for (Movie movie : movieDAO.filterByRating(ratingRange)) {
                System.out.println(" Movie id : " + movie.getId() + "Movie name : " + movie.getTitle() + "Movie rating: " + movie.getRating() + "Movie Genre: " + movie.getGenre());
            }
        }

    }


    public void filterByGenre(Genre genre) {
        List<Movie> filteredMovies = movieDAO.filterByGenre(genre);
        if (filteredMovies.isEmpty()) {
            System.out.println("There is no movies");

        } else {
            for (Movie movie : filteredMovies) {
                System.out.println("Movie id : " + movie.getId() +
                        " Movie name : " + movie.getTitle() +
                        " Movie rating: " + movie.getRating() +
                        " Movie Genre: " + movie.getGenre());
            }
        }
    }


    public void searchByTitle(String title) {
        if (movieDAO.searchByTitle(title).isEmpty()) {
            System.out.println("There is no movies");
        } else {
            for (Movie movie : movieDAO.searchByTitle(title)) {
                System.out.println(" Movie id : " + movie.getId() + "Movie name : " + movie.getTitle() + "Movie rating: " + movie.getRating() + "Movie Genre: " + movie.getGenre());
            }
        }

    }

}
