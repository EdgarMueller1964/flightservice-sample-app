package com.thinkenterprise.actuator;

import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@Component
public class FlightServiceCounter {

	private MeterRegistry meterRegistry;
	
	private Counter routeRequestCount;
	
	public FlightServiceCounter(MeterRegistry meterRegistry) {
		this.meterRegistry = meterRegistry;
		this.initializeCounters();
	}
	
	
	void initializeCounters () {
	
		routeRequestCount = Counter
				  .builder("routeRequests")
				  .description("counts the number of routes query requests")
				  .tags("clients", "performance")
				  .register(this.meterRegistry);
	}
	
	
	public double incrementRouteRequestCountCounter() {
		routeRequestCount.increment();
		return routeRequestCount.count();
	}
}


