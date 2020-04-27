package anonymous_coder.springbootmongodbdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DBSeeder implements CommandLineRunner {
    private HotelRepository hotelRepository;

    public DBSeeder(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Hotel marriot = new Hotel(
                "Marriot",
                130,
                new Address("Paris", "France"),
                Arrays.asList(
                        new Review("John", 8, false),
                        new Review("Mary", 6,true)
                )
        );

        Hotel ibis = new Hotel(
                "Ibis",
                90,
                new Address("Bangalore", "India"),
                Arrays.asList(
                        new Review("Kunal", 8, false),
                        new Review("Karan", 6,true)
                )

        );

        Hotel taj = new Hotel(
                "Taj",
                 200,
                new Address("Mumbai", "India"),
                new ArrayList<>()

        );

        // drop all hotels
        this.hotelRepository.deleteAll();

        // add above hotels
        List<Hotel> hotels = Arrays.asList(marriot, ibis, taj);
        this.hotelRepository.saveAll(hotels);
    }
}

