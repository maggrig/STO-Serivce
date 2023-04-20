package mag.grig.AOP;

//import lombok.extern.log4j.Log4j2;
//import org.apache.logging.log4j.LogManager;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Stream;

@Aspect
@Component
@Log4j2
public class LoggingAspect {
//    private static final Logger log = LogManager.getLogger(LoggingAspect.class);
//    private static final Logger logger = LogManager.getLogger();

    @Before("execution(* mag.grig.service.security.UserService.*(..))")
    public void logBeforeUserService(JoinPoint joinPoint) {

        log.info(joinPoint.getSignature().getName() + Arrays.toString(joinPoint.getArgs()));
//        logger.info(joinPoint.getSignature().getName() + Arrays.toString(joinPoint.getArgs()));
        System.out.println("Before method execution: " + joinPoint.getSignature().getName());
        Stream.of(joinPoint.getArgs()).forEach(System.out::println);
    }

    @Before("execution(* mag.grig.service.security.RoleService.*(..))")
    public void logBeforeRoleService(JoinPoint joinPoint) {
        log.info(joinPoint.getSignature().getName() + Arrays.toString(joinPoint.getArgs()));
        System.out.println("Before method execution: " + joinPoint.getSignature().getName());
        Stream.of(joinPoint.getArgs()).forEach(System.out::println);
    }

    @Before("execution(* mag.grig.service.security.UserRoleService.*(..))")
    public void logBeforeUserRoleService(JoinPoint joinPoint) {
        log.info(joinPoint.getSignature().getName() + Arrays.toString(joinPoint.getArgs()));
        System.out.println("Before method execution: " + joinPoint.getSignature().getName());
        Stream.of(joinPoint.getArgs()).forEach(System.out::println);
    }

    @Before("execution(* mag.grig.service.ClientService.*(..))")
    public void logBeforeClientService(JoinPoint joinPoint) {
        log.info(joinPoint.getSignature().getName() + Arrays.toString(joinPoint.getArgs()));
        System.out.println("Before method execution: " + joinPoint.getSignature().getName());
        Stream.of(joinPoint.getArgs()).forEach(System.out::println);
    }

    @Before("execution(* mag.grig.service.OrderService.*(..))")
    public void logBeforeOrderService(JoinPoint joinPoint) {
        log.info(joinPoint.getSignature().getName() + Arrays.toString(joinPoint.getArgs()));
        System.out.println("Before method execution: " + joinPoint.getSignature().getName());
        Stream.of(joinPoint.getArgs()).forEach(System.out::println);
    }

    @Before("execution(* mag.grig.service.CarService.*(..))")
    public void logBeforeCarService(JoinPoint joinPoint) {
        log.info(joinPoint.getSignature().getName() + Arrays.toString(joinPoint.getArgs()));
        System.out.println("Before method execution: " + joinPoint.getSignature().getName());
        Stream.of(joinPoint.getArgs()).forEach(System.out::println);
    }

    @Before("execution(* mag.grig.service.PostService.*(..))")
    public void logBeforePostService(JoinPoint joinPoint) {
        log.info(joinPoint.getSignature().getName() + Arrays.toString(joinPoint.getArgs()));
        System.out.println("Before method execution: " + joinPoint.getSignature().getName());
        Stream.of(joinPoint.getArgs()).forEach(System.out::println);
    }

    @Before("execution(* mag.grig.service.AutoPartsService.*(..))")
    public void logBeforeAutoPartsService(JoinPoint joinPoint) {
        log.info(joinPoint.getSignature().getName() + Arrays.toString(joinPoint.getArgs()));
        System.out.println("Before method execution: " + joinPoint.getSignature().getName());
        Stream.of(joinPoint.getArgs()).forEach(System.out::println);
    }
}