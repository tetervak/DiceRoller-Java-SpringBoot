package ca.tetervak.diceroller.domain;

import ca.tetervak.diceroller.model.RollData;
import ca.tetervak.diceroller.model.RollDataImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RollerServiceImpl2 implements RollerService {

    // @Autowired is required for the field injections
    // do not use field injections outside of JUnit test classes
    @Autowired
    private Rollable rollable;

    public RollerServiceImpl2() {
    }

    public RollData getRollData(int numberOfDice) {

        if(numberOfDice < 1){
            throw new IllegalArgumentException("Illegal Number of Dice " + numberOfDice);
        }

        List<Integer> list = new ArrayList<>(numberOfDice);
        for(int i = 0; i < numberOfDice; i++){
            list.add(rollable.roll());
        }

        return new RollDataImpl(list);
    }
}
