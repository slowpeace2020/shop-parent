package com.damao.filter.factory;


import lombok.Setter;
import lombok.Getter;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Component
public class TimeGatewayFilterFactory extends AbstractGatewayFilterFactory<TimeGatewayFilterFactory.Config> {
    @Override
    public GatewayFilter apply(Config config) {
        return new GatewayFilter() {
            //前置逻辑
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                if(!config.show){
                    return chain.filter(exchange);
                }
                long start = System.currentTimeMillis();
                System.out.println("前置逻辑-------"+config.show);
                return chain.filter(exchange).then(Mono.fromRunnable(()->{
                    //后置逻辑
                    System.out.println("请求耗时："+(System.currentTimeMillis()-start));
                }));
            }
        };
    }

    public TimeGatewayFilterFactory(){
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        //拦截之后调用apply方法，将创建对象时反射创建的Config传进来
//        return Arrays.asList("show","xx","yy");
        return Arrays.asList("show");
    }

    @Setter
    @Getter
    static class Config{
        private boolean show;
//        private Long xx;
//        private String yy;
    }
}
