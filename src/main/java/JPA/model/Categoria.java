package JPA.model;

import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria{

    @EmbeddedId
    private CategoriaId categoriaId;

    public Categoria(String nombre,String contrase) {
        this.categoriaId = new CategoriaId(nombre,contrase);
    }

    public Categoria() {
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + categoriaId +
                ", nombre='" + categoriaId.getNombre() + '\'' +
                '}';
    }
}
