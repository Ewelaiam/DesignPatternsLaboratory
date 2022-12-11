package pl.edu.agh.dp;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Manager manager = new Manager("src/main/resources/shop.json");
        ObjectFromJSON objectFromJSON = manager.createObject();
    }
}
