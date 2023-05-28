package JDBC.run;

import JDBC.controller.ProductController;

public class runProducto {
    public static void main(String[] args) {
        ProductController productController = new ProductController();

        //productController.guardar(new Producto("Mouse","Inalambrico",30),3);


        productController.listar().forEach(producto -> System.out.println(producto));
    }
}
