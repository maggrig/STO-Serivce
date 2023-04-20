package mag.grig;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MainSTO {
    private static final Logger logger = LogManager.getLogger(MainSTO.class);

    public static void main(String[] args) {
        logger.info("Starting registration");
        SpringApplication.run(MainSTO.class, args);

    }

}
