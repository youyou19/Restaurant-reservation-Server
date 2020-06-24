package reservation_server.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
public class FileStorage {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Long size;
    @Lob
    @Column(name = "DATA", columnDefinition = "LONGTEXT", length = 1000000)
    private byte[] data;
    @Lob
    @Column(columnDefinition = "LONGTEXT", length = 1000000)
    private String base64image;
}