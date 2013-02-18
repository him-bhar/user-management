/*
 * Copyright 2013 Himanshu Bhardwaj
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.himanshu.um.impl.aop.performance.monitor;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class DBPerformanceMonitorAOP {

	Logger LOG = LoggerFactory.getLogger("performance.logging");

	@Around("execution(@com.himanshu.um.api.performance.annotation.MonitorPerformance * *(..))")
	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		/*LOG.debug("logAround() is running!");
		LOG.debug("hijacked method : " + joinPoint.getSignature().getName());
		LOG.debug("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));
		LOG.debug("Around before is running!");
		joinPoint.proceed(); // continue on the intercepted method
		LOG.debug("Around after is running!");
		LOG.debug("******");*/
		joinPoint.proceed(); // continue on the intercepted method
		LOG.debug("{}, {}, {}", new Object[] {joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName(), System.currentTimeMillis() - startTime});
	}

}
