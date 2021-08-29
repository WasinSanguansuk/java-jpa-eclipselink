package shoestore.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orderdetails")
public class OrderDetail {
    // Data
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "orderId")
    private Integer orderId;

    @Column(name = "productId")
    private Integer productId;

    @Column(name = "quantityOrdered")
    private Integer quantityOrdered;

    // Constructors
    public OrderDetail() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(Integer quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    // Methods
    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", productId=" + productId +
                ", quantityOrdered=" + quantityOrdered +
                '}';
    }

    
}
