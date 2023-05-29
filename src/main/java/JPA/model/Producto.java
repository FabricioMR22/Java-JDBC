package JPA.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Column @Getter @Setter
    private String nombre;

    @Column @Getter @Setter
    private String descripcion;

    @Column @Getter @Setter
    private BigDecimal precio;
}
