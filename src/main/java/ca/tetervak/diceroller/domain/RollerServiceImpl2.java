package ca.tetervak.diceroller.domain;

import ca.tetervak.diceroller.model.RollData;
import ca.tetervak.diceroller.model.RollDataImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RollerServiceImpl2 implements RollerService {

    private final Rollable rollable;

    // @Autowired on top of the constructor is optional for injection
    @Autowired
    public RollerServiceImpl2(Rollable rollable) {
        this.rollable = rollable;
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
