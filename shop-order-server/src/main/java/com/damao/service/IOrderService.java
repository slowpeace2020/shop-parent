package com.damao.service;

import com.damao.domain.Order;

public interface IOrderService {
    Order createOrder(Long productId,Long userId);
}
