package ca.tetervak.diceroller.model;

import ca.tetervak.diceroller.service.DiceRollData;

import java.util.Collections;
import java.util.List;

public class RollData implements DiceRollData {

    private final List<Integer> values;

    @Override
    public List<Integer> getValues() {
        return values;
    }

    @Override
    public int getNumberOfDice(){
        return values.size();
    }

    private final int total;

    @Override
    public int getTotal() {
        return total;
    }

    public RollData(List<Integer> values) {
        this.values = Collections.unmodifiableList(values);
        int sum = 0;
        for(int value: values){
            sum += value;
        }
        total = sum;
    }

    @Override
    public String toString(){
        return "RollData(values = " + values + ", total = " + getTotal() + ")";
    }
}
