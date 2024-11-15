import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultarMoneda consulta = new ConsultarMoneda();

        int opcion = 0;
        Double valorACovertir;

        System.out.println("CONVERSOR DE MONEDAS");
        System.out.println("**************************");
        String Menu = """
                1. Dolar a peso Colombiano
                2. Peso Colombiano a Dolar
                3. Dolar a Real Brasilero
                4. Real Brasilero a Dolar
                5. Dolar a peso Argentino
                6. Peso Argentino a Dolar
                7. Dolar a Peso Mexicano
                8. Peso Mexicano a Dolar
                9. Salir""";

        while (opcion != 8) {
            System.out.println("\n");
            System.out.println("Menu");
            System.out.println("\nINGRESE UNA OPCIÓN: ");
            opcion = lectura.nextInt();

            String base_code = null;
            String tarjet_code = null;

            switch (opcion) {
                case 1:
                    base_code = "USD";
                    tarjet_code = "COP";
                    break;
                case 2:
                    base_code = "COP";
                    tarjet_code = "USD";
                    break;
                case 3:
                    base_code = "USD";
                    tarjet_code = "BRL";
                    break;
                case 4:
                    base_code = "BRL";
                    tarjet_code = "USD";
                    break;
                case 5:
                    base_code = "COP";
                    tarjet_code = "ARS";
                    break;
                case 6:
                    base_code = "ARS";
                    tarjet_code = "USD";
                    break;
                case 7:
                    base_code = "USD";
                    tarjet_code = "MXN";
                    break;
                case 8:
                    base_code = "MXN";
                    tarjet_code = "USD";
                    break;
                case 9:
                    System.out.println("Saliendo.....");
                    continue;
                default:
                    System.out.println("OPCIÓN INCORRECTA");
                    continue;
            }

            System.out.println("Ingresa un valor");
            valorACovertir = lectura.nextDouble();

            try {

                double conversionRate = consulta.buscarMoneda(base_code, tarjet_code);
                System.out.println("La tasa de cmabio de " + base_code + " a " + tarjet_code + " es: " + conversionRate);

                double valorfinal = valorACovertir * conversionRate;
                System.out.println("El valor obtenido sera : " + valorfinal + " " + tarjet_code);

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Cerrando aplicacion");
            }

        }

        lectura.close();

    }
}

