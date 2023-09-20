package com.damao.controller;

import com.damao.service.impl.TraceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TraceController {
    @Autowired
    private TraceServiceImpl traceService;

    @RequestMapping("/trace1")
    public String trace1(){
        traceService.traceService();
        return "trace1";
    }

    @RequestMapping("/trace2")
    public String trace2(){
        traceService.traceService();
        return "trace2";
    }

}
