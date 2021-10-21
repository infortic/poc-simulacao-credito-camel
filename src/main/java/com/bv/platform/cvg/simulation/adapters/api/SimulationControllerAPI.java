package com.bv.platform.cvg.simulation.adapters.api;

import org.apache.camel.FluentProducerTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bv.platform.cvg.simulation.core.model.SimulationRequestModel;
import com.bv.platform.cvg.simulation.core.util.ValidationUtil;

@RestController
public class SimulationControllerAPI {

private final FluentProducerTemplate fluentProducerTemplate;
private final ValidationUtil validationUtil;
	
	public SimulationControllerAPI(FluentProducerTemplate fluentProducerTemplate, ValidationUtil validationUtil) {
		this.fluentProducerTemplate = fluentProducerTemplate;
		this.validationUtil = validationUtil;
		}
	
	@GetMapping("/get-proposal")
	public ResponseEntity<?> getProposal(@PathVariable Integer cpf) {
	return	new ResponseEntity<>(fluentProducerTemplate
				.withBody(cpf)
				.to("direct:get-proposal")
				.request(String.class), 
			HttpStatus.OK) ;
	}
	
	@PostMapping("/generate-proposal")
	public ResponseEntity<?> generateProposal(@RequestBody SimulationRequestModel simulationRequestModel) {
		return   new ResponseEntity<>(fluentProducerTemplate
											.withBody(simulationRequestModel.getTeste())
										//	.withHeader("header", simulationRequestModel)
											.to("direct:generate-proposal")
											.request(String.class), 
										HttpStatus.OK) ;
	}
	
}
