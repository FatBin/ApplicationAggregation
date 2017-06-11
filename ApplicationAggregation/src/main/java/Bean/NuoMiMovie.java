package Bean;

import javax.persistence.*;

/**
 * Created by mm on 2017/6/11.
 */
@Entity
public class Nuomimovie {
    private String name;
    private String stars;
    private String intro;
    private String detailLink;
    private String director;
    private String rank;
    private String country;
    private String duration;
    private String startDate;

    @Id
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "stars")
    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    @Basic
    @Column(name = "intro")
    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Basic
    @Column(name = "detailLink")
    public String getDetailLink() {
        return detailLink;
    }

    public void setDetailLink(String detailLink) {
        this.detailLink = detailLink;
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
    @Column(name = "rank")
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "duration")
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "startDate")
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Nuomimovie that = (Nuomimovie) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (stars != null ? !stars.equals(that.stars) : that.stars != null) return false;
        if (intro != null ? !intro.equals(that.intro) : that.intro != null) return false;
        if (detailLink != null ? !detailLink.equals(that.detailLink) : that.detailLink != null) return false;
        if (director != null ? !director.equals(that.director) : that.director != null) return false;
        if (rank != null ? !rank.equals(that.rank) : that.rank != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (duration != null ? !duration.equals(that.duration) : that.duration != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (stars != null ? stars.hashCode() : 0);
        result = 31 * result + (intro != null ? intro.hashCode() : 0);
        result = 31 * result + (detailLink != null ? detailLink.hashCode() : 0);
        result = 31 * result + (director != null ? director.hashCode() : 0);
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        return result;
    }
}
