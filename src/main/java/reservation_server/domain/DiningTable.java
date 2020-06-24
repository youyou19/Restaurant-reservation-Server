package reservation_server.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@Data
@Entity
public class DiningTable {
    @Id
    @GeneratedValue
    private Long id;
    private Long capacity;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    public DiningTable(Long capacity, Restaurant restaurant) {
        this.capacity = capacity;
        this.restaurant = restaurant;
    }
}