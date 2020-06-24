package reservation_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reservation_server.domain.DiningTable;
import reservation_server.repository.DiningTableRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DiningTableService {

    @Autowired
    private DiningTableRepository diningTableRepository;

    public List<DiningTable> findAll() {
        return diningTableRepository.findAll();
    }

    public DiningTable getOne(Long id) {
        return this.diningTableRepository.getOne(id);
    }

    public DiningTable save(DiningTable newDiningTable) {
        return this.diningTableRepository.save(newDiningTable);
    }

    public void deleteById(Long id) {
        this.diningTableRepository.deleteById(id);
    }

    public Optional<DiningTable> findById(Long id) {
        return this.diningTableRepository.findById(id);
    }
}
