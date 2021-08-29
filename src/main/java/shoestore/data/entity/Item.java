package shoestore.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class Item {

    enum Genders {
        MEN, WOMEN, UNISEX, KIDS
    }

    enum Categories {
        CASUAL, RUNNING, HIKING, TRAINING, BASKETBALL, BOOTS, SANDALS
    }

    // Data
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private Genders gender;

    @Column(name = "category")
    private Categories category;

    @Column(name = "starRating")
    private Double starRating;

    @Column(name = "reviewCount")
    private Integer reviewCount;

    @Column(name = "description")
    private String description;

    // Constrcutors
    public Item() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genders getGender() {
        return gender;
    }

    public void setGender(Genders gender) {
        this.gender = gender;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public Double getStarRating() {
        return starRating;
    }

    public void setStarRating(Double starRating) {
        this.starRating = starRating;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Methods
    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", category=" + category +
                ", starRating=" + starRating +
                ", reviewCount=" + reviewCount +
                ", description='" + description + '\'' +
                '}';
    }


    
}
