package pie.bert;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class WebMain {

    public static void main(String[] args) {
        log.info("starting web main.");
        SpringApplication.run(WebMain.class, args);
    }
}
