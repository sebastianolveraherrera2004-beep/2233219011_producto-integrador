package proyecto_integrador;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a2233219011_productointegrador {
	 static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
	 public static String MostrarMenu(String[] opciones) {
	        String cadena = "";
	        int i = 0;
	        while (i<opciones.length) {
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
		 cadena= Titulo1 +"/n/n";
		 cadena += MostrarMenu(menu);
	     cadena += "elije una opcion";
	     return Dialogo(cadena);
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
		 
