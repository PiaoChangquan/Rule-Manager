/**************************************************************************************
 * Copyright (C) 2006-2015 EsperTech Inc. All rights reserved.                        *
 * http://www.espertech.com/esper                                                          *
 * http://www.espertech.com                                                           *
 * ---------------------------------------------------------------------------------- *
 * The software in this package is published under the terms of the GPL license       *
 * a copy of which has been included with this distribution in the license.txt file.  *
 **************************************************************************************/
package org.camid.rulemanager.jmx;

import com.espertech.esper.client.UpdateListener;

public interface EPServiceProviderJMXMBean
{
    public void createEPL(String expression, String statementName);
//    public void createEPL(String expression, String statementName,  String string);
    public void destroy(String statementName);
	public void createEPL(String expression, String statementName, String string);
}
