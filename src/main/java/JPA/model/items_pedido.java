package JPA.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "items_pedido")
public class items_pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter @Setter
    private int cantidad;

    @Getter @Setter
    private BigDecimal precioUnitario;

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter @Setter
    private Producto producto;

    @ManyToOne
    @Getter @Setter
    private Pedido pedido;

    public items_pedido() {
    }

    public items_pedido(int cantidad, Producto producto, Pedido pedido) {
        this.cantidad = cantidad;
        this.precioUnitario = producto.getPrecio();
        this.producto = producto;
        this.pedido = pedido;
    }

    public BigDecimal getValor(){
        return precioUnitario.multiply(new BigDecimal(cantidad));
    }

    @Override
    public String toString() {
        return "items_pedido{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                ", producto=" + producto +
                ", pedido=" + pedido +
                '}';
    }
}
