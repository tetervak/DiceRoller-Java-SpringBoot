package ca.tetervak.diceroller.domain;

import ca.tetervak.diceroller.model.RollData;
import ca.tetervak.diceroller.model.RollDataImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class RollerServiceImpl1 implements RollerService {

    private final Random random;

    public RollerServiceImpl1(Random random) {
        this.random = random;
    }

    public RollerServiceImpl1() {
        this(new Random());
    }

    @Override
    public RollData getRollData(int numberOfDice) {

        List<Integer> list = random
                .ints(numberOfDice, 1, 7)
                .boxed()
                .collect(Collectors.toList());

        return new RollDataImpl(list);
    }
}
