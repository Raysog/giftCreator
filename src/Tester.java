/**
 * Created by Ivan on 21.08.2019.
 */
public class Tester {
    public static void main(String[] args) {
        Packable box = new Box();
        box.add(new BubbleGum("Orbit", 2.0f, 10.0f, "apple"));
        box.add(new Donut("Donut", 10.0f, 50.0f, "chocolate"));
        box.add(new FortuneCookie("Magick", 1.0f, 5.0f, "Everything will be fine"));
        box.add(new FortuneCookie("Magick", 1.0f, 5.0f, "Fate is falling for you"));
        box.add(new Soda("Cola", 300.0f, 50.0f, 300.0));
        System.out.println("weight = " + box.getWeight());
        System.out.println("price = " + box.getPrice());
        System.out.println("all info: \n" + box.getAllInfoAboutSweets());
        box.reducePrice(0);
        System.out.println("all info: \n" + box.getAllInfoAboutSweets());

    }
}
