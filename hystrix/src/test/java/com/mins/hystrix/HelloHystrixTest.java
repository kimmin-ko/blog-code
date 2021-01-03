package com.mins.hystrix;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloHystrixTest {

    @Test
    void test() {
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        Assertions.assertThat(new HelloHystrix("Hystrix").execute()).isEqualTo("Hello Hystrix");
        Assertions.assertThat(new HelloHystrix("exception").execute()).isEqualTo("fallback!");
    }

    @Test
    void cache() {
        new HelloHystrix("Hystrix").execute();
        new HelloHystrix("Hystrix").execute();
        new HelloHystrix("Hystrix").execute();
        new HelloHystrix("Hystrix").execute();
    }

}