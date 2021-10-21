package com.bv.platform.cvg.simulation.core.util;

import org.springframework.stereotype.Service;

import com.bv.platform.cvg.simulation.core.model.SimulationRequestModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
public class ValidationUtil {

	public Boolean validationRequest(SimulationRequestModel simulationRequestModel) {
		return true;
	}
	
}
