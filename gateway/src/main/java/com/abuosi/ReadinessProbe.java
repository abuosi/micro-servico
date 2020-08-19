package com.abuosi;

import javax.inject.Inject;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Readiness
public class ReadinessProbe implements HealthCheck {

    @Inject
    @RestClient
    TimeService timeservice;

    @Override
    public HealthCheckResponse call() {        

        if (timeservice.getTime() == null){
            return HealthCheckResponse.down("Aguardando Serviço TIME estar UP ...");
        } else{
            return HealthCheckResponse.up("Serviço TIME esta UP !");
        }
        
    }
    
}