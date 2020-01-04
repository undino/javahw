package org.itstep.Entity;

public class Order {
    private int customerId;
    private int sellerId;
    private int productId;

    public Order(int customerId, int sellerId, int productId) {
        this.customerId = customerId;
        this.sellerId = sellerId;
        this.productId = productId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
