package ca.tetervak.diceroller.controller;

import ca.tetervak.diceroller.cookiedata.CookieDataService;
import ca.tetervak.diceroller.model.RollData;
import ca.tetervak.diceroller.domain.RollerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class GameController {

    private final Logger log = LoggerFactory.getLogger(GameController.class);

    private final RollerService rollerService;
    private final CookieDataService cookieDataService;

    public GameController(
            RollerService rollerService,
            @Qualifier("cookieDataService1") CookieDataService cookieDataService) {
        this.rollerService = rollerService;
        this.cookieDataService = cookieDataService;
    }

    @GetMapping(value = {"/", "/dice-game"})
    public ModelAndView diceGame(
            @RequestParam(defaultValue = "3") int numberOfDice,
            @RequestParam(defaultValue = "false") boolean isRolled,
            HttpServletResponse response,
            @CookieValue(value="rollData", defaultValue = "") String cookieValue
    ){
        log.trace("diceGame() is called");
        log.debug("numberOfDice = " + numberOfDice);
        log.debug("isRolled = " + isRolled);

        if(isRolled){
            log.debug("dice is rolled");
            RollData rollData;
            if(numberOfDice > 0 && numberOfDice <= 5){
                rollData = rollerService.getRollData(numberOfDice);
            }else{
                log.warn("the numberOfDice is out of the range " + numberOfDice);
                rollData = rollerService.getRollData(3);
            }
            log.debug("rollData = " + rollData);
            Cookie cookie = new Cookie(
                    "rollData",
                    cookieDataService.encodeRollData(rollData));
            response.addCookie(cookie);
            return  new ModelAndView("GameResult", "rollData", rollData);
        }else{
            log.debug("dice is not rolled");
            if(cookieValue.isEmpty()){
                log.debug("no previously saved state in the cookie");
                return new ModelAndView("GameStart");
            }else{
                log.debug("restoring previous state from the cookie");
                RollData rollData = cookieDataService.decodeRollData(cookieValue);
                return new ModelAndView("GameResult", "rollData", rollData);
            }
        }
    }

}
