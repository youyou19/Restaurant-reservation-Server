package reservation_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reservation_server.domain.DiningTable;

@Repository
public interface DiningTableRepository extends JpaRepository<DiningTable, Long> {
}
