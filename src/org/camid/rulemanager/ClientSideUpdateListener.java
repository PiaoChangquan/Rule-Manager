/**************************************************************************************
 * Copyright (C) 2006-2015 EsperTech Inc. All rights reserved.                        *
 * http://www.espertech.com/esper                                                          *
 * http://www.espertech.com                                                           *
 * ---------------------------------------------------------------------------------- *
 * The software in this package is published under the terms of the GPL license       *
 * a copy of which has been included with this distribution in the license.txt file.  *
 **************************************************************************************/
package org.camid.rulemanager;


import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class ClientSideUpdateListener implements Serializable, UpdateListener
{
    private static Log log = LogFactory.getLog(ClientSideUpdateListener.class);

	public void update(EventBean[] newEvents, EventBean[] oldEvents)
    {
        log.info("Temp over 20: id: " + newEvents[0].get("id") +
             " value: " + newEvents[0].get("value"));
        System.out.println("Temp over 20: id: " + newEvents[0].get("id") +
                " value: " + newEvents[0].get("value"));
    }

}