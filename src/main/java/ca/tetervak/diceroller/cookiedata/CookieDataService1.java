package ca.tetervak.diceroller.cookiedata;

import ca.tetervak.diceroller.model.RollData;
import ca.tetervak.diceroller.model.RollDataImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CookieDataService1 implements CookieDataService{
    @Override
    public String encodeRollData(RollData rollData) {
        List<Integer> values = rollData.getValues();
        StringBuilder builder = new StringBuilder(values.size());
        for(int value: values){
            builder.append(value);
        }
        return builder.toString();
    }

    @Override
    public RollData decodeRollData(String cookieValue) {
        int length = cookieValue.length();
        List<Integer> values = new ArrayList<>(length);
        for(int i = 0; i < length; i++){
            values.add(Integer.parseInt(String.valueOf(cookieValue.charAt(i))));
        }
        return new RollDataImpl(values);
    }
}
