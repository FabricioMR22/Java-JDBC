package JPA.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private BigDecimal valorTotal = new BigDecimal(0);

    @ManyToOne
    @Getter @Setter @NonNull
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<items_pedido> items = new ArrayList<>();

    public void agregarItems(items_pedido item){
        item.setPedido(this);
        this.items.add(item);
        this.valorTotal = this.valorTotal.add(item.getValor());
    }

    public Pedido() {

    }
}
