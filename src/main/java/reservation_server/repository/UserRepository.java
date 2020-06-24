package reservation_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import reservation_server.domain.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
