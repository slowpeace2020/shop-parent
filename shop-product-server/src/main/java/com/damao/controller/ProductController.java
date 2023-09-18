package com.damao.controller;

import com.alibaba.fastjson.JSON;
import com.damao.domain.Product;
import com.damao.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProductController {
    @Autowired
    private IProductService productService;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/product/{pid}")
    public Product findByPid(@PathVariable("pid") Long pid){
        log.info("product query by pid: {} ",pid);
        Product product = productService.findByPid(pid);
        product.setPname(product.getPname()+" "+port);
        log.info("product info: {}", JSON.toJSONString(product));
        return product;
    }

}
