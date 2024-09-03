package DAO.DAOInterfaces;

import Domain.*;

import java.util.List;

public interface MovieDAOInterface {
    void add(Movie movie);

    void delete(int id);

    void update(Movie movie);

    List<Movie> filterByRating(int ratingRange);

    List<Movie> filterByGenre(Genre genre);

    List<Movie> searchByTitle(String title);
}
