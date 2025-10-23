import productos.Producto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void limpiarConsola(){
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }



    public static String conversion(String cadena) { //formatea cadenas para mostrar las palabras con su primer letra capitalizada
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

   public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 9) {
            System.out.println("""
                    Bienvenido al Sistema de Gestion TalTech
                    Selecciona una opcion
                    1-Crear y guardar un nuevo producto
                    2-Obtener listado de productos almacenados
                    3-Obtener productos por nombre
                    4-Eliminar un producto por ID
                    5-Editar un producto
                    9-Salir
                    """);
            opcion = input.nextInt();
            limpiarConsola();
            /*Cuando se requiere nextLine del Scanner "input" en las siguientes lineas luego de obtener
            un valor numerico, un \n residual provoca problemas en el funcionamiento del programa. Se soluciona
            inicializando la variable con ese \n residual y luego modificandola con otra iteracion del Scanner
            "input"*/
            switch (opcion) {
                case 1: {
                    //Creacion de un producto nuevo
                    input.nextLine(); //Precargado nextLine() con \n que quedo de la iteracion previa
                    System.out.println("Introduce el nombre del producto");
                    String inNombre = conversion(input.nextLine()); //reasignado inNombre con nextLine() correspondiente
                    System.out.println("Introduce el precio del producto");
                    double inPrecio = input.nextDouble();
                    Producto inProducto = new Producto(inNombre, inPrecio);
                    Producto.listaProductos.add(inProducto);
                    limpiarConsola();
                    break;
                }

                case 2: {
                    //Obtener todos los productos listados
                    if (Producto.listaProductos.isEmpty()){
                        System.out.println("No hay productos listados aún.");
                    }
                    for (Producto productos : Producto.listaProductos) {
                        System.out.println((String.format("Producto: %s - ID: %s - Precio: %s", productos.getNombre(), productos.getId(), productos.getPrecio())));
                    }
                    limpiarConsola();
                    break;
                }

                case 3: {
                    //Busca coincidencia total o parcial en .getNombre()
                    input.nextLine();// precargado \n residual
                    System.out.println("Introduce el nombre del producto a buscar");
                    String busqueda = conversion(input.nextLine());
                    for (Producto productos : Producto.listaProductos){
                        if (productos.getNombre().contains(busqueda)){
                            System.out.println((String.format("Producto: %s - ID: %s - Precio: %s", productos.getNombre(), productos.getId(), productos.getPrecio())));
                        }
                    }
                    limpiarConsola();
                    break;
                }

                case 4: {
                    //Busca y elimina productos por Id
                    if (Producto.listaProductos.isEmpty()){
                        System.out.println("No hay productos listados aún.");
                        limpiarConsola();
                        break;
                    }
                    System.out.println("Introduce el Id del producto a eliminar");
                    for (Producto productos : Producto.listaProductos) {
                        System.out.println((String.format("Producto: %s - ID: %s - Precio: %s", productos.getNombre(), productos.getId(), productos.getPrecio())));
                    }
                    int delId = input.nextInt();
                    int indiceEliminar;
                    Producto.listaProductos.removeIf(producto -> producto.getId() == delId); //se usa removeIf evaluando igualdad entre getId() del elemento iterado y delId
                    limpiarConsola();
                    break;
                }

                case 5:{
                    System.out.println("Selecciona el Id del producto a modificar");
                    for (Producto productos : Producto.listaProductos) {
                        System.out.println((String.format("Producto: %s - ID: %s - Precio: %s", productos.getNombre(), productos.getId(), productos.getPrecio())));
                    }
                    int modId = input.nextInt();
                    for (Producto productos : Producto.listaProductos){
                        if(productos.getId() == modId){
                            input.nextLine();
                            System.out.println("Introduce un nuevo nombre (OMITÍ PULSANDO ENTER)");
                            String nuevoNombre = conversion(input.nextLine());
                            System.out.println("Introduce un nuevo precio (OMITÍ ASIGNANDO 0 Y PULSANDO ENTER)"); //Solucion encontrada, si no se asigna un valor en variable double o int el scanner ignora los saltos de linea
                            double nuevoPrecio = input.nextDouble();
                            if(nuevoNombre.isEmpty() && nuevoPrecio == 0){
                                System.out.println("No se han registrado cambios");
                                continue;
                            } else if (nuevoNombre.isEmpty()){
                                productos.setPrecio(nuevoPrecio);
                                System.out.println("Cambios Registrados: \n" + (String.format("Producto: %s - ID: %s - Precio: %s", productos.getNombre(), productos.getId(), productos.getPrecio())));
                            }else if (nuevoPrecio == 0){
                                productos.setNombre(nuevoNombre);
                                System.out.println("Cambios Registrados: \n" + (String.format("Producto: %s - ID: %s - Precio: %s", productos.getNombre(), productos.getId(), productos.getPrecio())));
                            }
                            else{
                                productos.setNombre(nuevoNombre);
                                productos.setPrecio(nuevoPrecio);
                                System.out.println("Cambios Registrados: \n" + (String.format("Producto: %s - ID: %s - Precio: %s", productos.getNombre(), productos.getId(), productos.getPrecio())));
                            }
                        }
                    }
                    limpiarConsola();
                    break;
                }
            }
        }
    }
}



