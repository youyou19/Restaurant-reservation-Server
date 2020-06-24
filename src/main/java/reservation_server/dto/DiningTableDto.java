package reservation_server.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DiningTableDto {

    private Long id;
    private Long capacity;
    private Long restaurantId;
}
