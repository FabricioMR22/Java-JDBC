package org.run;

import org.controller.CategoriaController;
import org.controller.ProductController;
import org.model.Producto;


public class Principal {


    public static void main(String[] args) {

        CategoriaController controller = new CategoriaController();

        controller.listar().forEach(categoria ->
                System.out.println( categoria)
        );

    }

}
