Prepare a delegator of Service here, using which it can be configured to use database or some other medium to manage, the user-management.

Using Jersey framework to host restful services.

Integration of Jersey Rest Services have been done with Spring 3.1.2-RELEASE.

Note
In "jersey-spring.jar" version, it will download all the Spring 2.5.6 dependencies. To use Spring 3, you need to exclude those old Spring libraries manually.

<dependency>
	<groupId>com.sun.jersey.contribs</groupId>
	<artifactId>jersey-spring</artifactId>
	<version>1.8</version>
	<exclusions>
		<exclusion>
			<groupId>org.springframework</groupId>
			<artifactId>spring</artifactId>
		</exclusion>
		<exclusion>
			<groupId>org.springframework</groupId>
			<artifactId>spring-core</artifactId>
		</exclusion>
		<exclusion>
			<groupId>org.springframework</groupId>
			<artifactId>spring-web</artifactId>
		</exclusion>
		<exclusion>
			<groupId>org.springframework</groupId>
			<artifactId>spring-beans</artifactId>
		</exclusion>
		<exclusion>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
		</exclusion>
	</exclusions>
</dependency>

This builds a web-application which is to be hosted on a servlet container, I did it on Tomcat7
Service exposed:

1. To get details of a particular users : http://localhost:8080/um-ws-1.0-SNAPSHOT/rest/user-service/user/{id}

2. To get details of all users : http://localhost:8080/um-ws-1.0-SNAPSHOT/user-service/rest/users

