package ca.tetervak.diceroller.cookiedata;

import ca.tetervak.diceroller.model.RollData;
import ca.tetervak.diceroller.model.RollDataImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

class CookieDataService1Test {

    List<Integer> inputList = List.of(2, 6, 2, 1, 7, 1);
    CookieDataService service = new CookieDataService1();

    @Test
    void encodeRollData() {
        out.println(inputList);
        out.println(service.encodeRollData(new RollDataImpl(inputList)));
    }

    @Test
    void decodeRollData() {
        out.println(inputList);
        String cookieData = service.encodeRollData(new RollDataImpl(inputList));
        RollData rollData = service.decodeRollData(cookieData);
        out.println(rollData.getValues());
        assertEquals(inputList, rollData.getValues());
    }
}
