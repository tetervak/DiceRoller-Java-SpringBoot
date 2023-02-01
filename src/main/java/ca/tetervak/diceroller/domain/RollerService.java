package ca.tetervak.diceroller.domain;

import ca.tetervak.diceroller.model.RollData;

public interface RollerService {

    RollData getRollData(int numberOfDice);
}
