package controller;

import model.Toy;
import view.Constants;
import service.Examples;

import java.util.ArrayList;

public class RoomCreator {
    private ArrayList<Toy> toys = new ArrayList<Toy>();

    public ArrayList roomCreating() {
        ArrayList<Toy> available = new ArrayList<Toy>();
        Constants constants = new Constants();
        Examples examples = new Examples();

        toys = examples.init();
        int countOfToys = 0;
        double cash = 0;
        for (Toy toy : toys) {
            if (countOfToys < constants.getAmountOfToys()) {
                cash += toy.getPrice();
                if (cash > constants.getMoney()){
                    cash -= toy.getPrice();
                    continue;
                }
                countOfToys++;
                available.add(toy);
            } else {
                break;
            }
        }
        return available;
    }
}
