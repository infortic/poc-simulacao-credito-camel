package com.bv.platform.cvg.simulation.adapters.camel.process;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class PersonProcess implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		
		String personProcess = (String) exchange.getIn().getBody().toString();
		exchange.getOut().setBody(personProcess + "  route PersonProcess  ");
	}
}