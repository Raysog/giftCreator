/**
 * Created by Ivan on 20.08.2019.
 */
public abstract class Sweet {
    private String name;
    private float weight;
    private float price;

    public Sweet(String name, float weight, float price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

    public float getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "name=" + name +
                ", weight=" + weight +
                ", price=" + price;
    }
}
