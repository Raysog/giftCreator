/**
 * Created by Ivan on 21.08.2019.
 */
public class FortuneCookie extends Sweet {

    private String divination;

    public FortuneCookie(String name, float weight, float price, String divination) {
        super(name, weight, price);
        this.divination = divination;
    }

    public String getDivination() {
        return divination;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", divination=" + divination;
    }
}
