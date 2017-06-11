package Bean;

import javax.persistence.*;

/**
 * Created by mm on 2017/6/11.
 */
@Entity
public class Ticket {
    private int id;
    private String movieName;
    private String theaterName;
    private Double price;
    private String address;

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
    @Column(name = "movieName")
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @Basic
    @Column(name = "theaterName")
    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (id != ticket.id) return false;
        if (movieName != null ? !movieName.equals(ticket.movieName) : ticket.movieName != null) return false;
        if (theaterName != null ? !theaterName.equals(ticket.theaterName) : ticket.theaterName != null) return false;
        if (price != null ? !price.equals(ticket.price) : ticket.price != null) return false;
        if (address != null ? !address.equals(ticket.address) : ticket.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (movieName != null ? movieName.hashCode() : 0);
        result = 31 * result + (theaterName != null ? theaterName.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
