package com.eddievim.test;

import com.eddievim.pojo.Cart;
import com.eddievim.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {
    Cart cart = new Cart();

    @Test
    public void addItem() {
        CartItem cartItem = new CartItem(1, "qq", 10, new BigDecimal(5), new BigDecimal(50));
        cart.addItem(cartItem);
        cart.addItem(cartItem);
        System.out.println(cart);
    }

    @Test
    public void removeItem() {
        CartItem cartItem = new CartItem(1, "qq", 10, new BigDecimal(5), new BigDecimal(50));
        cart.addItem(cartItem);
        CartItem cartItem1 = new CartItem(2, "qq", 10, new BigDecimal(5), new BigDecimal(50));
        cart.addItem(cartItem);
        cart.addItem(cartItem1);
        cart.removeItem(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        CartItem cartItem = new CartItem(1, "qq", 10, new BigDecimal(5), new BigDecimal(50));
        cart.addItem(cartItem);
        CartItem cartItem1 = new CartItem(2, "qq", 10, new BigDecimal(5), new BigDecimal(50));
        cart.addItem(cartItem);
        cart.addItem(cartItem1);
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        CartItem cartItem = new CartItem(1, "qq", 10, new BigDecimal(5), new BigDecimal(50));
        cart.addItem(cartItem);
        CartItem cartItem1 = new CartItem(2, "qq", 10, new BigDecimal(5), new BigDecimal(50));
        cart.addItem(cartItem);
        cart.addItem(cartItem1);
        cart.updateCount(1, 66);
        System.out.println(cart);
    }
}