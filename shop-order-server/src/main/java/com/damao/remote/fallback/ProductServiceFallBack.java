package com.damao.remote.fallback;

import com.damao.domain.Product;
import com.damao.remote.ProductService;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceFallBack implements ProductService {
    @Override
    public Product findByPid(Long pid) {
        System.out.println("服务不可用，返回兜底数据");
        return new Product();
    }
}
