package ca.tetervak.diceroller.config;

import ca.tetervak.diceroller.domain.Dice;
import ca.tetervak.diceroller.domain.Rollable;
import ca.tetervak.diceroller.domain.RollerService;
import ca.tetervak.diceroller.domain.RollerServiceImpl2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiceRollerConfig {

    @Bean
    Rollable rollable(){
        return new Dice();
    }

    @Bean
    RollerService rollerService(Rollable rollable){
        return new RollerServiceImpl2(rollable);
    }

}
