package reservation_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reservation_server.domain.User;

import java.util.Optional;

@Repository
public interface LoginRepository  extends JpaRepository<User,Long> {
    public Optional<User> findByPasswordAndAndUsername(String password, String username);
}
