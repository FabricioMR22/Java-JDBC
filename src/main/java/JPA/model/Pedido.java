package JPA.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pedidos")
@RequiredArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column
    @Getter @Setter
    private LocalDateTime FechaDeRegistro = LocalDateTime.now();

    @Column
    @Getter @Setter
    private BigDecimal valorTotal;

    @ManyToOne
    @Getter @Setter @NonNull
    private Cliente cliente;

    @OneToMany
    private List<items_pedido> productos;

    public Pedido() {

    }
}
