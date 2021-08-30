package shoestore.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class OrderDetailKey implements Serializable {

    @Column(name = "orderId")
    Integer orderId;

    @Column(name = "productId")
    Integer productId;

    @Override
    public String toString() {
        return "OrderDetailKey{" +
                "orderId=" + orderId +
                ", productId=" + productId +
                '}';
    }
}
