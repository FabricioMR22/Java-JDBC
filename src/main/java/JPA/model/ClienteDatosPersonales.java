package JPA.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@RequiredArgsConstructor
@Embeddable
public class ClienteDatosPersonales {

    @Column(name = "nombres")
    @Getter @Setter @NonNull
    private String nombre;

    @Column
    @Getter @Setter @NonNull
    private Integer dni;

    public ClienteDatosPersonales() {
    }
}
