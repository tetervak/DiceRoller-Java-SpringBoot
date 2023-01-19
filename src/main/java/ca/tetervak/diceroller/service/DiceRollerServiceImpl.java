package ca.tetervak.diceroller.service;

import ca.tetervak.diceroller.model.DiceGame;
import org.springframework.stereotype.Service;

@Service
public class DiceRollerServiceImpl implements DiceRollerService{
    @Override
    public DiceRollData getRollData(int numberOfDice) {
        DiceGame diceGame = new DiceGame(numberOfDice);
        diceGame.roll();
        return diceGame.getRollData();
    }
}
