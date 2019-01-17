package pie.bert.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pie.bert.GuessCount;
import pie.bert.MaxNumber;

@Configuration
public class GameConfig {
    private int maxNumber = 25;
    private int guessCount = 8;

    @Bean
    @MaxNumber
    public int maxNumber(){
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount(){
        return guessCount;
    }
}
