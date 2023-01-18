package ca.tetervak.diceroller.service;

import ca.tetervak.diceroller.model.RollData;

public interface DiceRollerService {

    RollData getRollData(int numberOfDice);
}
