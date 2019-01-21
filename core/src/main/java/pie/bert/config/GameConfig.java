package pie.bert.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import pie.bert.GuessCount;
import pie.bert.MaxNumber;

@Configuration
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    @Value("${game.maxNumber}")
    private int maxNumber;
    @Value("${game.guessCount}")
    private int guessCount;

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