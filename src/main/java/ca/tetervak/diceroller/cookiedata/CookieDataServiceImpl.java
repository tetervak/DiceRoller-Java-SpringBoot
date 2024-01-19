package ca.tetervak.diceroller.cookiedata;

import ca.tetervak.diceroller.model.RollData;
import ca.tetervak.diceroller.model.RollDataImpl;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CookieDataServiceImpl implements CookieDataService{
    @Override
    public String encodeRollData(RollData rollData) {
        return rollData.getValues().stream()
                .map(Object::toString)
                .collect(Collectors.joining("+"));
    }

    @Override
    public RollData decodeRollData(String cookieValue) {
        List<Integer> values = Arrays.stream(cookieValue.split("\\+"))
                        .map(Integer::parseInt)
                        .toList();
        return new RollDataImpl(values);
    }
}
