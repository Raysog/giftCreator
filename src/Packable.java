/**
 * Created by Ivan on 21.08.2019.
 */
public interface Packable {
    void add(Sweet sweet);

    void removeSweetByIndex(int index) ;

    void removeSweetLast();

    double getWeight();

    double getPrice();

    String getAllInfoAboutSweets();
    
    void reducePrice(double price);
    
    void reduceWeight(double weight);
}
