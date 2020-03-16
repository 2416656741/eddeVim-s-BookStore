package com.eddievim.test;

import com.eddievim.dao.OrderDao;
import com.eddievim.dao.impl.OrderDaoImpl;
import com.eddievim.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderDaoTest {
    OrderDao orderDao = new OrderDaoImpl();
    @Test
    public void saveOrder() {
        Order order = new Order("ABC236", new Date(), new BigDecimal(100), 0, 1);
        orderDao.saveOrder(order);
    }
}