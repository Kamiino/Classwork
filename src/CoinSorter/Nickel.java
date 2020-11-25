package CoinSorter;

/**
 * Nickel.java is a subclass of the abstract class, Coin, in Coin.java, representing a nickel ($0.05)
 * @version 11/24/2020
 * @author 22tanaka
 */
public class Nickel extends Coin {
    /**
     * Defines the abstract method, getValue, from class "Coin" for the subclass, Nickel.
     * @return the value of a nickel
     */
    public double getValue() {
        return .05;
    }

    /**
     * Defines the abstract method, getName, from class "Coin" for the subclass, Nickel
     * @return the name of the coin in Nickel.java (Hint: It's nickel)
     */
    public String getName() {
        return "nickel";
    }
}