package productos;

public class Producto {
    private String nombre;
    private int id;
    private double precio;
    private boolean descuento;


    public Producto(String nombre, int id, double precio){
            setNombre(nombre);
            setId(id);
            setPrecio(precio);
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
