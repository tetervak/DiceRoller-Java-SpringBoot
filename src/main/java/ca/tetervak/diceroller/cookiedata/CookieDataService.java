package ca.tetervak.diceroller.cookiedata;

import ca.tetervak.diceroller.model.RollData;

public interface CookieDataService {

    String encodeRollData(RollData rollData);

    RollData decodeRollData(String cookieValue);

}
