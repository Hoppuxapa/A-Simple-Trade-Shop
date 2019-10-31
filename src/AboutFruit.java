import java.time.LocalDate;

public class AboutFruit {
    private Fruit FruitType;
    private int shelfLife;
    private LocalDate dateOfDelivery;
    private int price;

    AboutFruit() {
    }

    AboutFruit(Fruit FruitType, int shelfLife, LocalDate dateOfDelivery, int price) {
        this.FruitType = FruitType;
        this.shelfLife = shelfLife;
        this.dateOfDelivery = dateOfDelivery;
        this.price = price;
    }

    public Fruit getFruitType() {
        return FruitType;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public LocalDate getDateOfDelivery() {
        return dateOfDelivery;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "{"+ "\n" + "Fruit:" + "\n" +
                "fruitType=" + FruitType + "\n" +
                "shelfLife=" + shelfLife + "\n" +
                "DateOfDelivery=" + dateOfDelivery + "\n" +
                "price=" + price + "\n" + "}";
    }

}
