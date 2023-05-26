package org.run;

import org.controller.ProductController;

public class runProducto {
    public static void main(String[] args) {
        ProductController productController = new ProductController();

        System.out.println(productController.buscar(1));
        System.out.println(productController.buscar(3));
    }
}
