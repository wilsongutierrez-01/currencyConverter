import alura.courses.com.api.CurrencyApi;
import alura.courses.com.dto.Currency;
import alura.courses.com.helper.PrintCurrency;
import alura.courses.com.logger.Logger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintCurrency printCurrency = new PrintCurrency();
        Logger logger = new Logger();
        CurrencyApi api = new CurrencyApi();

        while (true) {
            System.out.println("\n=== Currency Converter ===");
            System.out.println("Select base currency:");

            printCurrency.printCurrency();

            System.out.print("Choose an option (1-" + printCurrency.getLength() + "): ");
            int baseChoice = scanner.nextInt();
            scanner.nextLine();

            String baseCurrency = printCurrency.getCurrency(baseChoice);

            System.out.println("\nSelect target currency:");

            printCurrency.printCurrency();

            System.out.print("Choose an option (1-" + printCurrency.getLength() + "): ");
            int targetChoice = scanner.nextInt();
            scanner.nextLine();

            String targetCurrency = printCurrency.getCurrency(targetChoice);

            System.out.print("\nEnter amount to convert: ");
            double amount = scanner.nextDouble();

            Currency currencyResponse = api.getConversion(baseCurrency, targetCurrency, amount);

            System.out.println("\n=== Conversion Result ===");
            System.out.println(amount + " " + baseCurrency + " are equals to:  "
                    + currencyResponse.conversionResult() + " " + targetCurrency);

            logger.log(baseCurrency, targetCurrency, amount, currencyResponse.conversionResult(), currencyResponse.conversionRate());

            System.out.print("\nDo you want another conversion? (y/n): ");
            scanner.nextLine();
            String again = scanner.nextLine();
            if (!again.equalsIgnoreCase("y")) {
                System.out.println("Goodbye!");
                break;
            }
        }

        scanner.close();
    }
}