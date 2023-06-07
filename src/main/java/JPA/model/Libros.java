package JPA.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "libros")
public class Libros extends Producto{

    @Getter @Setter
    private String marca;

    @Getter @Setter
    private String modelo;

    public Libros() {
    }

    public Libros(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
}
