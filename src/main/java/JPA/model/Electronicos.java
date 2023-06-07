package JPA.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "electronicos")
public class Electronicos extends Producto{

    @Getter @Setter
    private String autor;

    @Getter @Setter
    private Integer paginas;

    public Electronicos() {
    }

    public Electronicos(String autor, Integer paginas) {
        this.autor = autor;
        this.paginas = paginas;
    }
}
