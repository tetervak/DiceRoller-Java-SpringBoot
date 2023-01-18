package ca.tetervak.diceroller.model;

import java.util.Collections;
import java.util.List;

public class RollData {

    private final List<Integer> values;

    public List<Integer> getValues() {
        return values;
    }

    public int getNumberOfDice(){
        return values.size();
    }

    private final int total;

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
