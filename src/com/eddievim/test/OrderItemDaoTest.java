package com.eddievim.test;

import com.eddievim.dao.OrderItemDao;
import com.eddievim.dao.impl.OrderItemDaoImpl;
import com.eddievim.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderItemDaoTest {
    OrderItemDao orderItemDao = new OrderItemDaoImpl();
    @Test
    public void saveOrderItem() {
        OrderItem orderItem = new OrderItem(null, "book", 1, new BigDecimal(10),  new BigDecimal(10), "ABC23");
        orderItemDao.saveOrderItem(orderItem);
    }
}