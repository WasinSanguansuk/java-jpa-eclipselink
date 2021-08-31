package shoestore.data.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@NamedQueries({
        @NamedQuery(name = "findAllOrdersQuery", query = "SELECT o FROM Order o")
})
public class Order {

    enum Status {
        IN_PROCESS, ON_HOLD, SHIPPED, DELIVERED, CANCELLED
    }

    // Data
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "customerId", nullable = false)
    private Integer customerId;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    //@Column(name = "orderedDate")
    //@Temporal(TemporalType.TIMESTAMP)
    //private Date orderedDate;
    @Column(name = "orderedDate", columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime orderedDate;

    //@Column(name = "shippedDate")
    //@Temporal(TemporalType.TIMESTAMP)
    //private Date shippedDate;
    @Column(name = "shippedDate", columnDefinition = "TIMESTAMP")
    private LocalDateTime shippedDate;

    @Column(name = "comments")
    private String comments;

    //@ManyToMany
    //@JoinTable(
    //        name = "order_product",
    //        joinColumns = @JoinColumn(name = "orderId"),
    //        inverseJoinColumns = @JoinColumn(name = "productId"))
    //List<Product> productsInOrder;

    @OneToMany(mappedBy = "orderObject")
    private List<OrderDetail> orderDetails;

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

    //public Date getOrderedDate() {
    //    return orderedDate;
    //}
    //
    //public void setOrderedDate(Date orderedDate) {
    //    this.orderedDate = orderedDate;
    //}
    //
    //public Date getShippedDate() {
    //    return shippedDate;
    //}
    //
    //public void setShippedDate(Date shippedDate) {
    //    this.shippedDate = shippedDate;
    //}

    public LocalDateTime getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(LocalDateTime orderedDate) {
        this.orderedDate = orderedDate;
    }

    public LocalDateTime getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(LocalDateTime shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    // Methods
    //@Override
    //public String toString() {
    //    return "Order{" +
    //            "id=" + id +
    //            ", customerId=" + customerId +
    //            ", status=" + status +
    //            ", orderedDate=" + orderedDate +
    //            ", shippedDate=" + shippedDate +
    //            ", comments='" + comments + '\'' +
    //            '}';
    //}

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", status=" + status +
                ", orderedDate=" + orderedDate +
                ", shippedDate=" + shippedDate +
                ", comments='" + comments + '\'' +
                ", orderDetails=" + orderDetails +
                '}';
    }


}
