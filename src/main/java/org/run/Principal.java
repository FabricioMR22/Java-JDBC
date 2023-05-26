package org.run;

import org.controller.ProductController;
import org.model.Producto;


public class Principal {
    private static ProductController controller = new ProductController();

    public static void main(String[] args) {

            //controller.guardar(new Producto("Linternas", "Pilas recargable",60));

            //System.out.println(controller.buscar(22));

            controller.listar().forEach(producto ->
                    System.out.println( producto.getId() +" - "
                            + producto.getNombre() + " - "
                            + producto.getDescripcion() + " - "
                            + producto.getCantidad()
                    )
            );

    }

}
