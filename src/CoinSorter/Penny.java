package CoinSorter;

/**
 * Penny.java is a subclass of the abstract class, Coin, in Coin.java, representing a penny ($0.01)
 * @version 11/24/2020
 * @author 22tanaka
 */
public class Penny extends Coin {
    /**
     * Defines the abstract method, getValue, from class "Coin" for the subclass, Penny.
     * @return the value of a penny
     */
    public double getValue() {
        return .01;
    }

    /**
     * Defines the abstract method, getName, from class "Coin" for the subclass, Penny
     * @return the name of the coin in Penny.java (Hint: It's penny)
     */
    public String getName() {
        return "penny";
    }
}