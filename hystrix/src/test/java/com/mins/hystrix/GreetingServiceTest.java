package com.mins.hystrix;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

class GreetingServiceTest {

    @InjectMocks
    GreetingService service;

    @Test
    void test() {
        String mins = service.getGreeting("mins");

        Assertions.assertThat(mins).isEqualTo("fallback");
    }
}