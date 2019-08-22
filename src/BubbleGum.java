/**
 * Created by Ivan on 21.08.2019.
 */
public class BubbleGum extends Sweet{

    private String taste;

    public BubbleGum(String name, float weight, float price, String taste) {
        super(name, weight, price);
        this.taste = taste;
    }

    public String getTaste() {
        return taste;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", taste=" + taste;
    }
}
