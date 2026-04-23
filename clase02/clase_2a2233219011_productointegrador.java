package proyecto_integrador;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class clase_2a2233219011_productointegrador {
    static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
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
    public static void main(String[] args) {
        String[] menuPrincipal = {
            "productos",
            "punto de venta",
            "inventario",
            "listado de venta",
            "salida"
        };
        String opcionElegida = DesplegarMenu("Menu de Punto de Tienda de Abarrotes la Pequeña", menuPrincipal);
        System.out.println("\nOpcion elegida: " + opcionElegida);
        try {
            teclado.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}