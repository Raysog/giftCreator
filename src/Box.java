/**
 * Created by Ivan on 21.08.2019.
 */
public class Box implements Packable {

    private Sweet arrayBox[];

    public Box() {
        this.arrayBox = new Sweet[0];
    }

    private int getFreePlaces(){
        int nullCounter = 0;
        for (Sweet s : arrayBox) {
            if (s == null){
                nullCounter++;
            }
        }
        return nullCounter;
    }

    private boolean checkFreePlace(){
        return this.getFreePlaces()>0 ? true : false;
    }

    private Sweet[] createNewArrayBox(){
        int currentLength = this.arrayBox.length;
        Sweet[] lagerArray;
        if (currentLength == 0){
            lagerArray = new Sweet[1];
        } else {
            lagerArray = new Sweet[currentLength*2];
        }
        return lagerArray;
    }

    private void moveToFreeArray(){
        Sweet[] newPlace = this.createNewArrayBox();
        for (int i = 0; i < this.arrayBox.length; i++) {
            newPlace[i] = this.arrayBox[i];
        }
        this.arrayBox = newPlace;
    }

    private void increaseFreeSpace(){
        if (this.arrayBox.length == 0) {
            this.arrayBox = this.createNewArrayBox();
        } else if (this.getFreePlaces() == 0){
            this.moveToFreeArray();
        }
    }

    private void addToFirstFreeSpace(Sweet sweet){
        for (int i = 0; i < this.arrayBox.length; i++) {
            if (this.arrayBox[i] == null){
                this.arrayBox[i] = sweet;
                break;
            }
        }
    }



    @Override
    public void add(Sweet newSweet) {
        if (!this.checkFreePlace()){
            this.increaseFreeSpace();
        }
        this.addToFirstFreeSpace(newSweet);
    }

    private boolean isEmpty(){
        for (Sweet s :
                this.arrayBox) {
            if (s != null){
                return false;
            }
        }
        return true;
    }

    private void arrayShift(){
        for (int i = 0; i < this.arrayBox.length; i++) {
            if ((this.arrayBox[i] == null) && (i != this.arrayBox.length-1)){
                for (int j = i; j < this.arrayBox.length; j++) {
                    if (j != this.arrayBox.length-1){
                        this.arrayBox[j] = this.arrayBox[j + 1];
                    } else {
                        this.arrayBox[j] = null;
                    }
                }
                break;
            }
        }
    }

    @Override
    public void removeSweetByIndex(int index) {
        if (this.isEmpty()){
            System.out.println("Box is Empty!");
        }else {
            if ((index < this.arrayBox.length) && (index >= 0)) {
                this.arrayBox[index] = null;
                this.arrayShift();
            } else {
                System.out.println("Index is incorrect");
            }
        }
    }

    @Override
    public void removeSweetLast() {
        if(!this.isEmpty()) {
            int lastIndex = -1;
            for (int i = this.arrayBox.length - 1; i > -1; i--) {
                if (this.arrayBox[i] != null) {
                    lastIndex = i;
                    break;
                }
            }
            arrayBox[lastIndex] = null;
        }
        else {
            System.out.println("Box is Empty!");
        }
    }

    @Override
    public double getWeight() {
        if (this.isEmpty()){
            System.out.println("Box is Empty!");
            return 0;
        }else {
            double weight = 0;
            for (Sweet s : this.arrayBox) {
                if(s != null) {
                    weight += s.getWeight();
                }
            }
            return weight;
        }
    }

    @Override
    public double getPrice() {
        if (this.isEmpty()){
            System.out.println("Box is Empty!");
            return 0;
        }else {
            double price = 0;
            for (Sweet s : this.arrayBox) {
                if(s != null) {
                    price += s.getPrice();
                }
            }
            return price;
        }
    }

    @Override
    public String getAllInfoAboutSweets() {
        if (this.isEmpty()){
            return "Box is Empty!";
        }else {
            StringBuilder sb = new StringBuilder();
            for (Sweet s : this.arrayBox) {
                if(s != null) {
                    sb.append(s.toString() + "\n");
                }
            }
            return sb.toString();
        }
    }

    private int indexMinWeight(){
        double min = this.arrayBox[0].getWeight();
        int index = 0;
        for (int i = 1 ; i < this.arrayBox.length; i++) {
            if ((this.arrayBox[i] != null) && (this.arrayBox[i].getWeight() < min)){
                min = this.arrayBox[i].getWeight();
                index = i;
            }
        }
        return index;
    }


    
    @Override
    public void reduceWeight(double weight){
        while (!this.isEmpty() ||(this.getWeight() > weight) ){
            if (this.arrayBox.length - this.getFreePlaces() != 2) {
                this.removeSweetByIndex(this.indexMinWeight());
            } else {
                Sweet first = null;
                int indexFirst = -1;
                Sweet second = null;
                int indexSecond = -1;
                for (int i = 0; i < this.arrayBox.length; i++) {
                    if (this.arrayBox[i] != null){
                        if (first == null) {
                            first = this.arrayBox[i];
                            indexFirst = i;
                        } else {
                            second = this.arrayBox[i];
                            indexSecond = i;
                        }
                    }
                }
                if ((this.getWeight() - second.getWeight() >= weight) && (this.getWeight() - first.getWeight() < weight)){
                    this.removeSweetByIndex(indexFirst);
                } else {
                    this.removeSweetByIndex(indexSecond);
                }
            }
        }
    }

    private int indexMinPrice(){
        double min = this.arrayBox[0].getPrice();
        int index = 0;
        for (int i = 1 ; i < this.arrayBox.length; i++) {
            if ((this.arrayBox[i] != null) && (this.arrayBox[i].getPrice() < min)){
                min = this.arrayBox[i].getPrice();
                index = i;
            }
        }
        return index;
    }

    @Override
    public void reducePrice(double price){
        while (!this.isEmpty() ||(this.getPrice() > price) ){
            if (this.arrayBox.length - this.getFreePlaces() != 2) {
                this.removeSweetByIndex(this.indexMinPrice());
            } else {
                Sweet first = null;
                int indexFirst = -1;
                Sweet second = null;
                int indexSecond = -1;
                for (int i = 0; i < this.arrayBox.length; i++) {
                    if (this.arrayBox[i] != null){
                        if (first == null) {
                            first = this.arrayBox[i];
                            indexFirst = i;
                        } else {
                            second = this.arrayBox[i];
                            indexSecond = i;
                        }
                    }
                }
                if ((this.getPrice() - second.getPrice() >= price) && (this.getPrice() - first.getPrice() < price)){
                    this.removeSweetByIndex(indexFirst);
                } else {
                    this.removeSweetByIndex(indexSecond);
                }
            }
        }
    }
}
