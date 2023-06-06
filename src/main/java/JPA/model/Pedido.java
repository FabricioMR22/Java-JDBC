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

    @ManyToOne(fetch=FetchType.LAZY)
    @Getter @Setter @NonNull
    private Cliente cliente;

    @Getter @Setter
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<items_pedido> items = new ArrayList<>();

    public void agregarItems(items_pedido item){
        item.setPedido(this);
        this.items.add(item);
        this.valorTotal = this.valorTotal.add(item.getValor());
    }

    public Pedido() {

    }

    @Override
    public String toString() {
        items.forEach(
                item -> System.out.println(item.getProducto())
        );

        return String.format("%-5s %-40s %-5s %-40s ",
                id,FechaDeRegistro,valorTotal, cliente.getNombre());
    }
}
