package com.mins.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class HelloHystrix extends HystrixCommand<String> {

    private String name;

    public HelloHystrix(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());

        if (name.equals("exception"))
            throw new RuntimeException("runtime exception!");

        return "Hello " + name;
    }

    @Override
    protected String getFallback() {
        return "fallback!";
    }

    @Override
    protected String getCacheKey() {
        return name;
    }
}
