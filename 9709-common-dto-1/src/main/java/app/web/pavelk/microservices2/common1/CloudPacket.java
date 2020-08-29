package app.web.pavelk.microservices2.common1;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"message"})
public class CloudPacket implements Serializable {
    private static final long serialVersionUID = -3893781989609414338L;
    private Long id;
    private String message;


    public CloudPacket(Long id, String message) {
        this.id = id;
        this.message = message;
    }
}
