package pie.bert.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pie.bert.AppConfig;
import pie.bert.MessageGenerator;
import pie.bert.NumberGenerator;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
        LOG.info("Starting console.");

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);
        int number = numberGenerator.next();
        LOG.info("number = {}", number);

        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
        String mainMessage = messageGenerator.getMainMessage();
        String resultMessage = messageGenerator.getResultMessage();
        LOG.info(mainMessage);
        LOG.info(resultMessage);

        context.close();
    }
}