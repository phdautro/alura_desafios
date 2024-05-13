import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class ConversorMoedas {

    public static double convertCurrency(String fromCurrency, String toCurrency, double amount, JsonObject exchangeRates) {
        double convertedAmount = 0;

        JsonObject conversionRates = exchangeRates.getAsJsonObject("conversion_rates");

        if (conversionRates.has(fromCurrency) && conversionRates.has(toCurrency)) {
            double fromRate = conversionRates.get(fromCurrency).getAsDouble();
            double toRate = conversionRates.get(toCurrency).getAsDouble();

            convertedAmount = (amount / fromRate) * toRate;
        } else {
            System.out.println("Conversão não suportada.");
        }

        return convertedAmount;
    }

    public static void printMenu() {
        System.out.println("******************************************");
        System.out.println("Bem-vindo ao Conversor de Moeda!");
        System.out.println(" ");
        System.out.println("1) Dólar => Peso argentino");
        System.out.println("2) Peso argentino => Dólar");
        System.out.println("3) Dólar => Real brasileiro");
        System.out.println("4) Real brasileiro => Dólar");
        System.out.println("5) Dólar => Peso colombiano");
        System.out.println("6) Peso colombiano => Dólar");
        System.out.println("7) Sair");
        System.out.println("*************************");
    }
}
