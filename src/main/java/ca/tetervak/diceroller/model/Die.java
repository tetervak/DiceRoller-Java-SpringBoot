package ca.tetervak.diceroller.model;

import java.util.Random;

public class Die {

    public static final int INIT_VALUE = 1;

    private int value;

    private final Random random;

    public int getValue() {
        return value;
    }

    public final void setValue(int value) {
        if (value >= 1 && value <= 6) {
            this.value = value;
        } else {
            throw new IllegalArgumentException("Illegal die value " + value);
        }
    }

    public Die(int value, Random random) {
        setValue(value);
        this.random = random;
    }

    public Die(int value) {
        this(value, new Random());
    }

    public Die(Random random) {
        this(INIT_VALUE, random);
    }

    public Die() {
        this(INIT_VALUE);
    }

    public void reset() {
        value = INIT_VALUE;
    }

    public int roll() {
        value = 1 + random.nextInt(6);
        return value;
    }

    @Override
    public String toString(){
        return "Die(value = " + value + ")";
    }
}
