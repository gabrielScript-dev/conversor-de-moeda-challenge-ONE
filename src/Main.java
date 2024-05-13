import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static void conversionOptions() {
        System.out.println("""
                1) Dólar americano para Real brasileiro
                2) Real brasileiro para Dólar americano
                3) Dólar americano para Peso argentino
                4) Peso argentino para Dólar americano
                5) Dólar americano para Peso Boliviano
                6) Peso Boliviano para Dólar americano
                7) Dólar americano para Peso chileno
                8) Peso chileno para Dólar americano
                9) Dólar americano para Peso colombiano
                10) Peso colombiano para Dólar americano
                """);
    }

    public static void main(String[] args) {

        boolean state = true;
        Scanner sc = new Scanner(System.in);
        Converter converter = new Converter();
        Map<Integer, String> currencyCodes = new HashMap<Integer, String>();

        currencyCodes.put(1, "USD-BRL");
        currencyCodes.put(2, "BRL-USD");
        currencyCodes.put(3, "USD-ARS");
        currencyCodes.put(4, "ARS-USD");
        currencyCodes.put(5, "USD-BOB");
        currencyCodes.put(6, "BOB-USD");
        currencyCodes.put(7, "USD-CLP");
        currencyCodes.put(8, "CLP-USD");
        currencyCodes.put(9, "USD-COP");
        currencyCodes.put(10, "COP-USD");



        while(state) {
            System.out.println("""
                    Bem vindo(a) ao Conversor de Moedas!
                    Menu
                    1) Converter Moedas
                    2) Sair
                    """);

            System.out.print("\nEscolha uma opção: ");
            int option = sc.nextInt();

            if (option == 1) {
                conversionOptions();
                System.out.print("\nEscolha uma opção: ");
                option = sc.nextInt();

                String[] inCodeCurrency = currencyCodes.get(option).split("-");

                System.out.printf("\nInforme o valor [%s] que deseja converter para [%s]: ", inCodeCurrency[0], inCodeCurrency[1]);
                double value = sc.nextDouble();

                double result = converter.converter(inCodeCurrency[0], inCodeCurrency[1], value);

                System.out.printf("Result: %.2f\n\n", result);

            } else if (option == 2) {
                state = false;
            } else {
                System.out.println("Opção Inválida! Tente Novamente.");
            }
        }

        sc.close();
    }
}
