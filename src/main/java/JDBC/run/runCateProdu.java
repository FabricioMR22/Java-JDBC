package JDBC.run;

import JDBC.controller.CategoriaController;

public class runCateProdu {
    public static void main(String[] args) {
        CategoriaController categoriaController = new CategoriaController();

        categoriaController.cargaReporte().forEach(
                categoria -> {
                    System.out.printf("%-15s%n", categoria.getNombre());
                    categoria.mostrarProducto().forEach(
                            producto -> System.out.printf("%-15s %-20s %-5s%n",
                                    " ",
                                    producto.getNombre(),
                                    producto.getCantidad())
                    );
                }
        );


    }
}
