package reservation_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reservation_server.domain.FileStorage;

@Repository
public interface FileStorageRepository extends JpaRepository<FileStorage, Long> {
    FileStorage save(FileStorage fileStorage);
}
