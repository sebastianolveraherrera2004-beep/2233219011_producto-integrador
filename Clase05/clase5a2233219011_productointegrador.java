package proyecto_integrador;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.text.SimpleDateFormat;
public class clase5a2233219011_productointegrador{
    static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
    static String[][] productos;
    public static String MostrarMenu(String[] opciones) {
        String cadena = "";
        int i = 0;
        while (i < opciones.length) {
            cadena += (i + 1) + ".- " + opciones[i] + "\n";
            i++;
        }
        return cadena;
    }
    public static String Dialogo(String texto) {
        String cadena = "";
        try {
            System.out.print(texto + ": ");
            cadena = teclado.readLine();
        } catch (IOException e) {
            System.out.println("Error");
        }
        return cadena;
    }
    public static String DesplegarMenu(String Titulo1, String[] menu) {
        String cadena;
        cadena = Titulo1 + "\n\n";
        cadena += MostrarMenu(menu);
        cadena += "elije una opcion";
        return Dialogo(cadena);
    }
    public static String Leer(String texto) {
        String cadena = "";
        cadena = Dialogo(texto);
        if (cadena != null) {
            cadena = cadena.trim();
            if (cadena.isEmpty()) {
                cadena = null;
            }
        } else {
            cadena = null;
        }
        return cadena;
    }
    public static boolean EsNumeroEntero(String dato) {
        if (dato == null || dato.isEmpty()) {
            return false;
        }
        for (char c : dato.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    public static boolean EsNumeroDouble(String dato) {
        if (dato == null || dato.isEmpty()) {
            return false;
        }
        boolean valido = false;
        for (char c : dato.toCharArray()) {
            if (!Character.isDigit(c)) {
                if (c == '.' && !valido) {
                    valido = true;
                } else {
                    return false;
                }
            }
        }
        return valido;
    }
    public static boolean EvaluarNumerico(String dato, int tipo) {
        boolean valida = false;
        switch (tipo) {
            case 1:
                if (EsNumeroEntero(dato)) {
                    valida = true;
                }
                break;
            case 2:
                if (EsNumeroDouble(dato)) {
                    valida = true;
                }
                break;
        }
        return valida;
    }
    public static String RellenarEspacios(String dato, int tamano) {
        String cadena = dato;
        for (int i = dato.length(); i < tamano; i++) {
            cadena += " ";
        }
        return cadena;
    }
    public static String IdTicketSiguiente(String idticket) {
        String idticketnext = "";
        int num = Integer.parseInt(idticket) + 1;
        if (num < 10) {
            idticketnext = "00" + String.valueOf(num);
        } else if (num >= 10 && num <= 99) {
            idticketnext = "0" + String.valueOf(num);
        } else {
            idticketnext = String.valueOf(num);
        }
        return idticketnext;
    }
    public static String Fecha() {
        Date fecha = new Date();
        SimpleDateFormat formatodia = new SimpleDateFormat("dd-MM-yyyy");
        return formatodia.format(fecha);
    }
    public static String[][] CargarProductos() {
        String[][] producto = {
            {"001", "Arroz 1kg", "35", "10"},
            {"002", "Azucar 1kg", "25", "10"},
            {"003", "Harina 1kg", "28", "10"},
            {"004", "Aceite 1L", "50", "10"},
            {"005", "Leche 1L", "35", "10"},
            {"006", "Huevos 12 unidades", "45", "10"},
            {"007", "Fideos 500g", "20", "10"},
            {"008", "Sal 1kg", "15", "10"},
            {"009", "Pasta de tomate 400g", "25", "10"},
            {"010", "Atun lata 170g", "35", "10"}
        };
        return producto;
    }
    public static String MostrarProducto(String[] vproducto) {
        String codigo = RellenarEspacios(vproducto[0], 5);
        String producto = RellenarEspacios(vproducto[1], 30);
        String precio = RellenarEspacios(vproducto[2], 10);
        String cantidad = RellenarEspacios(vproducto[3], 10);
        String cadena = codigo + producto + precio + cantidad;
        return cadena;
    }
    public static String MostrarLista(String[][] vproductos) {
        String salida = "";
        salida += RellenarEspacios("Codigo", 5);
        salida += RellenarEspacios("Producto", 30);
        salida += RellenarEspacios("Precio", 10);
        salida += RellenarEspacios("Cantidad", 10) + "\n";
        salida += "-------------------------------------------------------\n";
        for (int ciclo = 0; ciclo < vproductos.length; ciclo++) {
            String[] vproducto = new String[4];
            vproducto[0] = vproductos[ciclo][0];
            vproducto[1] = vproductos[ciclo][1];
            vproducto[2] = vproductos[ciclo][2];
            vproducto[3] = vproductos[ciclo][3];
            String cadena = MostrarProducto(vproducto);
            salida += cadena + "\n";
        }
        return salida;
    }
    public static int ExisteProducto(String codigo, String[][] vproductos) {
        int enc = -1;
        int pos = 0;
        int tam = vproductos.length;
        for (int ciclo = 0; ciclo < tam; ciclo++) {
            if (vproductos[ciclo][0].equals(codigo.trim())) {
                enc = pos;
            }
            pos++;
        }
        return enc;
    }
    public static void ModificarProducto(String[][] vproductos) {
        String codigo;
        String precio;
        int posicion;
        System.out.println(MostrarLista(vproductos));
        codigo = Leer("Introduce el codigo del producto que desea modificar");
        if (codigo != null) {
            posicion = ExisteProducto(codigo, vproductos);
            if (posicion > -1) {
                String[] vproducto = new String[4];
                vproducto[0] = vproductos[posicion][0];
                vproducto[1] = vproductos[posicion][1];
                vproducto[2] = vproductos[posicion][2];
                vproducto[3] = vproductos[posicion][3];
                System.out.println(MostrarProducto(vproducto));
                precio = Leer("Introduce el nuevo precio del producto");
                if (precio != null) {
                    if (EvaluarNumerico(precio, 2)) {
                        vproductos[posicion][2] = precio;
                        System.out.println("Precio actualizado");
                    } else {
                        System.out.println("El precio no es numerico");
                    }
                } else {
                    System.out.println("El precio no puede ser nulo");
                }
            } else {
                System.out.println("El codigo no existe");
            }
        } else {
            System.out.println("El codigo no puede ser nulo");
        }
    }
    public static void MenuPrincipal(String[][] vproductos) {
        String[] datosmenuprincipal = {
            "productos",
            "punto de venta",
            "inventario",
            "listado de venta",
            "salida"
        };
        String opcion = "0";
        do {
            opcion = DesplegarMenu("Menu de Punto de Tienda de Abarrotes la Pequeña", datosmenuprincipal);
            if (opcion == null) {
                System.out.println("Opcion incorrecta");
            } else {
                switch (opcion) {
                    case "1":
                        MenuProductos(vproductos);
                        break;
                    case "2":
                        MenuPuntoVenta("000");
                        break;
                    case "3":
                        MenuInventario();
                        break;
                    case "4":
                        System.out.println("Ventas");
                        break;
                    case "5":
                        System.out.println("Salida del Sistema");
                        break;
                    default:
                        System.out.println("No existe esta opcion");
                        break;
                }
            }
        } while (!opcion.equals("5"));
    }
    public static void MenuProductos(String[][] vproductos) {
        String[] datosmenuproductos = {
            "Modificar Producto",
            "Listado de Productos",
            "Salida"
        };
        String opcion = "0";
        do {
            opcion = DesplegarMenu("Menu de Productos", datosmenuproductos);

            if (opcion == null) {
                System.out.println("Opcion incorrecta");
            } else {
                switch (opcion) {
                    case "1":
                        ModificarProducto(vproductos);
                        break;
                    case "2":
                        System.out.println(MostrarLista(vproductos));
                        break;
                    case "3":
                        System.out.println("Salida del Sistema");
                        break;
                    default:
                        System.out.println("No existe esta opcion");
                        break;
                }
            }

        } while (!opcion.equals("3"));
    }
    public static void MenuPuntoVenta(String idticket) {
        String opcion = "0";
        String membrete = "";
        boolean pago = false;
        idticket = IdTicketSiguiente(idticket);
        String fechadia = Fecha();
        membrete += "Fecha: " + fechadia + "\n";
        membrete += "Ticket: " + idticket + "\n";
        membrete += "--------------------------------\n";
        String[] datosmenu = {
            "Agregar Articulo al Ticket",
            "Eliminar Articulo del Ticket",
            "Listado de Articulos del Ticket",
            "Pagar Ticket y Salir",
            "Salida"
        };
        do {
            opcion = DesplegarMenu(membrete + "Menu de Punto de Venta", datosmenu);
            if (opcion == null) {
                System.out.println("Opcion incorrecta");
            } else {
                switch (opcion) {
                    case "1":
                        System.out.println("Agregar articulo al ticket");
                        break;
                    case "2":
                        System.out.println("Eliminar articulo del ticket");
                        break;
                    case "3":
                        System.out.println("Listado de articulos del ticket");
                        break;
                    case "4":
                        System.out.println("Pagar ticket y salir");
                        pago = true;
                        opcion = "5";
                        break;
                    case "5":
                        System.out.println("Salida de Ventas");
                        if (pago == false) {
                            System.out.println("No se pago el ticket, se eliminara");
                        }
                        break;
                    default:
                        System.out.println("No existe esta opcion");
                        break;
                }
            }
        } while (!opcion.equals("5"));
    }
    public static void MenuInventario() {
        String[] datosmenuinventario = {
            "Listado de Inventario",
            "Agregar Stock",
            "Salida"
        };
        String opcion = "0";
        do {
            opcion = DesplegarMenu("Menu de Inventario", datosmenuinventario);

            if (opcion == null) {
                System.out.println("Opcion incorrecta");
            } else {
                switch (opcion) {
                    case "1":
                        System.out.println("Listado de inventario");
                        break;
                    case "2":
                        System.out.println("Agregar inventario");
                        break;
                    case "3":
                        System.out.println("Salida del sistema");
                        break;
                    default:
                        System.out.println("No existe esta opcion");
                        break;
                }
            }
        } while (!opcion.equals("3"));
    }
    public static void main(String[] args) {
        productos = CargarProductos();
        MenuPrincipal(productos);
        try {
            teclado.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}