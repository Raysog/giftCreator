/**
 * Created by Ivan on 21.08.2019.
 */
public interface Packable {
    void add(Sweet sweet);

    Sweet getSweetByIndex(int index);

    Sweet getSweetLast();

    double getWeight();

    double getPrice();

    String getAllInfoAboutSweets();
}
