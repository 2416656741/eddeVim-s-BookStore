package com.eddievim.pojo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Integer totalCount;
    private BigDecimal totalPrice;
    private Map<Integer, CartItem> items = new HashMap<>();

    public Cart() {
        this.totalCount = 0;
        this.totalPrice = new BigDecimal(0);
    }

    public void addItem(CartItem cartItem) {
        if(cartItem == null) {
            return;
        }

        this.totalCount += cartItem.getCount();
        this.totalPrice = this.totalPrice.add(cartItem.getTotalPrice());

        if(items.containsKey(cartItem.getId())) {
            CartItem item = items.get(cartItem.getId());
            //更新数量
            item.setCount(cartItem.getCount() + item.getCount());
            //更新总金额
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }else {
            items.put(cartItem.getId(), cartItem);
        }
    }

    public void removeItem(Integer id) {
        CartItem cartItem = items.remove(id);
        if(cartItem != null) {
            this.totalCount -= cartItem.getCount();
            this.totalPrice = this.totalPrice.subtract(cartItem.getTotalPrice());
        }
    }

    public void clear(){
        items.clear();
        this.totalCount = 0;
        this.totalPrice = new BigDecimal(0);
    }

    public void updateCount(Integer id, Integer count) {
        CartItem cartItem = items.get(id);

        if(cartItem != null) {
            if(count <= 0) {
                removeItem(id);
            } else {
                this.totalCount -= cartItem.getCount();
                this.totalPrice = this.totalPrice.subtract(cartItem.getTotalPrice());

                cartItem.setCount(count);
                cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));

                this.totalCount += cartItem.getCount();
                this.totalPrice = this.totalPrice.add(cartItem.getTotalPrice());
            }
        }



    }


    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + totalCount +
                ", totalPrice=" + totalPrice +
                ", items=" + items +
                '}';
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }
}
