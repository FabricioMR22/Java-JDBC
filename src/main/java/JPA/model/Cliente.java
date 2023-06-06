package JPA.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Embedded
    @Getter @Setter
    private ClienteDatosPersonales datosPersonales;

    public Cliente(String nombre, Integer dni) {
        this.datosPersonales = new ClienteDatosPersonales(nombre,dni);
    }


}
