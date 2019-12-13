package com.thinkenterprise.domain.route.graphql.resolver.query;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.thinkenterprise.domain.route.jpa.model.Flight;
import com.thinkenterprise.domain.route.jpa.model.Route;
import com.thinkenterprise.domain.route.jpa.repository.FlightRepository;
import com.thinkenterprise.flightservice.model.FlightPrice;
import com.thinkenterprise.flightservice.service.FlightService;

/**  
* GraphQL Spring Boot Samples 
* Design and Development by msg Applied Technology Research
* Copyright (c) 2018 msg systems ag (http://www.msg-systems.com/)
* All Rights Reserved.
* 
* @author Michael Schäfer
*/

@Profile("!mapper")
@Component(RouteQueryResolver.ROOT_QUERY_RESOLVER)
public class RouteQueryResolver implements GraphQLResolver<Route> {

	static final String ROOT_QUERY_RESOLVER = "com.thinkenterprise.domain.route.graphql.resolver.query.RouteQueryResolver";
    private FlightRepository flightRepository;

    @Autowired
    FlightService flightsService;
    
    public RouteQueryResolver() {
		super();
	}

	@Autowired
    public RouteQueryResolver(FlightRepository flightRepository) {
        this.flightRepository=flightRepository;
    }
       
// Disable if Profile context is enabled an Data Loader method below is enabled   	
    public List<Flight> flights(Route route) {
       	return flightRepository.findByRoute(route);	
    }

    public double totalPrice(Route route) {
       	List<Flight> flights = flightRepository.findByRoute(route);
       	List<FlightPrice> flightPrices  = flights.stream().map(flight -> (FlightPrice)flight).collect(Collectors.toList());
       	return flightsService.totalPrice(flightPrices);
    }
    
// Enable if Profile context is enabled 
//    public CompletableFuture<List<Flight>> flights(Route route, DataFetchingEnvironment dataFetchingEnvironment) {  
//    	DataLoader<Long,Flight> dataLoader = dataFetchingEnvironment.getDataLoader("flight");
//    	return dataLoader.loadMany(KeyUtils.getKeys(route.getId()));
//    }
//    
 
    

}