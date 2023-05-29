package JPA.model;

import JPA.model.Categoria;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "productos")
@RequiredArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Column
    @Getter @Setter @NonNull
    private String nombre;

    @Column
    @Getter @Setter @NonNull
    private String descripcion;

    @Column
    @Getter @Setter @NonNull
    private BigDecimal precio;

    private LocalDate fechaRegistro = LocalDate.now();

    @ManyToOne
    @NonNull
    private Categoria categoria;


    public Producto() {

    }
}
