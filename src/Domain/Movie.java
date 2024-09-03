package Domain;

public class Movie {
    private final int id;
    private String title;
    private float rating;
    private Genre genre;

    public Movie(String title, float rating, Genre genre) {
        this.id = (int) (Math.random() * 10000000);
        this.title = title;
        this.rating = rating;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
