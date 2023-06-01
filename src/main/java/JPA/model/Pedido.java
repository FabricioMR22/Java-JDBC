package JPA.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

    public Pedido() {

    }
}
