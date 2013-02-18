In Spring bean configurations, if you have multiple bean definitions which are of type: XML and Annotation, then:::

In your main context file which you are loading via Spring to load bean definitions, you should add the following lines.

<context:annotation-config />
<!-- This is added to add annotated bean in the application context, if I don't do this then annotated beans are not considered -->
<context:component-scan base-package="<base package name>" />


SAMPLE FILE:
--------------------------------------------------------------------------------
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:tx="http://www.springframework.org/schema/tx"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans

http://www.springframework.org/schema/beans/spring-beans.xsd

http://www.springframework.org/schema/tx

http://www.springframework.org/schema/tx/spring-tx.xsd

http://www.springframework.org/schema/context

http://www.springframework.org/schema/context/spring-context-3.0.xsd">

<context:annotation-config />

<!-- This is added to add annotated bean in the application context, if I don't do this then annotated beans are not considered -->
<context:component-scan base-package="com.himanshu" />

<context:property-placeholder location="classpath:db.properties" />

<import resource="classpath:um-db.xml" />
<import resource="classpath:um-dao.xml" />
<import resource="classpath:um-services.xml" />



</beans>
---------------------------------------------------------------------------------------

Refer to code here, UserDao is loaded with Annotations whereas the PrivilegeDao and RoleDao are loaded using XML definition. Hope this helps.

---------------------------------------------------------------------------------------

PERFORMANCE MONITORING:

Introduced "MonitorPerformance" annotation in API. Each method which needs to be made performance monitoring can be marked with this annotation.
Using AspectJ logging, we will monitor those methods. The class which does this job is "com.himanshu.um.impl.aop.performance.monitor.DBPerformanceMonitorAOP"

---------------------------------------------------------------------------------------

AspectJ is wired in Spring context all using annotations, nice to go through.

Just add this line in the root spring config file:
<aop:aspectj-autoproxy />


Or if you want to do with XML configuration refer to um-aop.xml, this contains a commented bean which is an aspectJ AOP.

Sample code for AspectJ Class is:

<Code>

@Component
@Aspect
public class DBPerformanceMonitorAOP {

	Logger LOG = LoggerFactory.getLogger("performance.logging");

	@Around("execution(@com.himanshu.um.api.performance.annotation.MonitorPerformance * *(..))")
	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		joinPoint.proceed(); // continue on the intercepted method
		LOG.debug("{}, {}, {}", new Object[] {joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName(), System.currentTimeMillis() - startTime});
	}

}

</Code>
----------------------------------------------------------------------------------------