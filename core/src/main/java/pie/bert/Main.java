package pie.bert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);
    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        LOG.info("Starting core.");

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
        NumberGenerator numberGenerator = context.getBean("numberGenerator", NumberGenerator.class);

        int number = numberGenerator.next();

        LOG.info("number = {}", number);

        context.close();
    }
}
