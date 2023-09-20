package com.damao.sentinel;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.alibaba.fastjson.JSON;
import com.damao.entity.ResultData;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 统一处理sentinel异常
 */
@Component
public class ExceptionHandlerPage implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        ResultData data = null;
        if(e instanceof FlowException){
            data = new ResultData(-1, "traffic limiting");
        }else if(e instanceof DegradeException){
            data = new ResultData(-2,"service degrade");
        }else if(e instanceof ParamFlowException){
            data = new ResultData(-2,"param limiting");
        }else if(e instanceof AuthorityException){
            data = new ResultData(-2,"no auth");
        }else if(e instanceof SystemBlockException){
            data = new ResultData(-2,"system limiting");
        }
        httpServletResponse.getWriter().write(JSON.toJSONString(data));
    }
}
