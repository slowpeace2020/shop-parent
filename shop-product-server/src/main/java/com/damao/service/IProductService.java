package com.damao.service;

import com.damao.domain.Product;

public interface IProductService {
    Product findByPid(Long pid);
}
