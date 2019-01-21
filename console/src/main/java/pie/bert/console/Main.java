package pie.bert.console;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pie.bert.config.GameConfig;

@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("Starting console.");
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);
        context.close();
    }
}