package shoestore.data.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    // Data
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "itemId", nullable = false)
    private Integer itemId;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "size", nullable = false)
    private Double size;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "availability", nullable = false)
    private Integer availability;

    //@ManyToMany(mappedBy = "productsInOrder")
    //List<Order> orders;

    @OneToMany(mappedBy = "productObject")
    List<OrderDetail> orderDetails;

    // Constructors
    public Product() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
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
    //    return "Product{" +
    //            "id=" + id +
    //            ", itemId=" + itemId +
    //            ", color='" + color + '\'' +
    //            ", size=" + size +
    //            ", price=" + price +
    //            ", availability=" + availability +
    //            '}';
    //}

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", color='" + color + '\'' +
                ", size=" + size +
                ", price=" + price +
                ", availability=" + availability +
                ", orderDetails=" + orderDetails +
                '}';
    }


}
