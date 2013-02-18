Here we have created the API which is to be used locally in order to capture, the details of user-management.

Look into:

We are using XSD to Java classes in order to generate the Model Objects. This provides us the flexibility of multi-development platform support.

Refer to pom.xml to see how the xsd is being converted into Java classes.

1. src/main/resources/schema/um-blueprint.xsd , to get the Java class details for core (internal) API units.

2. src/main/resources/schema/um.xsd , to get the Java class details which are actually exposed as a medium of data-sharing in the hosted rest-services.


---------------------------------------------------------------------------------------

PERFORMANCE MONITORING:

Introduced "MonitorPerformance" annotation in API. Each method which needs to be made performance monitoring can be marked with this annotation.
Using AspectJ logging, we will monitor those methods. The class which does this job is "com.himanshu.um.impl.aop.performance.monitor.DBPerformanceMonitorAOP"

---------------------------------------------------------------------------------------