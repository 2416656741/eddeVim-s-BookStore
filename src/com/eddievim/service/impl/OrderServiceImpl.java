package com.eddievim.service.impl;

import com.eddievim.dao.BookDao;
import com.eddievim.dao.OrderDao;
import com.eddievim.dao.OrderItemDao;
import com.eddievim.dao.impl.BookDaoImpl;
import com.eddievim.dao.impl.OrderDaoImpl;
import com.eddievim.dao.impl.OrderItemDaoImpl;
import com.eddievim.pojo.*;
import com.eddievim.service.OrderService;

import java.util.Date;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        String orderId = System.currentTimeMillis()+""+userId;
        //根据一个购物车的信息创建订单
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        orderDao.saveOrder(order);

        //对购物车内每一项都创建订单项，并指向上面创建的订单
        for(Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
            CartItem cartItem = entry.getValue();
            //创建订单项
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
            //保持订单项到数据库
            orderItemDao.saveOrderItem(orderItem);

            //book销量与库存修改
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales() + cartItem.getCount());
            book.setStock(book.getStock() - cartItem.getCount());

            bookDao.updateBook(book);
        }

        //清空购物车
        cart.clear();

        return orderId;
    }
}
