package productos;

import java.util.ArrayList;

public class Producto {
    private String nombre;
    private int id;
    private double precio;
    private boolean descuento;

    public static ArrayList<Producto> listaProductos = new ArrayList<>();

    public int idProducto(){
        this.id=listaProductos.size();
        this.id++;
        return this.id;
    }

    public Producto(String nombre, double precio){
            setNombre(nombre);
            setPrecio(precio);
            setId(idProducto());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDescuento() {
        return this.descuento;
    }

    public void setDescuento(boolean descuento) {
        this.descuento = descuento;
    }
}
