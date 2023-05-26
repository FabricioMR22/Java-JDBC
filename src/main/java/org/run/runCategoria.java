package org.run;

import org.controller.CategoriaController;


public class runCategoria {
    private static CategoriaController controller = new CategoriaController();

    public static void main(String[] args) {



        controller.listar().forEach(categoria ->
                System.out.println( categoria)
        );

        controller.listar().forEach(categoria ->
                System.out.println( "Nombre cat: "+ categoria.getNombre())
        );

    }

}
