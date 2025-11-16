package alura.courses.com.helper;

import java.util.HashMap;
import java.util.Map;

public class PrintCurrency {
    String[] keys;
    Map<String, String> currencies = new HashMap<>();

    public PrintCurrency() {
        initCurrencies();
    }

    public void printCurrency() {
        int index = 1;
        keys = currencies.keySet().toArray(new String[0]);

        for (String currencyName : keys) {
            System.out.println(index + ". " + currencyName + " (" + currencies.get(currencyName) + ")");
            index++;
        }
    }

    public String getCurrency(Integer choice) {
        return currencies.get(keys[choice - 1]);
    }


    public Integer getLength() {
        return keys.length;
    }

    private void initCurrencies() {
        currencies.put("Argentine Peso", "ARS");
        currencies.put("Bolivian Boliviano", "BOB");
        currencies.put("Brazilian Real", "BRL");
        currencies.put("Chilean Peso", "CLP");
        currencies.put("Colombian Peso", "COP");
        currencies.put("United States Dollar", "USD");
    }

}
