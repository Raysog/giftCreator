/**
 * Created by Ivan on 21.08.2019.
 */
public class Donut extends Sweet {

    private String filling;

    public Donut(String name, float weight, float price, String filling) {
        super(name, weight, price);
        this.filling = filling;
    }

    public String getFilling() {
        return filling;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", filling=" + filling;
    }
}
