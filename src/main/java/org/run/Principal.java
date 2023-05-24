package org.run;

import org.controller.ProductController;
import org.model.Producto;

import java.sql.SQLException;

public class Principal {
    private static ProductController pro = new ProductController();

    public static void main(String[] args) {
        try {

            pro.create(new Producto("Polo';", "Algodon",25));

            System.out.println(pro.read(36));

            System.out.println(
                    pro.delete(35)
            );

            Producto uProducto = new Producto(25,"Camise","Falsa",23);

            System.out.println(
                    pro.update(uProducto)
            );

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
