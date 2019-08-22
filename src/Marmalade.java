/**
 * Created by Ivan on 21.08.2019.
 */
public class Marmalade extends Sweet {

    private String form;

    public Marmalade(String name, float weight, float price, String form) {
        super(name, weight, price);
        this.form = form;
    }

    public String getForm() {
        return form;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", form=" + form;
    }
}
