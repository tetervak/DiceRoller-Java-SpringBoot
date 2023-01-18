package ca.tetervak.diceroller.service;

import ca.tetervak.diceroller.model.DiceGame;
import ca.tetervak.diceroller.model.RollData;
import org.springframework.stereotype.Service;

@Service
public class DiceRollerServiceImpl implements DiceRollerService{
    @Override
    public RollData getRollData(int numberOfDice) {
        DiceGame diceGame = new DiceGame(numberOfDice);
        diceGame.roll();
        return diceGame.getRollData();
    }
}
