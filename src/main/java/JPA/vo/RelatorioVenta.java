package JPA.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class RelatorioVenta {

    @Getter @Setter
    private String nombreProducto;

    @Getter @Setter
    private Long CantidadProducto;

    @Getter @Setter
    private LocalDateTime UltimaCompra;

    public RelatorioVenta(String nombreProducto, Long cantidadProducto, LocalDateTime ultimaCompra) {
        this.nombreProducto = nombreProducto;
        CantidadProducto = cantidadProducto;
        UltimaCompra = ultimaCompra;
    }

    @Override
    public String toString() {
        return "RelatorioVenta{" +
                "nombreProducto='" + nombreProducto + '\'' +
                ", CantidadProducto=" + CantidadProducto +
                ", UltimaCompra=" + UltimaCompra +
                '}';
    }
}
