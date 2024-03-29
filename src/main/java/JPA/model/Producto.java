package JPA.model;

import JPA.model.Categoria;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "productos")
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQuery(name="Producto.consultaPrecio",query = "SELECT P.precio FROM Producto AS P WHERE P.nombre=:nombre")
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

    private LocalDateTime fechaRegistro = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter @Setter @NonNull
    private Categoria categoria;

    public Producto() {

    }

    @Override
    public String toString() {
        return String.format("| %-5d | %-15s | %-20s | %-10.2f | %-20s | %-15s |",
                id, nombre, descripcion, precio, fechaRegistro, categoria);
    }
}
