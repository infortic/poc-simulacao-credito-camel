package com.bv.platform.cvg.simulation.adapters.camel.process;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class EligibilityProcess implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		
		String eligibilityProcess = (String) exchange.getIn().getBody().toString();
		exchange.getOut().setBody(eligibilityProcess + "  route EligibilityProcess  ");
	}
}
