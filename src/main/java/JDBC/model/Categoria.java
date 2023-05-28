package JDBC.model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private Integer id;
    private String nombre;
    private List<Producto> productoList = new ArrayList<>();

    public Categoria(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarProducto(Producto producto){
        productoList.add(producto);
    }

    public List<Producto> mostrarProducto(){
        return this.productoList;
    }
    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
