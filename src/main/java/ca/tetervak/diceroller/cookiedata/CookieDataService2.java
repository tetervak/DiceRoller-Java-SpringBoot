package ca.tetervak.diceroller.cookiedata;

import ca.tetervak.diceroller.model.RollData;
import ca.tetervak.diceroller.model.RollDataImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class CookieDataService2 implements CookieDataService{
    @Override
    public String encodeRollData(RollData rollData) {
        List<Integer> values = rollData.getValues();
        byte[] bytes = new byte[values.size()];
        for(int i = 0; i < bytes.length; i++){
            bytes[i] = (byte)(int) values.get(i);
        }
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(bytes);
    }

    @Override
    public RollData decodeRollData(String cookieValue) {
        Base64.Decoder decoder  = Base64.getDecoder();
        byte[] bites = decoder.decode(cookieValue);
        List<Integer> values = new ArrayList<>(bites.length);
        for(byte value: bites){
            values.add((int)value);
        }
        return new RollDataImpl(values);
    }
}
