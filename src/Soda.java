/**
 * Created by Ivan on 21.08.2019.
 */
public class Soda extends Sweet {


    private double volume;

    public Soda(String name, float weight, float price, double volume) {
        super(name, weight, price);
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", volume=" + volume;
    }
}
