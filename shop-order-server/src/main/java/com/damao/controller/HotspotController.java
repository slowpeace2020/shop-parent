package com.damao.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HotspotController {
    @RequestMapping("/hotspot1")
    @SentinelResource(value = "hotspot1")
    public String hotspotTest(Long productId){
        log.info("productId: {}",productId);
        return "hotspot1";
    }
}
