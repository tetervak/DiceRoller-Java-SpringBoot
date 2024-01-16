package ca.tetervak.diceroller.domain;

import ca.tetervak.diceroller.model.RollData;
import ca.tetervak.diceroller.model.RollDataImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class RollerServiceStream implements RollerService {

    private final Random random;

    public RollerServiceStream(Random random) {
        this.random = random;
    }

    public RollerServiceStream() {
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
