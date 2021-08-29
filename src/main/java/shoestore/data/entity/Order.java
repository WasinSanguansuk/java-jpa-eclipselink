package shoestore.data.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

    enum Status {
        IN_PROCESS, ON_HOLD, SHIPPED, DELIVERED, CANCELLED
    }

    // Data
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "customerId")
    private Integer customerId;

    @Column(name = "status")
    private Status status;

    @Column(name = "orderedDate")
    private Date orderedDate;

    @Column(name = "shippedDate")
    private Date shippedDate;

    @Column(name = "comments")
    private String comments;

    // Constructors
    public Order() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(Date orderedDate) {
        this.orderedDate = orderedDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    // Methods
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", status=" + status +
                ", orderedDate=" + orderedDate +
                ", shippedDate=" + shippedDate +
                ", comments='" + comments + '\'' +
                '}';
    }

    
}
