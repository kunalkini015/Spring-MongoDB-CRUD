package anonymous_coder.springbootmongodbdemo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document(collection="hotels")
public class Hotel {

    @Id
    private String id;


    private String name;
    private int pricePerNight;
    private Address address;
    private List<Review> reviews;

    protected Hotel() {this.reviews = new ArrayList();
    }

    public Hotel(String name, int pricePerNight, Address address, List<Review> reviews) {
        this.name = name;
        this.pricePerNight = pricePerNight;
        this.address = address;
        this.reviews = reviews;
    }

    public String getName() {
        return name;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public Address getAddress() {
        return address;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public String getId() {
        return id;
    }
}
