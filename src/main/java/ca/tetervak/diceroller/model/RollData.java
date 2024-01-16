package ca.tetervak.diceroller.model;

import java.util.List;

public interface RollData {
    List<Integer> getValues();

    int getNumberOfDice();

    int getTotal();
}
