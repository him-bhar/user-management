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