package org.apache.archiva.redback.struts2.action.admin;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.archiva.redback.struts2.action.admin.SystemInfoAction;
import org.apache.struts2.StrutsSpringTestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * SystemInfoActionTest
 *
 * @author <a href="mailto:joakim@erdfelt.com">Joakim Erdfelt</a>
 *
 */
@RunWith( JUnit4.class )
public class SystemInfoActionTest
    extends StrutsSpringTestCase
{
    private SystemInfoAction systeminfo;

    @Override
    protected String[] getContextLocations()
    {
        return new String[]{ "classpath*:/META-INF/spring-context.xml", "classpath*:/spring-context.xml" };
    }

    @Before
    public void setUp()
        throws Exception
    {
        super.setUp();

        systeminfo = (SystemInfoAction) getActionProxy( "/security/systeminfo" ).getAction();

        //systeminfo = (SystemInfoAction) lookup( "com.opensymphony.xwork2.Action", "redback-sysinfo" );
    }

    @Test
    public void testSystemInfoDump()
    {
        String result = systeminfo.show();
        assertNotNull( result );
        assertEquals( "success", result );
        assertNotNull( systeminfo.getDetails() );
    }
}