import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        AboutFruit banana = new AboutFruit(Fruit.BANANA, 10,LocalDate.of(2018,05,10),100);
        List<AboutFruit> aboutFruitList = new ArrayList<>();
        aboutFruitList.add(banana);
        System.out.println(banana);
            /*    TradeShop.addFruits();*/
    }
}
