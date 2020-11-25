package CoinSorter;

/**
 * Dime.java is a subclass of the abstract class, Coin, in Coin.java, representing a dime ($0.10)
 * @version 11/24/2020
 * @author 22tanaka
 */
public class Dime extends Coin {
    /**
     * Defines the abstract method, getValue, from class "Coin" for the subclass, Dime.
     * @return the value of a dime
     */
    public double getValue() {
        return .1;
    }

    /**
     * Defines the abstract method, getName, from class "Coin" for the subclass, Dime
     * @return the name of the coin in Dime.java (Hint: It's dime)
     */
    public String getName() {
        return "dime";
    }
}