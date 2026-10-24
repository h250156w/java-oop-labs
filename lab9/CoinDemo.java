package lab9;

enum Coin {
    QUARTER(25), DIME(10), NICKEL(5), PENNY(1);

    private final int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static void fewestCoins(int cents) {
        System.out.print(cents + " cents = ");
        for (Coin coin : Coin.values()) {
            int count = cents / coin.getValue();
            if (count > 0) {
                System.out.print(count + " " + coin.name() + "(s) ");
                cents %= coin.getValue();
            }
        }
        System.out.println();
    }
}

public class CoinDemo {
    public static void main(String[] args) {
        Coin.fewestCoins(87);
        Coin.fewestCoins(42);
    }
}
