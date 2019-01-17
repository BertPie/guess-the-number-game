package pie.bert.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pie.bert.Game;
import pie.bert.GameImpl;
import pie.bert.NumberGenerator;
import pie.bert.NumberGeneratorImpl;

@Configuration
@Import(GameConfig.class)
@ComponentScan(basePackages = "pie.bert")
public class AppConfig {

    @Bean
    public NumberGenerator numberGenerator(){
        return new NumberGeneratorImpl();
    }

    @Bean
    public Game game(){
        return new GameImpl();
    }

}
