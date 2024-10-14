package EXP4;

class CurrencyConverter {
    public double convertToUSD(double amount) {
        return amount;
    }
}

class INRConverter extends CurrencyConverter {
    @Override
    public double convertToUSD(double amount) {
        return amount * 0.012;
    }
}

class EuroConverter extends CurrencyConverter {
    @Override
    public double convertToUSD(double amount) {
        return amount * 1.1;
    }
}

class YenConverter extends CurrencyConverter {
    @Override
    public double convertToUSD(double amount) {
        return amount * 0.007;
    }
}

public class currency {
    public static void main(String[] args) {
        CurrencyConverter inr = new INRConverter();
        CurrencyConverter euro = new EuroConverter();
        CurrencyConverter yen = new YenConverter();

        double amountInINR = 1000;
        double amountInEuro = 50;
        double amountInYen = 5000;

        System.out.println("INR to USD: " + inr.convertToUSD(amountInINR));
        System.out.println("Euro to USD: " + euro.convertToUSD(amountInEuro));
        System.out.println("Yen to USD: " + yen.convertToUSD(amountInYen));
    }
}
