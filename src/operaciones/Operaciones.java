package operaciones;
import productos.Producto;

public class Operaciones {

    public void limpiarConsola(){
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    public String conversion(String cadena) { //formatea cadenas para mostrar las palabras con su primer letra capitalizada
        String cadenaFormateada = cadena.trim().toLowerCase();
        String[] palabras = cadenaFormateada.split("\\s+");
        StringBuilder constructor = new StringBuilder();
        for (String palabra : palabras) {
            if (palabra.isEmpty()) {
                continue;
            }
            String palabraCap = palabra.substring(0, 1).toUpperCase() + palabra.substring(1);
            constructor.append(palabraCap).append(" ");
        }
        return constructor.toString().trim();
    }

    public void aplicarDescuento(Producto producto){
        double montoDescontar = producto.getPrecio();
        if(producto.isDescuento()){
            montoDescontar = (montoDescontar/100) * 15;
            double precioDescuento = producto.getPrecio() - montoDescontar;
            producto.setPrecio(precioDescuento);
        }
    }
}
