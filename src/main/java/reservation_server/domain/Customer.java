package reservation_server.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.util.List;
@NoArgsConstructor
@Data
@Entity
public class Customer extends User {
    @Email
    private String email;
    @OneToMany
    private List<Reservation> reservations;
}
