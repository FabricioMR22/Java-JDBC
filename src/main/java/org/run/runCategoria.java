package org.run;

import org.controller.CategoriaController;
import org.controller.ProductController;
import org.model.Categoria;


public class runCategoria {

    public static void main(String[] args) {
        CategoriaController categoriaController = new CategoriaController();
        ProductController productController = new ProductController();

        categoriaController.listar().forEach(
                categoria -> {
                    System.out.printf("%-15s%n", categoria.getNombre());
                    productController.listar(categoria).forEach(
                            producto -> System.out.printf("%-15s %-10s %-5s%n",
                                    " ",
                                    producto.getNombre(),
                                    producto.getCantidad())
                    );
                }
        );

    }

}
