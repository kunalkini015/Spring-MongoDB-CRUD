package anonymous_coder.springbootmongodbdemo;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private HotelRepository hotelRepository;

    public HotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @GetMapping("/all")
    public List<Hotel> getAll(){
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels;
    }

    @PostMapping
    public void insert(@RequestBody Hotel hotel)
    {
        this.hotelRepository.insert(hotel);
    }

    @PutMapping
    public void update(@RequestBody Hotel hotel)
    {
        this.hotelRepository.save(hotel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id)
    {
         this.hotelRepository.deleteById(id);
    }


    @GetMapping("/{id}")
    public Optional<Hotel> getById(@PathVariable("id") String id)
    {
        return this.hotelRepository.findById(id);
    }

    @GetMapping("/price/{price}")
    public List<Hotel> getByPricePerNightLessThan(@PathVariable("price") int maxPrice)
    {
        return this.hotelRepository.findByPricePerNightLessThan(maxPrice);
    }

    @GetMapping("/city/{cityName}")
    public List<Hotel> findByCity(@PathVariable("cityName") String city)
    {
        return this.hotelRepository.findByCity(city);
    }


}
