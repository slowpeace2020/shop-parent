package com.damao.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class SentinelController {

    @RequestMapping("/sentinel1")
    public String sentinelTest() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return "sentinelTest";
    }
    @RequestMapping("/sentinel2")
    public String sentinelTest2() throws InterruptedException {
        return "sentinelTest";
    }

}
