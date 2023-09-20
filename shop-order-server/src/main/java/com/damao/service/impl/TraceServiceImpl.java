package com.damao.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TraceServiceImpl {
    @SentinelResource(value = "traceService")
    public void traceService(){
        log.info("use traceService method");
    }
}
