package com.gaurav.microservices.api_gateway;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator customizeRouteLocator(RouteLocatorBuilder routeLocatorBuilder){

        // return same urls
        // routeLocatorBuilder.routes().build();

        Function<PredicateSpec, Buildable<Route>> routeFunction =
                p -> p.path("/get")
                        .filters(f ->
                                f.addRequestHeader("MyHeader","Some Value")
                                        .addRequestParameter("MyParam", "My value"))
                        .uri("http://httpbin.org:80");

        Function<PredicateSpec, Buildable<Route>> routeFunction1 =
                p -> p.path("/hello/**")
                        .filters(f ->
                                f.rewritePath("/hello/(?<segment>.*)"
                                        ,"/currency-exchange/${segment}"))
                        .uri("lb://currency-exchange");

        Function<PredicateSpec, Buildable<Route>> routeFunction2 =
                p -> p.path("/currency-exchange/**")
                        .uri("lb://currency-exchange");

        return routeLocatorBuilder
                .routes()
                .route(routeFunction)
                .route(routeFunction1)
                .route(routeFunction2)
                .build();
    }
}
