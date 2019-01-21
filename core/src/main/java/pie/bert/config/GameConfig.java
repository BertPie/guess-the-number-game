package pie.bert.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import pie.bert.qualifiers.GuessCount;
import pie.bert.qualifiers.MaxNumber;
import pie.bert.qualifiers.MinNumber;

@Configuration
@ComponentScan(basePackages = "pie.bert")
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    @Value("${game.maxNumber:20}")
    private int maxNumber;
    @Value("${game.minNumber:5}")
    private int minNumber;
    @Value("${game.guessCount:5}")
    private int guessCount;

    @Bean
    @MaxNumber
    public int maxNumber(){
        return maxNumber;
    }

    @Bean
    @MinNumber
    public int minNumber(){
        return minNumber;
    }

    @Bean
    @GuessCount
    public int guessCount(){
        return guessCount;
    }
}