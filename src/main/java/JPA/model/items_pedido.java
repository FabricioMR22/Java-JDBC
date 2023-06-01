package JPA.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "items_pedido")
@RequiredArgsConstructor

public class items_pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter @Setter @NonNull
    private int cantidad;

    @Getter @Setter
    private BigDecimal precioUnitario;

    @ManyToOne
    @Getter @Setter @NonNull
    private Producto producto;

    @ManyToOne
    @Getter @Setter @NonNull
    private Pedido pedido;

    public items_pedido() {
    }
}
