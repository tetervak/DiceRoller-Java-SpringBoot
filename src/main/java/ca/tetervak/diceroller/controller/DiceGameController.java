package ca.tetervak.diceroller.controller;

import ca.tetervak.diceroller.model.RollData;
import ca.tetervak.diceroller.service.DiceRollerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DiceGameController {

    private final Logger log = LoggerFactory.getLogger(DiceGameController.class);

    private final DiceRollerService diceRollerService;

    public DiceGameController(DiceRollerService diceRollerService) {
        this.diceRollerService = diceRollerService;
    }

    @GetMapping(value = {"/", "/dice-game"})
    public ModelAndView diceGame(
            @RequestParam(defaultValue = "3") int numberOfDice,
            @RequestParam(defaultValue = "false") boolean isRolled
    ){
        log.trace("diceGame() is called");
        log.debug("numberOfDice = " + numberOfDice);
        log.debug("isRolled = " + isRolled);

        if(isRolled){
            log.debug("dice is rolled");
            RollData rollData;
            if(numberOfDice > 0 && numberOfDice <= 5){
                rollData = diceRollerService.getRollData(numberOfDice);
            }else{
                log.warn("the numberOfDice is out of the range " + numberOfDice);
                rollData = diceRollerService.getRollData(3);
            }
            log.debug("rollData = " + rollData);
            return  new ModelAndView("GameResult", "rollData", rollData);
        }else{
            log.debug("dice is not rolled");
            return new ModelAndView("GameStart");
        }
    }

}
