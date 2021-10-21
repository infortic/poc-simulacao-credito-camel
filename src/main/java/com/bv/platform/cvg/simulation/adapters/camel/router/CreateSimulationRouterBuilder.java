package com.bv.platform.cvg.simulation.adapters.camel.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.bv.platform.cvg.simulation.adapters.camel.process.CreditAnalysisProcess;
import com.bv.platform.cvg.simulation.adapters.camel.process.EligibilityProcess;
import com.bv.platform.cvg.simulation.adapters.camel.process.FinalProcess;
import com.bv.platform.cvg.simulation.adapters.camel.process.GenerateProposalProcess;
import com.bv.platform.cvg.simulation.adapters.camel.process.PersonProcess;
import com.bv.platform.cvg.simulation.adapters.camel.process.VehicleProcess;

@Component
public class CreateSimulationRouterBuilder extends RouteBuilder{
	@Override
	public void configure() throws Exception {
		
		from("direct:generate-proposal")
				.log("**** 'Início do processamento, Rota 1' ****")
				.process(new GenerateProposalProcess())
				.to("direct:person-process")
				.end();
		
		from("direct:person-process")
				.log("**** 'processando person, Rota 2' ****")
				.process(new PersonProcess())
				.to("direct:vehicle-process")
				.end();
		
		from("direct:vehicle-process")
				.log("**** 'processando veiculo, Rota 3' ****")
				.process(new VehicleProcess())
				.to("direct:eligibility-process")
				.end();
		
		from("direct:eligibility-process")
				.log("**** 'processando elegibilidade, Rota 4' ****")
				.process(new EligibilityProcess())
				.to("direct:credit-analysis-process")
				.end();
		
		from("direct:credit-analysis-process")
				.log("**** 'processando analize de credito, Rota 5' ****")
				.process(new CreditAnalysisProcess())
				.to("direct:final-process")
				.end();
		
		from("direct:final-process")
				.log("**** 'consolidado dados, rota final, Rota 6' ****")
				.process(new FinalProcess())
				.end();
		
//		from("direct:generate-proposal")
//		.log("Entrou na rota 'getProposta'")
//		.process(new ValidaDadosProcess())
//		.end();
	}
}
