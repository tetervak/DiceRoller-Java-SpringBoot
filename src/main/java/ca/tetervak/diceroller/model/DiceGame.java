package ca.tetervak.diceroller.model;

import java.util.ArrayList;
import java.util.List;

public class DiceGame {

    public static final int DEFAULT_NUMBER_OF_DICE = 3;

    private final Die[] dice;

    public int getNumberOfDice() {
        return dice.length;
    }

    private boolean rolled;

    public boolean isRolled() {
        return rolled;
    }

    public DiceGame(int numberOfDice) {
        dice = new Die[numberOfDice];
        for(int i = 0; i < dice.length; i++){
            dice[i] = new Die();
        }
        rolled = false;
    }

    public DiceGame(){
        this(DEFAULT_NUMBER_OF_DICE);
    }

    public DiceGame(RollData rollData){
        dice = new Die[rollData.getNumberOfDice()];
        List<Integer> values = rollData.getValues();
        for(int i = 0; i < dice.length; i++){
            dice[i] = new Die(values.get(i));
        }
        rolled = true;
    }

    public void roll(){
        for(Die die: dice){
            die.roll();
        }
        rolled = true;
    }

    public void reset(){
        for(Die die: dice){
            die.reset();
        }
        rolled = false;
    }

    public int getTotal(){
        int sum = 0;
        for(Die die: dice){
            sum += die.getValue();
        }
        return sum;
    }

    public RollData getRollData(){
        if(rolled){
            List<Integer> list = new ArrayList<>();
            for(Die die: dice) {
                list.add(die.getValue());
            }
            return new RollData(list);
        }else{
            return null;
        }
    }
}
