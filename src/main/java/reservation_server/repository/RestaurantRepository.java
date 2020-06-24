package reservation_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import reservation_server.domain.Restaurant;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query("from Restaurant r " +
            " join fetch r.diningTables tab" +
            " where r.address.state like :state " +
            " and tab.date is null or tab.date <> :date or (tab.date = :date and(:startTime not between tab.startTime and tab.endTime)) order by r.name desc")
    List<Restaurant> findAll(String state, LocalDate date, LocalTime startTime);

}
