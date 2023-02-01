package ca.tetervak.diceroller.cookiedata;

import ca.tetervak.diceroller.model.RollData;
import ca.tetervak.diceroller.model.RollDataImpl;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Base64;
import java.util.List;

@Service
public class CookieDataService3 implements CookieDataService {
    @Override
    public String encodeRollData(RollData rollData) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (ObjectOutputStream objectOutputStream =
                     new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutputStream.writeObject(rollData.getValues());
            objectOutputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(byteArrayOutputStream.toByteArray());
    }

    @Override
    public RollData decodeRollData(String cookieValue) {
        Base64.Decoder decoder  = Base64.getDecoder();
        byte[] bites = decoder.decode(cookieValue);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bites);
        try (ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
            List<Integer> values = (List<Integer>) objectInputStream.readObject();
            return new RollDataImpl(values);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
