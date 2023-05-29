package JPA.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

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

    public Producto() {

    }
}
