package JPA.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CategoriaId implements Serializable {
    private static final long serialVersionUID = 4198020985304539350L;

    @Getter @Setter
    private String nombre;

    @Getter @Setter
    private String password;

    public CategoriaId() {
    }

    public CategoriaId(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoriaId that = (CategoriaId) o;

        if (!nombre.equals(that.nombre)) return false;
        return password.equals(that.password);
    }

    @Override
    public int hashCode() {
        int result = nombre.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }
}
