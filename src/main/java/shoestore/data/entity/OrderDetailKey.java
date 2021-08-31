package shoestore.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class OrderDetailKey implements Serializable {

    @Column(name = "orderId")
    private Integer orderIdKey;

    @Column(name = "productId")
    private Integer productIdKey;

    public OrderDetailKey() {
    }

    @Override
    public String toString() {
        return "OrderDetailKey{" +
                "orderIdKey=" + orderIdKey +
                ", productIdKey=" + productIdKey +
                '}';
    }

}
