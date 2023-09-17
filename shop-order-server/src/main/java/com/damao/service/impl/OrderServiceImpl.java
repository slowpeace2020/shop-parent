package com.damao.service.impl;

import com.alibaba.fastjson.JSON;
import com.damao.dao.OrderDao;
import com.damao.domain.Order;
import com.damao.domain.Product;
import com.damao.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class OrderServiceImpl implements IOrderService {

    @Autowired
   private OrderDao orderDao;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Order createOrder(Long productId, Long userId) {
        log.info("receive order request, query product service to get product info by product id: {}",productId);
        //remote get  product service
        String url ="http://localhost:8081/product/"+productId;

        Product product = restTemplate.getForEntity(url,Product.class).getBody();
        log.info("query product service to get product info : {}", JSON.toJSONString(product));
        //create order
        Order order = new Order();
        order.setUid(userId);
        order.setUsername("damaotest");
        order.setPid(productId);
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);
        orderDao.save(order);
        log.info("create order success! order info: {}",JSON.toJSONString(order));

        return order;
    }
}
