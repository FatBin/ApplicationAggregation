package Bean;

import javax.persistence.*;

/**
 * Created by mm on 2017/6/11.
 */
@Entity
public class Jdticket {
    private int id;
    private String movie;
    private String movieId;
    private String theater;
    private Integer theaterId;
    private String date;
    private String begin;
    private String end;
    private String language;
    private String hall;
    private String price;
    private String sponsor;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "movie")
    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    @Basic
    @Column(name = "movieId")
    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    @Basic
    @Column(name = "Theater")
    public String getTheater() {
        return theater;
    }

    public void setTheater(String theater) {
        this.theater = theater;
    }

    @Basic
    @Column(name = "TheaterId")
    public Integer getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(Integer theaterId) {
        this.theaterId = theaterId;
    }

    @Basic
    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    @Column(name = "begin")
    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    @Basic
    @Column(name = "end")
    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Basic
    @Column(name = "language")
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Basic
    @Column(name = "hall")
    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    @Basic
    @Column(name = "price")
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Basic
    @Column(name = "sponsor")
    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jdticket jdticket = (Jdticket) o;

        if (id != jdticket.id) return false;
        if (movie != null ? !movie.equals(jdticket.movie) : jdticket.movie != null) return false;
        if (movieId != null ? !movieId.equals(jdticket.movieId) : jdticket.movieId != null) return false;
        if (theater != null ? !theater.equals(jdticket.theater) : jdticket.theater != null) return false;
        if (theaterId != null ? !theaterId.equals(jdticket.theaterId) : jdticket.theaterId != null) return false;
        if (date != null ? !date.equals(jdticket.date) : jdticket.date != null) return false;
        if (begin != null ? !begin.equals(jdticket.begin) : jdticket.begin != null) return false;
        if (end != null ? !end.equals(jdticket.end) : jdticket.end != null) return false;
        if (language != null ? !language.equals(jdticket.language) : jdticket.language != null) return false;
        if (hall != null ? !hall.equals(jdticket.hall) : jdticket.hall != null) return false;
        if (price != null ? !price.equals(jdticket.price) : jdticket.price != null) return false;
        if (sponsor != null ? !sponsor.equals(jdticket.sponsor) : jdticket.sponsor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (movie != null ? movie.hashCode() : 0);
        result = 31 * result + (movieId != null ? movieId.hashCode() : 0);
        result = 31 * result + (theater != null ? theater.hashCode() : 0);
        result = 31 * result + (theaterId != null ? theaterId.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (begin != null ? begin.hashCode() : 0);
        result = 31 * result + (end != null ? end.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (hall != null ? hall.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (sponsor != null ? sponsor.hashCode() : 0);
        return result;
    }
}
