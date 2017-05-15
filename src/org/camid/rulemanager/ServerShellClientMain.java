/**************************************************************************************
 * Copyright (C) 2006-2015 EsperTech Inc. All rights reserved.                        *
 * http://www.espertech.com/esper                                                          *
 * http://www.espertech.com                                                           *
 * ---------------------------------------------------------------------------------- *
 * The software in this package is published under the terms of the GPL license       *
 * a copy of which has been included with this distribution in the license.txt file.  *
 **************************************************************************************/
package org.camid.rulemanager;

//import com.espertech.esper.example.servershell.ServerShellConstants;
//import com.espertech.esper.example.servershell.jms.JMSContext;
//import com.espertech.esper.example.servershell.jms.JMSContextFactory;
//import com.espertech.esper.example.servershell.jmx.EPServiceProviderJMXMBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.camid.config.ConfigLoader;
import org.camid.config.EPLRegister;
import org.camid.rulemanager.jmx.EPServiceProviderJMXMBean;

//
//import javax.jms.BytesMessage;
//import javax.jms.DeliveryMode;
//import javax.jms.MessageProducer;
import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class ServerShellClientMain
{
	private static final String CONF_PATH = "./Rule_config.json";
    private static Log log = LogFactory.getLog(ServerShellClientMain.class);
    private static EPServiceProviderJMXMBean proxy;
    public static void main(String[] args) throws Exception
    {
    	

		ConfigLoader.loadAllConfig(CONF_PATH);
    	proxy=ServerShellClientMain();

		EPLRegister.EPLRegister(proxy);
        
    }

	public static EPServiceProviderJMXMBean ServerShellClientMain() throws Exception
    {
    	
        log.info("Loading properties");

        log.info("Attach to server via JMX");
//        JMXServiceURL url = new JMXServiceURL(properties.getProperty(ServerShellConstants.MGMT_SERVICE_URL));
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:5554/server");

//        String jmxServiceURL = "service:jmx:rmi:///jndi/rmi://localhost:5554/server";
        JMXConnector jmxc = JMXConnectorFactory.connect(url, null);
        MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();
        ObjectName mBeanName = new ObjectName(ServerShellConstants.MGMT_MBEAN_NAME);
        EPServiceProviderJMXMBean proxy = (EPServiceProviderJMXMBean) MBeanServerInvocationHandler.newProxyInstance(
                     mbsc, mBeanName, EPServiceProviderJMXMBean.class, true);


        return proxy;
        
        // Create statement via JMX
//        	System.out.println("Creating a statement via Java Management Extensions (JMX) MBean Proxy");
//        	proxy.createEPL("select * from sensor(value>20)","filter", "null");
//
//
//        System.out.println("Destroing statement via Java Management Extensions (JMX) MBean Proxy");
//        proxy.destroy("filterStatement");
//
//
//        System.out.println("Exiting");
//        System.exit(-1);
    }
}
