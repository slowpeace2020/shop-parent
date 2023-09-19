package com.damao.remote;

import com.damao.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//remote service name
@FeignClient(name="product-service")
public interface ProductService {
    @RequestMapping(method = RequestMethod.GET,value = "/product/{pid}")
    public Product findByPid(@PathVariable("pid") Long pid);

}
