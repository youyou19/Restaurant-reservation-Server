package reservation_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reservation_server.domain.FileStorage;
import reservation_server.repository.FileStorageRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class FileStorageController {

    @Autowired
    private FileStorageRepository fileStorageRepository;

    @RequestMapping(value = "/file-storage", method = RequestMethod.POST)
    public void handleFileUpload(@RequestBody FileStorage uploadFile) {
        this.fileStorageRepository.save(uploadFile);
    }
}
