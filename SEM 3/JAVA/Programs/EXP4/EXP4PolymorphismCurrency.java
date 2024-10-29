
class EXP4INR {
    public int amount;

    EXP4INR(int amount) {
        this.amount = amount;
    }

    double convert(double rate) {
        return this.amount / rate;
    };
}

class EXP4USD extends EXP4INR {
    EXP4USD(int amount) {
        super(amount);
    }

    double convert(double rate) {
        return this.amount / rate;
    }
}

class EXP4RYL extends EXP4INR {
    EXP4RYL(int amount) {
        super(amount);
    }

    double convert(int rate) {
        return this.amount / rate;
    }
}

public class EXP4PolymorphismCurrency {
    public static void main(String[] args) {
        EXP4INR inr = new EXP4INR(1000);
        System.out.println("Amount in INR: " + inr.convert(1));
        EXP4USD usd = new EXP4USD(1000);
        System.out.println("Amount in USD: " + usd.convert(84.08));
        EXP4RYL ryl = new EXP4RYL(1000);
        System.out.println("Amount in RYL: " + ryl.convert(22.39));
    }
}
