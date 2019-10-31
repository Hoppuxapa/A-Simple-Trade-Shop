
import com.google.gson.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class TradeShop {

    private final String pathToJsonFile = "C:\\Users\\38068\\Desktop\\Test.json";

    public String getPathToJsonFile() {
        return pathToJsonFile;
    }

    List<AboutFruit> dataBaseOfFruits = new ArrayList<>();

    List<AboutFruit> getDataBaseOfFruits() {
        return dataBaseOfFruits;
    }

    public void addFruits(String pathToJsonFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(pathToJsonFile))) {
            Gson gson = new Gson();
            JsonParser jsonParser = new JsonParser();
            JsonArray arr = (JsonArray) jsonParser.parse(new FileReader(pathToJsonFile));
            for (JsonElement element : arr) {
                AboutFruit fruits = gson.fromJson(element.toString(), AboutFruit.class);
                dataBaseOfFruits.add(fruits);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void save(String pathToJsonFile, List<AboutFruit> dataBaseOfFruits) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(pathToJsonFile, false)) {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String newFruits = gson.toJson(dataBaseOfFruits);
            bw.append(newFruits);
            bw.flush();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void load(String pathToJsonFile) {
        dataBaseOfFruits.clear();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToJsonFile));
            JsonParser jsonParser = new JsonParser();
            JsonArray jsonArray = new JsonArray();
            jsonParser.parse(new FileReader(pathToJsonFile));
            Gson gson = new Gson();
            for (JsonElement element : jsonArray) {
                AboutFruit aboutFruit = gson.fromJson(element.toString(), AboutFruit.class);
                dataBaseOfFruits.add(aboutFruit);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public List<AboutFruit> getSpoiledFruits(LocalDate dateNeed) {
        List<AboutFruit> spoiledFruits = new ArrayList<>();
        for (AboutFruit fruit : dataBaseOfFruits) {
          LocalDate isSpoiled = fruit.getDateOfDelivery().plusDays(fruit.getShelfLife());
            if (isSpoiled.isBefore(dateNeed) ) {
                // Нужно сделать оговору, если даты совпадают, то в лист просроченных фруктов метод не добавит.
                spoiledFruits.add(fruit);
            }
        }
        return spoiledFruits;
    }

    public List<AboutFruit> getAvailableFruits(LocalDate dateToday) {
        List<AboutFruit> availableFruits = new ArrayList<>();
        for (AboutFruit fruit : dataBaseOfFruits) {
            LocalDate isSpoiled = fruit.getDateOfDelivery().plusDays(fruit.getShelfLife());
            if (isSpoiled.isAfter(dateToday)) {
                // Нужно сделать оговору, если даты совпадают, то в доступные фрукты метод не добавит.
                availableFruits.add(fruit);
            }
        }
        return availableFruits;
    }

    public List<AboutFruit> getSpoiledFruits(LocalDate dateNeed, Fruit fruitType) {
        List<AboutFruit> spoiledFruits = new ArrayList<>();
        for (AboutFruit fruit : dataBaseOfFruits) {
            LocalDate isSpoiled = fruit.getDateOfDelivery().plusDays(fruit.getShelfLife());
            if ( (isSpoiled.isBefore(dateNeed)) && (fruit.getFruitType().equals(fruitType)) ) {
                // Нужно сделать оговору, если даты совпадают, то в лист просроченных фруктов метод не добавит.
                spoiledFruits.add(fruit);
            }
        }
        return spoiledFruits;
    }
    public List<AboutFruit> getAvailableFruits(LocalDate dateToday, Fruit fruitType) {
        List<AboutFruit> availableFruits = new ArrayList<>();
        for (AboutFruit fruit : dataBaseOfFruits) {
            LocalDate isSpoiled = fruit.getDateOfDelivery().plusDays(fruit.getShelfLife());
            if((isSpoiled.isAfter(dateToday)) && (fruit.getFruitType().equals(fruitType))){
                // Нужно сделать оговору, если даты совпадают, то в доступные фрукты метод не добавит.
                availableFruits.add(fruit);
            }
        }
        return availableFruits;
    }

    List<AboutFruit> getAddedFruits(LocalDate dateNeed){
        List<AboutFruit> addedFruits = new ArrayList<>();
        for (AboutFruit fruit : dataBaseOfFruits) {
            if (fruit.getDateOfDelivery().isEqual(dateNeed)) {
               addedFruits.add(fruit);
            }
        }
        return addedFruits;
    }
    List<AboutFruit> getAddedFruits(LocalDate dateNeed, Fruit fruitType){
        List<AboutFruit> addedFruits = new ArrayList<>();
        for (AboutFruit fruit : dataBaseOfFruits) {
            if ((fruit.getDateOfDelivery().isEqual(dateNeed)) && (fruit.getFruitType().equals(fruitType))) {
                addedFruits.add(fruit);
            }
        }
        return addedFruits;
    }
}
