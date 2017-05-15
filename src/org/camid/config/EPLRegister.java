package org.camid.config;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.camid.rulemanager.jmx.EPServiceProviderJMXMBean;


public class EPLRegister {

    private static Log log = LogFactory.getLog(EPLRegister.class);
	public static void EPLRegister(EPServiceProviderJMXMBean proxy) {
		log.info("start register EPL");
		List<EPLinformation> Epl=EPLUnitConfig.EPLinformation;
		List<String> DeEpl=EPLUnitConfig.DestroyEPLinformation;
		for(int i=0;i<Epl.size();i++){
			proxy.createEPL(Epl.get(i).getStatement(), Epl.get(i).getName(),Epl.get(i).getListener());
			System.out.println(Epl.toString());
		}
		for(int i=0;i<DeEpl.size();i++){
			proxy.destroy(DeEpl.get(i).toString());
			System.out.println(DeEpl.get(i).toString());
		}
		

		log.info("Register EPL Finish!");
	}

}
