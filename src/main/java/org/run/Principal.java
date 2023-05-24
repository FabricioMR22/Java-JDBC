package org.run;

import org.controller.ProductController;
import org.model.Producto;

import java.sql.SQLException;

public class Principal {
    private static ProductController pro = new ProductController();

    public static void main(String[] args) {
        try {

            //pro.create(new Producto("Casaca","De cuero",30));

            pro.delete(15);
            pro.listar().forEach(producto ->
                    System.out.println( producto.getId() +" - "
                            + producto.getNombre() + " - "
                            + producto.getDescripcion() + " - "
                            + producto.getCantidad()
                    )
            );

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
