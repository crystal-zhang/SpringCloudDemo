package org.crystal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class GateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class, args);
    }

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
//		return builder.routes()
//				.route(r -> r.path("/gate/**").filters(f -> f.stripPrefix(1)).uri("http://localhost:8088/index"))
//				.build();
        return builder.routes()
                .route(r -> r.path("/java/**").filters(f -> f.stripPrefix(1)).uri("http://localhost:8088/index"))
                .build();
    }

}
