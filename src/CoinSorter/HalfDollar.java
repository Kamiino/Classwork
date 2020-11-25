package CoinSorter;

/**
 * HalfDollar.java is a subclass of the abstract class, Coin, in Coin.java, representing a half dollar ($0.50)
 * @version 11/24/2020
 * @author 22tanaka
 */
public class HalfDollar extends Coin {
    /**
     * Defines the abstract method, getValue, from class "Coin" for the subclass, HalfDollar.
     * @return the value of a half dollar
     */
    public double getValue() {
        return .5;
    }

    /**
     * Defines the abstract method, getName, from class "Coin" for the subclass, HalfDollar
     * @return the name of the coin in HalfDollar.java (Hint: It's half dollar)
     */
    public String getName() {
        return "half dollar";
    }
}