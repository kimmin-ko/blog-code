package com.mins.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GreetingService {

    @HystrixCommand(fallbackMethod = "getFallback")
    public String getGreeting(String username) {
        return errorMethod();
    }

    public String errorMethod() {
        throw new RuntimeException("runtime exception!");
    }

    public String getFallback() {
        return "fallback";
    }

}
