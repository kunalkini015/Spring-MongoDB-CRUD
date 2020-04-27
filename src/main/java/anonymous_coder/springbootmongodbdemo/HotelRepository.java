package anonymous_coder.springbootmongodbdemo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {
    Optional<Hotel> findById(String id); // Filter available in mongo repository

    List<Hotel> findByPricePerNightLessThan(int maxPrice); // Filter available in mongo repository


    @Query(value = "{'address.city':?0}")
    List<Hotel> findByCity(String city);


}
