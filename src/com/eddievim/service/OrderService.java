package com.eddievim.service;

import com.eddievim.pojo.Cart;

public interface OrderService {
    public String createOrder(Cart cart, Integer userId);
}
