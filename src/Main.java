import productos.Producto;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    String cadenaOriginal = " té CHAI ";


    public void conversion(String cadena) {
        String cadenaFormateada = cadena.trim().toLowerCase();
        System.out.println(cadenaFormateada);
        String[] palabras = cadenaFormateada.split(" ");
        System.out.println(palabras[0].substring(0, 1).toUpperCase());
        palabras[0] = palabras[0].substring(0, 1).toUpperCase() + palabras[0].substring(1);
        palabras[1] = palabras[1].substring(0, 1).toUpperCase() + palabras[1].substring(1);
        System.out.println(palabras[0] + " " + palabras[1]);
    }
    ArrayList <Producto> listaProductos = new ArrayList<>();

    void main(String[] args) {
        /*System.out.println(cadenaOriginal);
        conversion(cadenaOriginal);
        Producto mouse = new Producto("mouse", 1, 1000);
        Producto teclado = new Producto("TECLADO", 2, 3000);
        listaProductos.add(mouse);
        listaProductos.add(teclado);*/
        Scanner input = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 9) {
            System.out.println("""
                    Bienvenido al Sistema de Gestion TalTech
                    Selecciona una opcion
                    1- Crear y guardar un nuevo producto
                    2-Obtener listado de productos almacenados
                    3-Obtener productos por nombre
                    4-Eliminar un producto por ID
                    """);
            opcion = input.nextInt();
            /*Cuando se requiere nextLine del Scanner "input" en las siguientes lineas luego de obtener
            un valor numerico, un /n residual provoca problemas en el funcionamiento del programa. Se soluciona
            inicializando la variable con ese /n residual y luego modificandola con otra iteracion del Scanner
            "input"*/
            switch (opcion) {
                case 1: {
                    //Creacion de un producto nuevo
                    String inNombre = input.nextLine(); //Preasignado nextLine() por /n que quedo de la iteracion previa
                    System.out.println("Introduce el nombre del producto");
                    inNombre = input.nextLine(); //reasignado inNombre con nextLine() correspondiente
                    System.out.println("Introduce un ID para el producto");
                    int inId = input.nextInt();
                    System.out.println("Introduce el precio del producto");
                    double inPrecio = input.nextDouble();
                    Producto inProducto = new Producto(inNombre, inId, inPrecio);
                    listaProductos.add(inProducto);
                    break;
                }

                case 2: {
                    //bucle para obtener todos los productos
                    if (listaProductos.isEmpty()){
                        System.out.println("No hay productos listados aún.");
                    }
                    for (Producto productos : listaProductos) {
                        System.out.println((String.format("Producto: %s - ID: %s - Precio: %s", productos.getNombre(), productos.getId(), productos.getPrecio())));
                    }
                    break;
                }

                case 3: {
                    String busqueda = input.nextLine();// /n residual curado
                    System.out.println("Introduce el nombre del producto a buscar");
                    busqueda = input.nextLine();
                    for (Producto productos : listaProductos){
                        if (productos.getNombre().contains(busqueda)){
                            System.out.println((String.format("Producto: %s - ID: %s - Precio: %s", productos.getNombre(), productos.getId(), productos.getPrecio())));
                        }
                    }
                    break;
                }

                case 4: {
                    System.out.println("Introduce el id del producto a eliminar");
                    int delId = input.nextInt();
                    int indiceEliminar;
                    listaProductos.removeIf(producto -> producto.getId() == delId); //se usa removeIf evaluando igualdad entre getId() del elemento iterado y delId
                    break;
                }
            }
        }
    }
}

