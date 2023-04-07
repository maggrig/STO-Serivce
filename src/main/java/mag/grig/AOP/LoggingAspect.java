package mag.grig.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* mag.grig.service.security.UserService.*(..))")
    public void logBeforeUserService(JoinPoint joinPoint) {
        System.out.println("Before method execution: " + joinPoint.getSignature().getName());
        Stream.of(joinPoint.getArgs()).forEach(System.out::println);
    }

    @Before("execution(* mag.grig.service.security.RoleService.*(..))")
    public void logBeforeRoleService(JoinPoint joinPoint) {
        System.out.println("Before method execution: " + joinPoint.getSignature().getName());
        Stream.of(joinPoint.getArgs()).forEach(System.out::println);
    }

    @Before("execution(* mag.grig.service.security.UserRoleService.*(..))")
    public void logBeforeUserRoleService(JoinPoint joinPoint) {
        System.out.println("Before method execution: " + joinPoint.getSignature().getName());
        Stream.of(joinPoint.getArgs()).forEach(System.out::println);
    }

}