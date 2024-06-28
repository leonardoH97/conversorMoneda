import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte selected;
        do {
            System.out.print("""
                    
                    **************************************************
                    ¡Hola, bienvenida/o al Conversor de Moneda!
                    
                    Opciones:
                        1) Dólar =>> Peso Argentino
                        2) Peso Argentino =>> Dólar
                        3) Dólar =>> Real Brasileño
                        4) Real Brasileño =>> Dólar
                        5) Dólar =>> Peso Colombiano
                        6) Peso Colombiano =>> Dólar
                        7) Salir
                    **************************************************
                    """);
            System.out.print("Elija una opción válida: ");
            selected = sc.nextByte();
            if (selected == 7) {
                System.out.println("""
                        Usted ha seleccionado salir
                        Adiós, gracias por utilizar el Conversor de Moneda.
                        """);
            } else if (selected < 1 || selected > 7) {
                System.out.println("¡Atención! '" + selected + "' NO es una opción válida.  Por favor intente de nuevo");
            } else {
                System.out.print("Ingrese la cantidad que desea convertir: ");
                final double amount = sc.nextDouble();
                try {
                    ExchangeRate.converter(selected, amount);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } while (selected != 7);
    }
}