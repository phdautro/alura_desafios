import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;

        while (continuar) {
            ConversorMoedas.printMenu();

            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            String fromCurrency, toCurrency;

            switch (escolha) {
                case 1:
                    fromCurrency = "USD";
                    toCurrency = "ARS";
                    break;
                case 2:
                    fromCurrency = "ARS";
                    toCurrency = "USD";
                    break;
                case 3:
                    fromCurrency = "USD";
                    toCurrency = "BRL";
                    break;
                case 4:
                    fromCurrency = "BRL";
                    toCurrency = "USD";
                case 5:
                    fromCurrency = "USD";
                    toCurrency = "COP";
                    break;
                case 6:
                    fromCurrency = "COP";
                    toCurrency = "USD";
                    break;
                case 7:
                    System.out.println("Saindo...");
                    continuar = false;
                    continue;
                default:
                    System.out.println("Opção inválida.");
                    continue;
            }

            System.out.print("Digite o valor a ser convertido: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            try {
                JsonObject exchangeRates = APIservice.getExchangeRates();
                double convertedAmount = ConversorMoedas.convertCurrency(fromCurrency, toCurrency, amount, exchangeRates);
                System.out.println(amount + " " + fromCurrency + " = " + convertedAmount + " " + toCurrency);
            } catch (IOException e) {
                System.out.println("Erro ao obter taxas de câmbio da API: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
