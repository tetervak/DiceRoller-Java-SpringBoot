package ca.tetervak.diceroller.service;

import java.util.List;

public interface DiceRollData {
    List<Integer> getValues();

    int getNumberOfDice();

    int getTotal();
}
