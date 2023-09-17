package com.damao.service.impl;

import com.damao.dao.ProductDao;
import com.damao.domain.Product;
import com.damao.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public Product findByPid(Long pid) {
        return productDao.findById(pid).get();
    }
}
