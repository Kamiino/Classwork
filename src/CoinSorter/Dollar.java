package CoinSorter;

/**
 * Dollar.java is a subclass of the abstract class, Coin, in Coin.java, representing a dollar ($1.00)
 * @version 11/24/2020
 * @author 22tanaka
 */
public class Dollar extends Coin {
    /**
     * Defines the abstract method, getValue, from class "Coin" for the subclass, Dollar.
     * @return the value of a dollar
     */
    public double getValue() {
        return 1.0;
    }

    /**
     * Defines the abstract method, getName, from class "Coin" for the subclass, Dollar
     * @return the name of the coin in Dollar.java (Hint: It's dollar)
     */
    public String getName() {
        return "dollar";
    }
}