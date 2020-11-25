package CoinSorter;

/**
 * Quarter.java is a subclass of the abstract class, Coin, in Coin.java, representing a quarter ($0.25)
 * @version 11/24/2020
 * @author 22tanaka
 */
public class Quarter extends Coin {
    /**
     * Defines the abstract method, getValue, from class "Coin" for the subclass, Quarter.
     * @return the value of a quarter
     */
    public double getValue() {
        return .25;
    }

    /**
     * Defines the abstract method, getName, from class "Coin" for the subclass, Quarter
     * @return the name of the coin in Quarter.java (Hint: It's quarter)
     */
    public String getName() {
        return "quarter";
    }
}