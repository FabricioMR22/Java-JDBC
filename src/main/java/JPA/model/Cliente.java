package JPA.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
@RequiredArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column
    @Getter @Setter @NonNull
    private String nombre;

    @Column
    @Getter @Setter @NonNull
    private Integer dni;

    public Cliente() {

    }
}
