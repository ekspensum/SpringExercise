package pl.spring.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import pl.spring.aop.model.JpaTaskRepository;
import pl.spring.aop.model.Task;
import pl.spring.aop.service.TaskService;

@Component
@Aspect
public class SimpleAspect {
	
	@Pointcut("execution(* pl.spring.aop.service.TaskService.getAllTasks())")
	public void execGetAllTasks() {}
	
	@Pointcut("within(*..*Service)")
	public void onlyServices() {}
	
//	@Before(value="bean(*)")
	@Before(value="execution(* *.getTask(*))")
	public void logBefore(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		String name = signature.getName();
		System.out.println("Log Before "+name);
	}

	@Around(value="execution(* *.getTask(*))")
	public Object logAround(ProceedingJoinPoint joinPoint) {
		
		Object[] args = joinPoint.getArgs();
		for (int i = 0; i < args.length; i++) {
			Object object = args[i];
			System.out.println("Parameter "+object);
		}
		
		System.out.println("Around - befor");
		Object result = null;
		try {
			if ((Integer)args[0] == 22) {
				result = joinPoint.proceed(); //if this method will not execute, also not be execute methods below  
				System.out.println("Around AfterReturning - after ");				
			} else {
				System.out.println(joinPoint.getThis());
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Around AfterTrowing - Exception throwed");
		}
		return result;
	}
	
	@AfterReturning("execGetAllTasks()")
	public void logAllTask(JoinPoint joinPoint) {
		System.out.println("After logAllTask "+joinPoint.getSignature().getName());
	}
	
	@Before("onlyServices()")
	public void logAllTaskBefor(JoinPoint join) {
		System.out.println("Befor logAllTask "+join.getSignature().getName());
	}
}
