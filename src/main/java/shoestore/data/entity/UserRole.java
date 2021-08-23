package shoestore.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "userroles")
public class UserRole {
    // Data
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    //@Column(name = "userId")
    //private Integer userId;

    @ManyToOne()
    @JoinColumn(name = "userId")
    private User userObject;

    @Column(name = "role")
    private String role;

    // Constructors
    public UserRole() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //public Integer getUserId() {
    //    return userId;
    //}
    //
    //public void setUserId(Integer userId) {
    //    this.userId = userId;
    //}

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Methods
    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                //", userId=" + userId +
                ", role='" + role + '\'' +
                '}';
    }


}
