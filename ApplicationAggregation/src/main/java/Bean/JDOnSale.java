package Bean;

import javax.persistence.*;

/**
 * Created by mm on 2017/6/11.
 */
@Entity
public class Jdonsale {
    private String movieId;
    private String movieName;
    private Double score;
    private String director;
    private String tag;
    private String introduction;
    private String times;

    @Id
    @Column(name = "movieId")
    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    @Basic
    @Column(name = "movieName")
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @Basic
    @Column(name = "score")
    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Basic
    @Column(name = "director")
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Basic
    @Column(name = "tag")
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Basic
    @Column(name = "introduction")
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Basic
    @Column(name = "times")
    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jdonsale jdonsale = (Jdonsale) o;

        if (movieId != null ? !movieId.equals(jdonsale.movieId) : jdonsale.movieId != null) return false;
        if (movieName != null ? !movieName.equals(jdonsale.movieName) : jdonsale.movieName != null) return false;
        if (score != null ? !score.equals(jdonsale.score) : jdonsale.score != null) return false;
        if (director != null ? !director.equals(jdonsale.director) : jdonsale.director != null) return false;
        if (tag != null ? !tag.equals(jdonsale.tag) : jdonsale.tag != null) return false;
        if (introduction != null ? !introduction.equals(jdonsale.introduction) : jdonsale.introduction != null)
            return false;
        if (times != null ? !times.equals(jdonsale.times) : jdonsale.times != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = movieId != null ? movieId.hashCode() : 0;
        result = 31 * result + (movieName != null ? movieName.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (director != null ? director.hashCode() : 0);
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        result = 31 * result + (introduction != null ? introduction.hashCode() : 0);
        result = 31 * result + (times != null ? times.hashCode() : 0);
        return result;
    }
}
