package ca.tetervak.diceroller.model;

import java.util.Collections;
import java.util.List;

public class RollDataImpl implements RollData {

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

    public RollDataImpl(List<Integer> values) {
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
