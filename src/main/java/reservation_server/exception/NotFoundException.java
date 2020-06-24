package reservation_server.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(Long id) {
        super("Could not find an entity for given id: " + id);
    }
}
