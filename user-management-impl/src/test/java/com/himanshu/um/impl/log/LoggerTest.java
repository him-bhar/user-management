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
package com.himanshu.um.impl.log;

import org.junit.Ignore;
import org.junit.Test;

import com.himanshu.logging.AccountLogger;

public class LoggerTest {
	
	@Ignore
	@Test
	public void testLogMessageWithoutMarker() {
		AccountLogger logger = new AccountLogger(getClass(), "testing");
		logger.debug("Test1"); //Since marker is not supplied, hence default value is supplied from discriminator class
	}

}
