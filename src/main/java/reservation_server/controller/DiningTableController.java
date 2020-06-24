package reservation_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reservation_server.domain.DiningTable;
import reservation_server.domain.Restaurant;
import reservation_server.dto.DiningTableDto;
import reservation_server.exception.NotFoundException;
import reservation_server.service.DiningTableService;
import reservation_server.service.RestaurantService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class DiningTableController {

    @Autowired
    private DiningTableService diningTableService;

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping(value = "/dining-tables")
    public List<DiningTable> all() {
        return diningTableService.findAll();
    }

    @GetMapping(value = "/dining-tables/{id}")
    public DiningTable one(@PathVariable Long id) {
        return this.diningTableService.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    @PostMapping(value = "/dining-tables")
    public DiningTable newDiningTable(@RequestBody DiningTableDto diningTableDto) {
        Restaurant restaurant = restaurantService.getOne(diningTableDto.getRestaurantId());
        return diningTableService.save(new DiningTable(diningTableDto.getCapacity(), restaurant));
    }

    @PutMapping(value = "/dining-tables/{id}")
    public DiningTable replaceDiningTable(@PathVariable Long id, @RequestBody DiningTable newDiningTable) {
        return this.diningTableService.save(newDiningTable);
    }

    @DeleteMapping(value = "/dining-tables/{id}")
    public void delete(@PathVariable Long id) {
        diningTableService.deleteById(id);
    }
}
